package test;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import utils.Menus;
import utils.Messages;
import utils.Queries;
import utils.Conversor;

public class Main {

    static Scanner scanner;
    static BufferedReader br;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        int numCase;
        boolean exit = false;

        db_conn();

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

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:
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

    private static void db_conn() {
        String url = "jdbc:mysql://localhost:3306/mkw_db";
        String username = "root";
        String password = "";        

        try (
                Connection con = DriverManager.getConnection(url, username, password);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(Queries.queryTopPlayersList);) {
            while (rs.next()) {
                String id_departamento = rs.getString("player_name");
                String nombre = rs.getString("nationality");
                
                String time = Conversor.milToTime(rs.getString("time"));
                System.out.println(id_departamento + "; " + nombre + "; " + time);
            }
        } catch (SQLException ex) {
            while (ex != null) {
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("Error Code: " + ex.getErrorCode());
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
