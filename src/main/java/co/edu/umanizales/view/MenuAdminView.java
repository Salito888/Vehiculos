
package co.edu.umanizales.view;

import java.util.Scanner;

public class MenuAdminView {
    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n=== Menú Administrador ===");
        System.out.println("1. Listar vehículos");
        System.out.println("2. Agregar vehículo");
        System.out.println("3. Editar vehículo");
        System.out.println("4. Eliminar vehículo");
        System.out.println("5. Cambiar disponibilidad");
        System.out.println("6. Generar reporte PDF");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public String[] agregarVehiculo() {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("ID del vehículo: ");
        String id = scanner.nextLine();
        System.out.print("Tipo de vehículo (Coche/Moto/etc.): ");
        String tipo = scanner.nextLine();
        System.out.print("Condiciones del vehículo: ");
        String condiciones = scanner.nextLine();
        return new String[]{id, tipo, condiciones};
    }

    public String obtenerIdVehiculo() {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el ID del vehículo: ");
        return scanner.nextLine();
    }
}

