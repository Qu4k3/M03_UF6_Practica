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
        int track = scanner.nextInt();
        String trackS = Integer.toString(track);

        Messages.result();
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = con.prepareStatement(Queries.queryTopPlayersList);
            pstmt.setString(1, trackS);
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

    private static void uploadTime(String url1, String username1, String password1) {

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

        int timeG = Conversor.TimeToMils(time);

        System.out.println("tiempo: " + timeG + "   pista: " + track + "   jugador: " + player);

    }

    private static void addClan(String url, String username, String password) {

    }

    private static void dropClan(String url, String username, String password) {

    }

    private static void editPlayer(String url, String username, String password) {

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

}
