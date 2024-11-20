
package co.edu.umanizales.model;

public class Coche extends AbstractVehiculo {
    private final boolean extras;

    public Coche(String matricula, int km, double valorAlquiler, boolean extras) {
        super(matricula, km, valorAlquiler);
        this.extras = extras;
    }

    @Override
    public double calcularAlquiler(int km) {
        return valorAlquiler * km * (extras? 1.2 : 1.0); // Si es true en extras se le aplica un 20%
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println(" Extras: " + (extras ? "Si" : "No"));
    }
}
