package utils;

public class Menus {

    public static void menuPrincipal() {
        System.out.println(Colors.ANSI_PURPLE + "- - - - - - - - - - - - - - - - - -"
                + "\n    Que acción deseas realizar ?"
                + "\n" + Colors.ANSI_PURPLE + "- - - - - - - - - - - - - - - - - -");
        System.out.println(Colors.ANSI_YELLOW + "-Consultar" + Colors.ANSI_RESET);       
        System.out.println("1. WR actuales");
        System.out.println("2. Tops españoles por copa");
        System.out.println("");
        System.out.println(Colors.ANSI_YELLOW + "-Tiempos" + Colors.ANSI_RESET);
        System.out.println("3. Añadir tiempo");
        System.out.println("");
        System.out.println(Colors.ANSI_YELLOW + "-Clanes" + Colors.ANSI_RESET);
        System.out.println("4. Añadir un clan");
        System.out.println("5. Editar un clan");
        System.out.println("6. Eliminar un clan");
        System.out.println("");
        System.out.println(Colors.ANSI_YELLOW + "-Jugadores" + Colors.ANSI_RESET);
        System.out.println("7. Añadir un jugador");
        System.out.println("8. Editar un jugador");
        System.out.println("9. Eliminar un jugador");
        System.out.println("");
        System.out.println("0. Salir");
        System.out.println("\n" + Colors.ANSI_CYAN + "// Que desea realizar?\n" + Colors.ANSI_RESET);
        System.out.print(Colors.ANSI_PURPLE + "> " + Colors.ANSI_RESET);
    }

    public static void input() {
        System.out.print("\n" + Colors.ANSI_PURPLE + "> " + Colors.ANSI_RESET);
    }

}
