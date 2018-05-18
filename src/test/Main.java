package test;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import utils.Colors;
import utils.Menus;
import utils.Messages;
import utils.Queries;
import utils.Conversor;

public class Main {

    static Scanner scanner;
    static BufferedReader br;

    static String url = "jdbc:mysql://localhost:3306/mkw_db";
    static String username = "root";
    static String password = "";

    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        int numCase;
        boolean exit = false;

        do {
            Menus.menuPrincipal();

            if (!scanner.hasNextInt()) {
                Messages.inputMustBeInt();
                break;
            } else {
                numCase = scanner.nextInt();
            }

            switch (numCase) {

                case 1:

                    listTopPlayer(url, username, password);

                    break;

                case 2:

                    listTotalTime(url, username, password);

                    break;

                case 3:
                    uploadTime(url, username, password);

                    break;

                case 4:
                    addClan(url, username, password);

                    break;

                case 5:
                    dropClan(url, username, password);

                    break;

                case 6:
                    editPlayer(url, username, password);

                    break;

                case 7:
                    listTracks(url, username, password);
                    break;

                case 8:
                    listPlayers(url, username, password);
                    break;

                case 9:
                    listClans(url, username, password);
                    break;

                case 0:
                    char secExit;
                    Messages.exitSec();
                    Menus.input();
                    secExit = scanner.next().charAt(0);

                    if (secExit == 's') {
                        exit = true;
                        break;
                    } else {
                        break;
                    }

                default:
                    Messages.optionNotFound();
                    break;
            }

            System.out.println(" ");

        } while (exit != true);

    }

    private static void listTopPlayer(String url, String username, String password) {
        int pos = 0;

        Messages.askTrack();
        Menus.input();
        String track = Integer.toString(scanner.nextInt());

        Messages.result();
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = con.prepareStatement(Queries.queryTopPlayersList);
            pstmt.setString(1, track);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                pos += 1;
                String nombre = rs.getString("player_name");
                String time = Conversor.milsToTime(rs.getString("time"));
                System.out.println(pos + " - " + nombre + " - " + time);
            }
        } catch (SQLException ex) {
            while (ex != null) {
                /*System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("Error Code: " + ex.getErrorCode());*/
                System.out.println("Message: " + ex.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
                ex = ex.getNextException();
            }
        }

    }

    private static void listTotalTime(String url, String username, String password) {

        Messages.result();

        int pos = 0;

        try (
                Connection con = DriverManager.getConnection(url, username, password);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(Queries.queryTotalTime);) {
            while (rs.next()) {
                pos += 1;
                String nombre = rs.getString("player_name");
                String totalTime = Conversor.milsToTime(rs.getString("tiempo_total"));
                System.out.println(pos + " - " + nombre + " - " + totalTime);
            }
        } catch (SQLException ex) {
            while (ex != null) {
                /*System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("Error Code: " + ex.getErrorCode());*/
                System.out.println("Message: " + ex.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
                ex = ex.getNextException();
            }
        }
    }

    private static void uploadTime(String url, String username, String password) {

        String time;
        int track, player;

        Messages.askTrack();
        Menus.input();
        track = scanner.nextInt();

        Messages.askPlayer();
        Menus.input();
        player = scanner.nextInt();

        Messages.askTime();
        Menus.input();
        time = scanner.next();

        int timeM = Conversor.TimeToMils(time);

        Messages.result();
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = con.prepareStatement(Queries.queryInsertRun);
            pstmt.setInt(1, player);
            pstmt.setInt(2, track);
            pstmt.setInt(3, timeM);

            int r = pstmt.executeUpdate();
            if (r >= 1) {
                System.out.println("Se ha añadido correctamente un nuevo tiempo");
            } else {
                System.out.println("Ha sucedido algo, vuelve a intentarlo");
            }

        } catch (SQLException ex) {
            while (ex != null) {
                /*System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("Error Code: " + ex.getErrorCode());*/
                System.out.println("Message: " + ex.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
                ex = ex.getNextException();
            }
        }

    }

    private static void addClan(String url, String username, String password) {

        String name, tag;

        Messages.askClanName();
        Menus.input();
        name = scanner.next();

        Messages.askClan();
        Menus.input();
        tag = scanner.next();

        Messages.result();
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = con.prepareStatement(Queries.queryNewClan);
            pstmt.setString(1, name);
            pstmt.setString(2, tag);

            int r = pstmt.executeUpdate();
            if (r >= 1) {
                System.out.println("Se ha añadido correctamente un nuevo clan\ncon nombre " + Colors.ANSI_YELLOW + name + Colors.ANSI_RESET + " y tag " + Colors.ANSI_YELLOW + tag + Colors.ANSI_RESET);
            } else {
                System.out.println("Ha sucedido algo, vuelve a intentarlo");
            }

        } catch (SQLException ex) {
            while (ex != null) {
                /*System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("Error Code: " + ex.getErrorCode());*/
                System.out.println("Message: " + ex.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
                ex = ex.getNextException();
            }
        }

    }

    private static void dropClan(String url, String username, String password) {

        String clan;

        Messages.askClan();
        Menus.input();
        clan = scanner.next();

        Messages.result();
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = con.prepareStatement(Queries.queryDropClan);
            pstmt.setString(1, clan);

            int r = pstmt.executeUpdate();
            if (r >= 1) {
                System.out.println("Se borrado correctamente el clan " + clan);
            } else {
                System.out.println("Ha sucedido algo, vuelve a intentarlo");
            }

        } catch (SQLException ex) {
            while (ex != null) {
                /*System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("Error Code: " + ex.getErrorCode());*/
                System.out.println("Message: " + ex.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
                ex = ex.getNextException();
            }
        }

    }

    private static void editPlayer(String url, String username, String password) {

        int clan_aux;
        String clan, player;

        Messages.askClanId();
        Menus.input();
        clan_aux = scanner.nextInt();
        clan = Integer.toString(clan_aux);

        Messages.askPlayer();
        Menus.input();
        player = Integer.toString(scanner.nextInt());

        Messages.result();
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = con.prepareStatement(Queries.queryUpdatePlayerClan);
            pstmt.setString(1, clan);
            pstmt.setString(2, player);

            int r = pstmt.executeUpdate();
            if (r >= 1) {
                System.out.println("Se ha movido correctamente el jugador " + Colors.ANSI_YELLOW + player + Colors.ANSI_RESET + " a " + Colors.ANSI_YELLOW + clan_aux + Colors.ANSI_RESET);
            } else {
                System.out.println("Ha sucedido algo, vuelve a intentarlo");
            }

        } catch (SQLException ex) {
            while (ex != null) {
                /*System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("Error Code: " + ex.getErrorCode());*/
                System.out.println("Message: " + ex.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
                ex = ex.getNextException();
            }
        }

    }

    private static void listTracks(String url, String username, String password) {

        Messages.result();

        try (
                Connection con = DriverManager.getConnection(url, username, password);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(Queries.queryTracks);) {
            while (rs.next()) {
                String id_departamento = rs.getString("id_track");
                String nombre = rs.getString("name");
                String abrv = rs.getString("abrv");
                System.out.println(id_departamento + " - " + nombre + " - " + Colors.ANSI_PURPLE_BACKGROUND + abrv + Colors.ANSI_RESET);
            }
        } catch (SQLException ex) {
            while (ex != null) {
                /*System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("Error Code: " + ex.getErrorCode());*/
                System.out.println("Message: " + ex.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
                ex = ex.getNextException();
            }
        }
    }

    private static void listPlayers(String url, String username, String password) {

        Messages.result();

        try (
                Connection con = DriverManager.getConnection(url, username, password);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(Queries.queryPlayers);) {
            while (rs.next()) {
                String id_player = rs.getString("id_player");
                String id_clan = rs.getString("id_clan");
                String acronym = rs.getString("acronym");
                String nombre = rs.getString("name");
                System.out.println(id_player + " - " + acronym + "(" + id_clan + ") - " + nombre);
            }
        } catch (SQLException ex) {
            while (ex != null) {
                /*System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("Error Code: " + ex.getErrorCode());*/
                System.out.println("Message: " + ex.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
                ex = ex.getNextException();
            }
        }
    }

    private static void listClans(String url, String username, String password) {

        Messages.result();

        try (
                Connection con = DriverManager.getConnection(url, username, password);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(Queries.queryListClans);) {
            while (rs.next()) {
                String name = rs.getString("name");
                String acronym = rs.getString("acronym");
                String id_clan = rs.getString("id_clan");
                System.out.println(name + " - " + acronym + "(" + id_clan + ")");
            }
        } catch (SQLException ex) {
            while (ex != null) {
                /*System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("Error Code: " + ex.getErrorCode());*/
                System.out.println("Message: " + ex.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
                ex = ex.getNextException();
            }
        }
    }

}
