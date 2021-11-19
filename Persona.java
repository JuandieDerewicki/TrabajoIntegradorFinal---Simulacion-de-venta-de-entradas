package TRABAJOFINALLAB;

public abstract class Persona {

    private Integer DNI;
    private String nombre;
    private String apellido;

    public Persona(Integer DNI, String nombre, String apellido) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona() {
    }


    public Integer getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setDNI(Integer DNI) {
        this.DNI = DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "DNI=" + DNI +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
