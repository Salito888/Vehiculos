
package co.edu.umanizales.model;

public class Usuario {
    private String id;
    private String nombre;
    private int edad;
    private String tipo; // "Usuario" o "Administrador"
    private String condiciones; // Ejemplo: "Visión limitada", "Sin restricciones"

    public Usuario(String id, String nombre, int edad, String tipo, String condiciones) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = tipo;
        this.condiciones = condiciones;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getCondiciones() { return condiciones; }
    public void setCondiciones(String condiciones) { this.condiciones = condiciones; }

    @Override
    public String toString() {
        return id + "," + nombre + "," + edad + "," + tipo + "," + condiciones;
    }

    public static Usuario fromCSV(String linea) {
        String[] datos = linea.split(",");
        return new Usuario(datos[0], datos[1], Integer.parseInt(datos[2]), datos[3], datos[4]);
    }
}


