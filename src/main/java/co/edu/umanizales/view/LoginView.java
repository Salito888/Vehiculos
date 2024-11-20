
package co.edu.umanizales.view;

import java.util.Scanner;

public class LoginView {
    private final Scanner scanner = new Scanner(System.in);

    public String[] mostrarLogin() {
        System.out.println("=== Login ===");
        System.out.print("Ingrese su ID: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        return new String[]{id, nombre};
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}


