
package co.edu.umanizales.utils;

import co.edu.umanizales.model.Vehiculo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehiculoCSVUtils {
    public static List<Vehiculo> cargarVehiculos(String rutaArchivo) throws IOException {
        List<Vehiculo> vehiculos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            br.readLine(); // Omitir cabecera
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Vehiculo vehiculo = new Vehiculo(
                        datos[0],
                        datos[1],
                        Boolean.parseBoolean(datos[2]),
                        datos[3]
                );
                vehiculos.add(vehiculo);
            }
        }
        return vehiculos;
    }

    public static void guardarVehiculos(String rutaArchivo, List<Vehiculo> vehiculos) throws IOException {
        try (FileWriter fw = new FileWriter(rutaArchivo)) {
            fw.write("ID,Tipo,Disponible,Condiciones\n"); // Cabecera
            for (Vehiculo vehiculo : vehiculos) {
                fw.write(vehiculo.getId() + "," +
                        vehiculo.getTipo() + "," +
                        vehiculo.isDisponible() + "," +
                        vehiculo.getCondiciones() + "\n");
            }
        }
    }

    public static String cargarUsuarios(String archivoCsv) {
        return archivoCsv;
    }

    public static void guardarUsuarios(String archivoCsv, String usuarios) {
    }
}




