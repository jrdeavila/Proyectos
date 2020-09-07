/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

import static LOGICA.CentroOperaciones.asignarDocenteAcesor;
import static LOGICA.CentroOperaciones.buscarPropuesta;
import static LOGICA.CentroOperaciones.buscarUsuario;
import static LOGICA.CentroOperaciones.comprobarDato;
import static LOGICA.CentroOperaciones.mostrarDocentes;
import static LOGICA.CentroOperaciones.mostrarPracticas;
import static LOGICA.CentroOperaciones.mostrarPropuestasAceptadas;
import static LOGICA.CentroOperaciones.mostrarProyectos;
import java.io.Serializable;

/**
 *
 * @author moren
 */
public class IntegranteComite extends Usuario implements Serializable {

    public IntegranteComite(String usuario, String password, String nombre, String apellido, long cedula, long telefono) {
        super(usuario, password, nombre, apellido, cedula, telefono);
    }

    @Override
    public void mostrarInfo() {
        this.mostrar();
    }
    
    @Override
    public boolean verPropuestas(){
        boolean tr = mostrarProyectos();
        tr = mostrarPracticas() && tr;
        return tr;
    }
    
    public void asignarDocentes(){
        if(this.verPropuestas()){
             System.out.print("CODIGO: ");
        long codigo = comprobarDato("CODIGO: ");
        PropuestaGrado p = buscarPropuesta(codigo);
        if(mostrarDocentes()){
            System.out.print("CEDULA: ");
            codigo = comprobarDato("CEDULA: ");
            Usuario docente = buscarUsuario(codigo);
           asignarDocenteAcesor((Docente)docente, p);
            System.out.println("DOCENTE ASIGNADO");
            
        }
        else{
            System.out.println("NO HAY DOCENTES PARA ASIGNAR");
        }
        }
       
        
    }
    
    public void verPropuestasAceptadas(){
        mostrarPropuestasAceptadas();
    }
    
    
    
    
}
