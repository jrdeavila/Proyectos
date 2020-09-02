/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.LineaInvestigacion;
import DATOS.Usuario;
import static LOGICA.CentroOperaciones.agregarLinea;
import static LOGICA.CentroOperaciones.agregarSublinea;
import static LOGICA.CentroOperaciones.agregarUsuarios;
import static LOGICA.CentroOperaciones.buscarLinea;
import static LOGICA.CentroOperaciones.diligenciarLinea;
import static LOGICA.CentroOperaciones.mostrarAllLineas;
import static LOGICA.CentroOperaciones.mostrarAllUsuarios;
import static LOGICA.CentroOperaciones.mostrarSublineas;

/**
 *
 * @author moren
 */
public class Administrador extends Usuario{

    public Administrador(String usuario, String password, String nombre, String apellido, long cedula, long telefono) {
        super(usuario, password, nombre, apellido, cedula, telefono);
    }
     
    @Override
    public void mostrarInfo() {
        this.mostrar();
    }
    
    public void agregarLineas(){
        LineaInvestigacion p = diligenciarLinea();
        agregarLinea(p);
    }
    
    public void asignarHorarios(){
        
    }
    
    public boolean agregarUsuario(Usuario p){
        return agregarUsuarios(p);
    }

    @Override
    public boolean verPropuestas() {
        return false;
    }
    
    public void mostrarLineas(){
        mostrarAllLineas();
    }
    
    public void agregarSublineas(){
        agregarSublinea();
    }
    
    
    public void mostrarSublinea(){
        LineaInvestigacion p = buscarLinea();
       if(p != null){
           mostrarSublineas(p);
       }
    }
    
    public void verListadoUsuarios(){
        mostrarAllUsuarios();
    }
    
}
