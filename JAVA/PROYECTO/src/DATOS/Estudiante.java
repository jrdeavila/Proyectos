/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

import LOGICA.CentroOperaciones;
import static LOGICA.CentroOperaciones.agregarPropuesta;
import static LOGICA.CentroOperaciones.buscarPropuesta;
import java.io.Serializable;

/**
 *
 * @author moren
 */
public class Estudiante extends Persona implements Serializable{

    private String carrera;
    public Estudiante(String nombre, String apellido, long cedula, long telefono, String carrera) {
        super(nombre, apellido, cedula, telefono);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    @Override
    public void mostrarInfo() {
        this.mostrar();
        System.out.printf("CARRERA: %s\n", this.carrera);
    }
    
    public void verEstadoPropuesta(long radicado){
        PropuestaGrado p = buscarPropuesta(radicado);
        p.mostrarInfo();
    }
    
    
    
}
