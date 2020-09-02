
package DATOS;

import java.io.Serializable;


public abstract class Persona implements Serializable{
    private String nombre, apellido;
    private long cedula, telefono;

    public Persona(String nombre, String apellido, long cedula, long telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public long getCedula() {
        return cedula;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    
    public void mostrar(){
        System.out.printf("CEDULA: %d\nNOMBRE: %s %s\nTELEFONO: %d\n",
                this.getCedula(), this.getApellido(), this.getNombre(), this.getTelefono());
    }
    
    public abstract void mostrarInfo();
}
