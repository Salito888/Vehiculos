
package co.edu.umanizales.model;

public class Furgoneta extends AbstractVehiculo {
    private final short capacidad;

    public Furgoneta(String matricula, int km, double valorAlquiler, short capacidad) {
        super(matricula, km, valorAlquiler);
        this.capacidad = capacidad;
    }

    @Override
    public double calcularAlquiler(int km) {
        return valorAlquiler * km * (1 + capacidad/100.0);
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println(" Capacidad de carga: " + capacidad + "kg");
    }
}
