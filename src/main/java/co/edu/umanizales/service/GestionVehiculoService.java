
package co.edu.umanizales.service;

import co.edu.umanizales.model.AbstractVehiculo;
import co.edu.umanizales.model.Coche;
import co.edu.umanizales.model.Furgoneta;
import co.edu.umanizales.model.Moto;

import java.util.ArrayList;
import java.util.List;

public class GestionVehiculoService {
    private final List<AbstractVehiculo>lstVehiculos = new ArrayList<>();


    public void llenarVehiculos() {
        lstVehiculos.add(new Moto("HHJ796", 5000, 10.0, true));
        lstVehiculos.add(new Coche("DEF444", 3000, 15.0, true));
        lstVehiculos.add(new Furgoneta("SGH888", 7000, 20.0, (short) 1000));

    }

    // Registrar vehículo en sistema
    public void registrarVehiculo(AbstractVehiculo veh) {
        lstVehiculos.add(veh);

    }

    // Buscar un vehículo por Matrícula
    public AbstractVehiculo buscarVehiculoPorMatricula(String matricula) {
        for (AbstractVehiculo vehiculo : lstVehiculos) {
            if (vehiculo.matricula.equals(matricula)) {
                return vehiculo;
            }
        }
        return null;  // Si no se encuentra el vehículo, esto es lo que retorna
    }

    // Obtener vehículos disponibles por tipo
    public List<AbstractVehiculo> obtenerVehiculosPorTipo(Class<?>tipo) {
        List<AbstractVehiculo> vehiculosPorTipo = new ArrayList<>();
        for (AbstractVehiculo vehiculo : lstVehiculos) {
            if (tipo.isInstance(vehiculo) && vehiculo.estado) {
                vehiculosPorTipo.add(vehiculo);
            }
        }
        return vehiculosPorTipo;

    }
    // Para alquilar un vehículo
    public String alquilarVehiculo(AbstractVehiculo vehiculo) {
        if (vehiculo.estado) {
            vehiculo.alquilar();
            return " El vehículo fue alquilado con éxito ";
        }
        return " El vehículo No está disponible ";
    }
    // Para devolver un vehículo
    public String devolverVehiculo(AbstractVehiculo vehiculo, int kmFinal, int numDias) {
        if (!vehiculo.estado) {
            vehiculo.devolver( kmFinal, numDias );
            return " El vehículo fue devuelto con éxito ";
        }
        return " El vehículo ya está disponible ";
    }
    // Para listar todos los vehículos alquilados
    public List<AbstractVehiculo> listarVehiculosAlquilados() {
        List<AbstractVehiculo> vehiculosAlquilados = new ArrayList<>();
        for (AbstractVehiculo vehiculo : lstVehiculos) {
            if (!vehiculo.estado) {
                vehiculosAlquilados.add(vehiculo);
            }
        }
        return vehiculosAlquilados;
    }

}