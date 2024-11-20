
package co.edu.umanizales.service;

import co.edu.umanizales.model.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private final String archivoUsuarios = "data/usuarios.csv";

    public List<Usuario> listarUsuarios() throws IOException {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoUsuarios))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                usuarios.add(Usuario.fromCSV(linea));
            }
        }
        return usuarios;
    }

    public Usuario autenticar(String id, String nombre) throws IOException {
        List<Usuario> usuarios = listarUsuarios();
        for (Usuario u : usuarios) {
            if (u.getId().equals(id) && u.getNombre().equals(nombre)) {
                return u;
            }
        }
        return null;
    }

    public void registrarUsuario(Usuario usuario) throws IOException {
        List<Usuario> usuarios = listarUsuarios();
        usuarios.add(usuario);
        guardarUsuarios(usuarios);
    }

    private void guardarUsuarios(List<Usuario> usuarios) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoUsuarios))) {
            for (Usuario u : usuarios) {
                writer.write(u.toString() + "\n");
            }

        }
    }

    public String autenticarCredenciales(String credenciales, String credenciales1) {
        return credenciales;
    }
}

