package utils;

public class Menus {

    public static void menuPrincipal() {
        System.out.println(Colors.ANSI_PURPLE + "- - - - - - - - - - - - - - - - - -"
                + "\n     Que consulta deseas realizar ?"
                + "\n" + Colors.ANSI_PURPLE + "- - - - - - - - - - - - - - - - - -");
        System.out.println(Colors.ANSI_YELLOW + "-Consultar" + Colors.ANSI_RESET);       
        System.out.println("1. Datos del empleado con el máximo salario");
        System.out.println("2. Datos de los empleados de un determinado departamento");
        System.out.println("");
         System.out.println(Colors.ANSI_YELLOW + "-Altas/bajas" + Colors.ANSI_RESET);
        System.out.println("3. Dar de baja empleado");
        System.out.println("4. Dar de alta empleado");
        System.out.println("");
        System.out.println("5. Salir");
        System.out.println("\n" + Colors.ANSI_CYAN + "// Que desea realizar?\n" + Colors.ANSI_RESET);
        System.out.print(Colors.ANSI_PURPLE + "> " + Colors.ANSI_RESET);
    }

    public static void input() {
        System.out.print("\n" + Colors.ANSI_PURPLE + "> " + Colors.ANSI_RESET);
    }

}
