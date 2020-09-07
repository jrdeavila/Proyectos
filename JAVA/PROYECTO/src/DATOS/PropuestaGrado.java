/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

/**
 *
 * @author moren
 */
public abstract class PropuestaGrado implements Icodigo, Serializable{
    private List<Estudiante> integrantes;
    private Docente docenteAcesor;
    private int tiempo;
    private LineaInvestigacion linea;
    private List<LineaInvestigacion> sublineas;
    private long codigo;
    private List<String> comentarios;
    private List<Resultado> resultados;
    private Docente docenteEvaluador;
    private Calendar p;
    private String Estado = "PENDIENTE";
    private String titulo;


    public PropuestaGrado(String titulo, List<Estudiante> integrantes, Docente docenteAcesor, int tiempo, LineaInvestigacion linea, List<LineaInvestigacion> sublineas, Calendar p) {
        this.integrantes = integrantes;
        this.docenteAcesor = docenteAcesor;
        this.tiempo = tiempo;
        this.linea = linea;
        this.sublineas = sublineas;
        this.comentarios = new ArrayList();
        this.resultados = new ArrayList();
        this.p = p;
        this.titulo = titulo;
        this.codigo = LOGICA.Extras.generarCodigo();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public Docente getDocenteEvaluador() {
        return docenteEvaluador;
    }

    public void setDocenteEvaluador(Docente docenteEvaluador) {
        this.docenteEvaluador = docenteEvaluador;
    }

 
    public Calendar getP() {
        return p;
    }

    public String getEstado() {
        return Estado;
    }

    public void setP(Calendar p) {
        this.p = p;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    

    public List<Estudiante> getIntegrantes() {
        return integrantes;
    }

    public Docente getDocenteAcesor() {
        return docenteAcesor;
    }

    public int getTiempo() {
        return tiempo;
    }

    public LineaInvestigacion getLinea() {
        return linea;
    }

    public List<LineaInvestigacion> getSublineas() {
        return sublineas;
    }

    public long getCodigo() {
        return codigo;
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setIntegrantes(List<Estudiante> integrantes) {
        this.integrantes = integrantes;
    }

    public void setDocenteAcesor(Docente docenteAcesor) {
        this.docenteAcesor = docenteAcesor;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void setLinea(LineaInvestigacion linea) {
        this.linea = linea;
    }

    public void setSublineas(List<LineaInvestigacion> sublineas) {
        this.sublineas = sublineas;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }
    
    
    @Override
    public long getKeys(){
        return this.getCodigo();
    }
    
    public void mostrarInfo(){
        
        System.out.println("\t\tLINEA DE INVESTIGACION");
        System.out.println("- "+ linea.getNombreLinea());
        System.out.println("\n\t\tSUBLINEAS DE INVESTIGACION");
        for(LineaInvestigacion i : sublineas){
            System.out.println("- "+ i.getNombreLinea());
        }
        System.out.println("\t\tINTEGRANTES");
        for(Estudiante i : integrantes){
            i.mostrarInfo();
            System.out.println("");
        }
        System.out.println("\t\tDOCENTE ACESOR");
        docenteAcesor.mostrar();
        System.out.println("");
        
        if(docenteEvaluador != null){
            docenteEvaluador.mostrarInfo();
        }
        
        if(!this.resultados.isEmpty()){
            for(Resultado i : resultados){
                i.mostrarInfo();
            }
        }
        else{
            System.out.println("NO HAY RESULTADOS");
        }
        

        
        
    }
    
    public abstract void verInfo();
    
    
}
