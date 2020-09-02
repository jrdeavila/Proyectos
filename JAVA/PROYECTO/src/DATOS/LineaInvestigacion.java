/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

import LOGICA.Extras;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moren
 */
public class LineaInvestigacion implements Icodigo, Serializable{
    private String nombreLinea;
    private List<LineaInvestigacion> sublineas;
    private long codigo;
    
    public LineaInvestigacion(String nombreLinea) {
        this.nombreLinea = nombreLinea;
        this.sublineas = new ArrayList();
        this.codigo = Extras.generarCodigo();
    }
    
    public LineaInvestigacion(String nombreLinea, long codigo) {
        this.nombreLinea = nombreLinea;
        this.sublineas = new ArrayList();
        this.codigo = codigo;
    }
    
    public LineaInvestigacion(String nombreLinea, List<LineaInvestigacion> sublineas){
        this(nombreLinea);
        this.sublineas = sublineas;
    }

    public void setNombreLinea(String nombreLinea) {
        this.nombreLinea = nombreLinea;
    }

    public void setSublineas(List<LineaInvestigacion> sublineas) {
        this.sublineas = sublineas;
    }

    public String getNombreLinea() {
        return nombreLinea;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getCodigo() {
        return codigo;
    }

    public List<LineaInvestigacion> getSublineas() {
        return sublineas;
    }
    
    public void mostrar(){
         System.out.printf("CODIGO:  %d    NOMBRE: %s\n", this.getCodigo(), this.getNombreLinea());
    }

    @Override
    public long getKeys() {
        return this.getCodigo();
    }
    
    
}
