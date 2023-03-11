package ejercicios;

/**
 *
 * @author scorpion
 */
public class Persona {
    private String nombre;
    private String apellido;
    private int anio;

    public Persona() {
    }

    public Persona(String nombre, String apellido, int anio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.anio = anio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
}
