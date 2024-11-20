
package co.edu.umanizales.view;

import java.util.Scanner;

public class MenuUsuarioView {
    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n=== Menú Usuario ===");
        System.out.println("1. Ver vehículos disponibles");
        System.out.println("2. Alquilar vehículo");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public String obtenerIdVehiculo() {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el ID del vehículo a alquilar: ");
        return scanner.nextLine();
    }
}


