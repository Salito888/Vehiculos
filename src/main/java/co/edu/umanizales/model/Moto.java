
package co.edu.umanizales.model;

public class Moto extends AbstractVehiculo {
    private final boolean casco;

    public Moto (String matricula, int km, double valorAlquiler, boolean casco) {
        super(matricula, km, valorAlquiler);
        this.casco = casco;
    }

    @Override
    public double calcularAlquiler(int km) {
        return valorAlquiler * km * (casco ? 1.1 : 1.0);
    }
}
