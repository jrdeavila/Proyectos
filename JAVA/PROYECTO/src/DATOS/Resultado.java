/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

import java.io.Serializable;

/**
 *
 * @author moren
 */
public class Resultado implements Serializable {
    private String resumenResultado, conclusiones, trabajosFuturos;

    public Resultado(String resumenResultado, String conclusiones, String trabajosFuturos) {
        this.resumenResultado = resumenResultado;
        this.conclusiones = conclusiones;
        this.trabajosFuturos = trabajosFuturos;
    }

    public String getResumenResultado() {
        return resumenResultado;
    }

    public String getConclusiones() {
        return conclusiones;
    }

    public String getTrabajosFuturos() {
        return trabajosFuturos;
    }

    public void setResumenResultado(String resumenResultado) {
        this.resumenResultado = resumenResultado;
    }

    public void setConclusiones(String conclusiones) {
        this.conclusiones = conclusiones;
    }

    public void setTrabajosFuturos(String trabajosFuturos) {
        this.trabajosFuturos = trabajosFuturos;
    }
    
    public void mostrarInfo(){
        System.out.println("\t\tRESUMEN DE RESULTADO");
        System.out.println(resumenResultado);
        System.out.println("'\n\t\tCONCLUSIONES");
        System.out.println(conclusiones);
        System.out.println("\n\t\tTRABAJOS FUTUROS");
        System.out.println("-" + trabajosFuturos);
            
   }
    
    
}
