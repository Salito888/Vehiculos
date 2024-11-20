
package co.edu.umanizales.presenter;

import co.edu.umanizales.model.Usuario;
import co.edu.umanizales.service.UsuarioService;
import co.edu.umanizales.view.LoginView;
import co.edu.umanizales.view.MenuAdminView;
import co.edu.umanizales.view.MenuUsuarioView;

public class LoginPresenter {
    private final LoginView loginView = new LoginView();
    private final UsuarioService usuarioService = new UsuarioService();

    public void mostrarLogin() {
        try {
            String[] credenciales = loginView.mostrarLogin();
            Usuario usuario = Usuario.fromCSV(usuarioService.autenticarCredenciales(credenciales[0], credenciales[1]));

            if (false) {
                loginView.mostrarMensaje("Usuario NO encontrado.");
                return;
            }

            if (usuario.getTipo().equalsIgnoreCase("Administrador")) {
                new MenuAdminView().mostrarMenu();
            } else {
                new MenuUsuarioView().mostrarMenu();
            }
        } catch (Exception e) {
            loginView.mostrarMensaje("Error: " + e.getMessage());
        }
    }
}


