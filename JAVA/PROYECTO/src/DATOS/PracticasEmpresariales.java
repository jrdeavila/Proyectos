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
public class PracticasEmpresariales extends PropuestaGrado implements Serializable{
    private String datosEmpresa, DepTrabajo, areaTrabajo;
    private List<String> funcionesDesarrollar;
    private long NIT;

    public PracticasEmpresariales(String titulo,String datosEmpresa, String DepTrabajo,
            String areaTrabajo, List<String> funcionesDesarrollar, long NIT, List<Estudiante> integrantes, 
            Docente docenteAcesor, int tiempo, LineaInvestigacion linea, List<LineaInvestigacion> sublineas,
            Calendar p) {
        super(titulo, integrantes, docenteAcesor, tiempo, linea, sublineas, p);
        this.datosEmpresa = datosEmpresa;
        this.DepTrabajo = DepTrabajo;
        this.areaTrabajo = areaTrabajo;
        this.funcionesDesarrollar = funcionesDesarrollar;
        this.NIT = NIT;
    }





    public String getDatosEmpresa() {
        return datosEmpresa;
    }

    public String getDepTrabajo() {
        return DepTrabajo;
    }

    public String getAreaTrabajo() {
        return areaTrabajo;
    }

    public List<String> getFuncionesDesarrollar() {
        return funcionesDesarrollar;
    }

    public long getNIT() {
        return NIT;
    }

    public void setDatosEmpresa(String datosEmpresa) {
        this.datosEmpresa = datosEmpresa;
    }

    public void setDepTrabajo(String DepTrabajo) {
        this.DepTrabajo = DepTrabajo;
    }

    public void setAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    public void setFuncionesDesarrollar(List<String> funcionesDesarrollar) {
        this.funcionesDesarrollar = funcionesDesarrollar;
    }

    public void setNIT(long NIT) {
        this.NIT = NIT;
    }
    
    @Override
    public void verInfo(){
        this.mostrarInfo();
        System.out.println("\t\tDATOS DE LA EMPRESA");
        System.out.println(datosEmpresa);
        System.out.println("\n\t\tDEPARTAMENTO DE TRABAJO");
        System.out.println(this.DepTrabajo);
        System.out.println("\n\t\tAREA DE TRABAJO");
        System.out.println(this.areaTrabajo);
        System.out.println("\n\t\tFUNCIONES A DESARROLLAR");
        for(String i : this.funcionesDesarrollar){
            System.out.println("- " + i);
        }
        System.out.println("\nNIT DE LA EMPRESA: " + NIT);
        System.out.println("\n\t\tESTADO: "+  this.getEstado());
        System.out.println("\n\t\tRADICADO: " + this.getCodigo());
    }
    
    
}
