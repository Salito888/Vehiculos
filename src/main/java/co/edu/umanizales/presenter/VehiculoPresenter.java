
package co.edu.umanizales.presenter;

import co.edu.umanizales.model.Vehiculo;
import co.edu.umanizales.service.VehiculoService;
import co.edu.umanizales.utils.ReportePDFUtils;
import co.edu.umanizales.view.MenuAdminView;

import java.util.List;


public class VehiculoPresenter {
    private final VehiculoService vehiculoService = new VehiculoService();
    private final MenuAdminView menuAdminView = new MenuAdminView();

    public void mostrarMenu() {
        int opcion;
        do {
            opcion = menuAdminView.mostrarMenu();
            switch (opcion) {
                case 1:
                    listarVehiculos();
                    break;
                case 2:
                    agregarVehiculo();
                    break;
                case 3:
                    editarVehiculo();
                    break;
                case 4:
                    eliminarVehiculo();
                    break;
                case 5:
                    cambiarDisponibilidad();
                    break;
                case 6:
                    generarReportePDF();
                    break;
                case 0:
                    System.out.println("Saliendo del menú de administrador...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private void listarVehiculos() {
        List<Vehiculo> vehiculos = vehiculoService.obtenerVehiculos();
        System.out.println("\n=== Lista de Vehículos ===");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo);
        }
    }

    private void agregarVehiculo() {
        String[] datos = menuAdminView.agregarVehiculo();
        try {
            Vehiculo vehiculo = new Vehiculo(datos[0], datos[1], true, datos[2]);
            vehiculoService.agregarVehiculo(vehiculo);
            System.out.println("Vehículo agregado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar vehículo: " + e.getMessage());
        }
    }

    private void editarVehiculo() {
        String id = menuAdminView.obtenerIdVehiculo();
        Vehiculo vehiculo = vehiculoService.obtenerVehiculoPorId(id);
        if (vehiculo != null) {
            String[] datos = menuAdminView.agregarVehiculo();
            vehiculo.setTipo(datos[1]);
            vehiculo.setCondiciones(datos[2]);
            vehiculoService.actualizarVehiculo(vehiculo);
            System.out.println("Vehículo actualizado correctamente.");
        } else {
            System.out.println("Vehículo no encontrado.");
        }
    }

    private void eliminarVehiculo() {
        String id = menuAdminView.obtenerIdVehiculo();
        if (vehiculoService.eliminarVehiculo(id)) {
            System.out.println("Vehículo eliminado correctamente.");
        } else {
            System.out.println("Vehículo no encontrado.");
        }
    }

    private void cambiarDisponibilidad() {
        String id = menuAdminView.obtenerIdVehiculo();
        Vehiculo vehiculo = vehiculoService.obtenerVehiculoPorId(id);
        if (vehiculo != null) {
            vehiculo.setDisponible(!vehiculo.isDisponible());
            vehiculoService.actualizarVehiculo(vehiculo);
            System.out.println("Disponibilidad del vehículo actualizada.");
        } else {
            System.out.println("Vehículo no encontrado.");
        }
    }

    private void generarReportePDF() {
        try {
            List<Vehiculo> vehiculos = vehiculoService.obtenerVehiculos();
            String rutaArchivo = "reporte_vehiculos.pdf";
            new ReportePDFUtils().generarReporte(vehiculos, rutaArchivo);
            System.out.println("Reporte PDF generado correctamente: " + rutaArchivo);
        } catch (Exception e) {
            System.out.println("Error al generar el reporte PDF: " + e.getMessage());
        }
    }
}


