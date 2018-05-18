package utils;

public class Menus {

    public static void menuPrincipal() {
        System.out.println(Colors.ANSI_PURPLE + "- - - - - - - - - - - - - - - - - -"
                + "\n    Que acción deseas realizar ?"
                + "\n" + Colors.ANSI_PURPLE + "- - - - - - - - - - - - - - - - - -");
        System.out.println(Colors.ANSI_YELLOW + "-Consultar" + Colors.ANSI_RESET);       
        System.out.println("1. Tops españoles por pista");
        System.out.println("2. Tops españoles tiempo total");
        System.out.println("");
        System.out.println(Colors.ANSI_YELLOW + "-Tiempos" + Colors.ANSI_RESET);
        System.out.println("3. Añadir tiempo");
        System.out.println("");
        System.out.println(Colors.ANSI_YELLOW + "-Clanes" + Colors.ANSI_RESET);
        System.out.println("4. Añadir un clan");
        System.out.println("5. Eliminar un clan");
        System.out.println("");
        System.out.println(Colors.ANSI_YELLOW + "-Jugadores" + Colors.ANSI_RESET);
        System.out.println("6. Editar un jugador");
        System.out.println("");
        System.out.println(Colors.ANSI_YELLOW + "-Ayuda" + Colors.ANSI_RESET);
        System.out.println("7. Listar abreviaciones de pistas");
        System.out.println("8. Listar IDs de jugadores");        
        System.out.println("");
        System.out.println("0. Salir");
        System.out.println("\n" + Colors.ANSI_CYAN + "// Que desea realizar?\n" + Colors.ANSI_RESET);
        System.out.print(Colors.ANSI_PURPLE + "> " + Colors.ANSI_RESET);
    }

    public static void input() {
        System.out.print("\n" + Colors.ANSI_PURPLE + "> " + Colors.ANSI_RESET);
    }

}
