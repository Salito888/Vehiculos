
package co.edu.umanizales.model;

public class Vehiculo {
    private String id;
    private String tipo; // "Coche", "Moto", etc.
    private boolean disponible; // true: disponible, false: alquilado
    private String condiciones; // Condiciones del vehículo

    public Vehiculo(String id, String tipo, boolean disponible, String condiciones) {
        this.id = id;
        this.tipo = tipo;
        this.disponible = disponible;
        this.condiciones = condiciones;
    }

    // Getters, Setters y Métodos Auxiliares
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    public String getCondiciones() { return condiciones; }
    public void setCondiciones(String condiciones) { this.condiciones = condiciones; }

    @Override
    public String toString() {
        return id + "," + tipo + "," + disponible + "," + condiciones;
    }

    public static Vehiculo fromCSV(String linea) {
        String[] datos = linea.split(",");
        return new Vehiculo(datos[0], datos[1], Boolean.parseBoolean(datos[2]), datos[3]);
    }
}


