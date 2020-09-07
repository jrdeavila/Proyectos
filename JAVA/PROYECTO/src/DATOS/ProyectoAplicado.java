/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author moren
 */
public class ProyectoAplicado extends PropuestaGrado implements Serializable{
    private String resumenProblema;
    private List<String> objetivoGeneral;
    private List<String> objetivosEspecificos; 
    private String justificacion;

   
    public ProyectoAplicado(String titulo, String resumenProblema, List<String> objetivoGeneral,
            List<String> objetivosEspecificos, String justificacion, List<Estudiante> integrantes, 
            Docente docenteAcesor, int tiempo, LineaInvestigacion linea, List<LineaInvestigacion> sublineas, Calendar p) {
       
        super(titulo, integrantes, docenteAcesor, tiempo, linea, sublineas, p);
        this.resumenProblema = resumenProblema;
        this.objetivoGeneral = objetivoGeneral;
        this.objetivosEspecificos = objetivosEspecificos;
        this.justificacion = justificacion;
    }

    

    public String getResumenProblema() {
        return resumenProblema;
    }

    public List<String> getObjetivoGeneral() {
        return objetivoGeneral;
    }

    public List<String> getObjetivosEspecificos() {
        return objetivosEspecificos;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setResumenProblema(String resumenProblema) {
        this.resumenProblema = resumenProblema;
    }

    public void setObjetivoGeneral(List<String> objetivoGeneral) {
        this.objetivoGeneral = objetivoGeneral;
    }

    public void setObjetivosEspecificos(List<String> objetivosEspecificos) {
        this.objetivosEspecificos = objetivosEspecificos;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }
    
    @Override
    public void verInfo(){
        this.mostrarInfo();
        System.out.println("\t\tOBJETIVOS GENERALES");
        for(String i : objetivoGeneral){
            System.out.println("- " + i);
        }
        System.out.println("\n\t\tOBJETIVOS ESPECIFICOS");
         for(String i : objetivosEspecificos){
             System.out.println("- " + i);
         }
            System.out.println("\n\t\tRESUMEN DEL PROBLEMA");
        
            System.out.println(this.resumenProblema);
            
            System.out.println("\n\t\tJUSTIFICACION");
            System.out.println(justificacion);
            System.out.println("\n\t\tESTADO: "+  this.getEstado());
            
            System.out.println("\n\t\tRADICADO: " + this.getCodigo());
            
        
         
    }

    
    
}
