
package co.edu.umanizales.controller;

import co.edu.umanizales.model.AbstractVehiculo;
import co.edu.umanizales.model.Coche;
import co.edu.umanizales.model.Furgoneta;
import co.edu.umanizales.model.Moto;
import co.edu.umanizales.service.GestionVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")

public class AlquilerVehiculosController {

    @Autowired
    private GestionVehiculoService gestionVehiculoService;


    // Para Alquilar un vehículo
    @PostMapping("/alquilar/{matricula}")
    public String alquilarVehiculo(@PathVariable String matricula) {
        AbstractVehiculo vehiculo = gestionVehiculoService.buscarVehiculoPorMatricula(matricula);
        if (vehiculo!= null) {
            return gestionVehiculoService.alquilarVehiculo(vehiculo);
        } else {
            return " Vehículo No encontrado";
        }
    }

    // Para devolver un vehículo
    @PostMapping("/devolver/{matricula}")
    public String devolverVehiculo( @PathVariable String matricula, @RequestParam int kmFinal, @RequestParam int numDias) {
        AbstractVehiculo vehiculo = gestionVehiculoService.buscarVehiculoPorMatricula(matricula);
        if (vehiculo!= null) {
            return gestionVehiculoService.devolverVehiculo(vehiculo, kmFinal, numDias);
        } else {
            return " Vehículo No encontrado";
        }
    }

    // Para obtener vehículos disponibles por tipo
    @GetMapping("/disponibles")
    public List<AbstractVehiculo> obtenerVehiculosDisponiblesPorTipo(@RequestParam String tipo) {
        Class<?> tipoClase = tipo.equalsIgnoreCase("Moto") ? Moto.class : tipo.equalsIgnoreCase("Coche") ? Coche.class : tipo.equalsIgnoreCase("Furgoneta") ? Furgoneta.class : null;
        if (tipoClase != null) {
            return gestionVehiculoService.obtenerVehiculosPorTipo(tipoClase);
        } else {
            return List.of();
        }

    }
    // Para listar todos los vehículos alquilados
    public List<AbstractVehiculo> listarVehiculosAlquilados() {
        return gestionVehiculoService.listarVehiculosAlquilados();
    }
    // Para registrar un nuevo vehículo
    @PostMapping("/registrar")
    public String registrarVehiculo(@RequestBody AbstractVehiculo vehiculo) {
        gestionVehiculoService.registrarVehiculo(vehiculo);
        return " El vehículo fue registrado exitosamente ";
    }
}
