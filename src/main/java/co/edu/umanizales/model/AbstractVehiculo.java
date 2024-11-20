
package co.edu.umanizales.model;

public abstract class AbstractVehiculo {
    public String matricula;
    protected int km;
    public boolean estado;
    protected double valorAlquiler;

    public AbstractVehiculo (String matricula, int km, double valorAlquiler) {
        this.matricula = matricula;
        this.km = km;
        this.estado = true;
        this.valorAlquiler = valorAlquiler;
    }

    public void alquilar() {
        if (estado) {
            estado = false;
            System.out.println(" Vehiculo " + matricula + " Alquilado ");
        } else {
            System.out.println(" Vehiculo " + matricula + " Ya está alquilado ");
        }
    }
    public void devolver(int kmFinal, int numDias) {
        if (!estado) {
            this.km += kmFinal;
            estado = true;
            System.out.println(" Vehiculo " + matricula + " Devuelto ");
        } else {
            System.out.println(" Vehiculo " + matricula + " Ya está disponible ");
        }

    }
    public abstract double calcularAlquiler(int km);

    public void mostrarDatos() {
        System.out.println(" Matrícula: " + matricula);
        System.out.println(" Kilómetros: " + km);
        System.out.println(" Estado: " + (estado? " Disponible" : "Alquilado"));
        System.out.println(" Valor del Alquiler: " + valorAlquiler);
    }
}
