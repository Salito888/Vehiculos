
package co.edu.umanizales.service;

import co.edu.umanizales.model.Vehiculo;
import co.edu.umanizales.utils.VehiculoCSVUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehiculoService {
    private static final String ARCHIVO_CSV = "vehiculos.csv";
    private List<Vehiculo> vehiculos;

    public VehiculoService() {
        try {
            vehiculos = VehiculoCSVUtils.cargarVehiculos(ARCHIVO_CSV);
        } catch (IOException e) {
            vehiculos = new ArrayList<>();
            System.out.println("Error al cargar vehículos desde el archivo CSV: " + e.getMessage());
        }
    }

    public List<Vehiculo> obtenerVehiculos() {
        return vehiculos;
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        guardarCambios();
    }

    public Vehiculo obtenerVehiculoPorId(String id) {
        return vehiculos.stream()
                .filter(vehiculo -> vehiculo.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    public void actualizarVehiculo(Vehiculo vehiculo) {
        Vehiculo vehiculoExistente = obtenerVehiculoPorId(vehiculo.getId());
        if (vehiculoExistente != null) {
            vehiculoExistente.setTipo(vehiculo.getTipo());
            vehiculoExistente.setDisponible(vehiculo.isDisponible());
            vehiculoExistente.setCondiciones(vehiculo.getCondiciones());
            guardarCambios();
        }
    }

    public boolean eliminarVehiculo(String id) {
        boolean eliminado = vehiculos.removeIf(vehiculo -> vehiculo.getId().equalsIgnoreCase(id));
        if (eliminado) {
            guardarCambios();
        }
        return eliminado;
    }

    private void guardarCambios() {
        try {
            VehiculoCSVUtils.guardarVehiculos(ARCHIVO_CSV, vehiculos);
        } catch (IOException e) {
            System.out.println("Error al guardar los cambios en el archivo CSV: " + e.getMessage());
        }
    }
}


