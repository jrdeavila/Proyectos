
package DATOS;

import static LOGICA.CentroOperaciones.actualizarEstadoPropuesta;
import static LOGICA.CentroOperaciones.buscarPropuesta;
import static LOGICA.CentroOperaciones.comprobarDato;
import static LOGICA.CentroOperaciones.mostrarPracticas;
import static LOGICA.CentroOperaciones.mostrarProyectos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Docente extends Usuario implements Serializable{
    
    private List<LineaInvestigacion> lineaTrabajo;
    private List<PropuestaGrado> proyectosAsignados;

    public Docente(List<LineaInvestigacion> lineaTrabajo, String usuario, String password, String nombre, String apellido, long cedula, long telefono) {
        super(usuario, password, nombre, apellido, cedula, telefono);
        this.lineaTrabajo = lineaTrabajo;
        this.proyectosAsignados = new ArrayList();
    }
    
    public Docente(String nombre, String apellido, long cedula, long telefono){
        super("DEFAULT", "DEFAULT", nombre, apellido, cedula,telefono);
        
    }


    public List<LineaInvestigacion> getLineaTrabajo() {
        return lineaTrabajo;
    }

    public List<PropuestaGrado> getProyectosAsignados() {
        return proyectosAsignados;
    }

    public void setLineaTrabajo(List<LineaInvestigacion> lineaTrabajo) {
        this.lineaTrabajo = lineaTrabajo;
    }

    public void setProyectosAsignados(List<PropuestaGrado> proyectosAsignados) {
        this.proyectosAsignados = proyectosAsignados;
    }
    
    @Override
    public void mostrarInfo() {
        this.mostrar();
        System.out.println("\t\tLINEAS DE TRABAJO");
        for(LineaInvestigacion i : lineaTrabajo){
            i.mostrar();
        }
        
        
     
    }
    public boolean verHistorialPropuestas(){
        if(!proyectosAsignados.isEmpty()){
           for(PropuestaGrado i : proyectosAsignados){
               if(i  instanceof ProyectoAplicado){
                       System.out.printf("ESTADO: %s    CODIGO: %d  PROYECTO APLICADO: %s     # ESTUDIANTES:  %d\n",
                               i.getEstado(), i.getCodigo(), ((ProyectoAplicado) i).getJustificacion(), i.getIntegrantes().size());
                 }
               if(i  instanceof PracticasEmpresariales){
                        System.out.printf("ESTADO: %s   CODIGO: %d    DATOS DE LA EMPRESA: %s      NIT: %d     # ESTUDIANTES: %d\n", 
                               i.getEstado(), i.getCodigo(), ((PracticasEmpresariales) i).getDatosEmpresa(), 
                                  ((PracticasEmpresariales) i).getNIT(), i.getIntegrantes().size());
                    }
           }
           return true;
       }
        else{
            System.out.println("HISTORIAL VACIO");
           return false;
        }
    }
    @Override
    public boolean verPropuestas(){
       if(!proyectosAsignados.isEmpty()){
           for(PropuestaGrado i : proyectosAsignados){
               if("PENDIENTE".equals(i.getEstado())){
                    if(i  instanceof ProyectoAplicado){
                       System.out.printf("CODIGO: %d  PROYECTO APLICADO: %s     # ESTUDIANTES:  %d\n",
                               i.getCodigo(), ((ProyectoAplicado) i).getJustificacion(), i.getIntegrantes().size());
                 }
               if(i  instanceof PracticasEmpresariales){
                        System.out.printf("CODIGO: %d    DATOS DE LA EMPRESA: %s      NIT: %d     # ESTUDIANTES: %d\n", 
                               i.getCodigo(), ((PracticasEmpresariales) i).getDatosEmpresa(), 
                                  ((PracticasEmpresariales) i).getNIT(), i.getIntegrantes().size());
                    }
               }
              
           }
           return true;
       }
       else{
           System.out.println("NO HAY PROYECTO ASIGNADOS");
           return false;
       }
    }
    
    
    public void evaluarPropuesta(){
        if(this.verPropuestas()){
            System.out.print("CODIGO-PROPUESTA: ");
            long codigo = comprobarDato("CODIGO-PROPUESTA: ");
            PropuestaGrado l = buscarPropuesta(codigo);
            l.verInfo();
            actualizarEstadoPropuesta(l);
        }
        
        
    }
    
}
