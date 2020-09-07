/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRESENTACION;

import DATOS.IntegranteComite;
import LOGICA.Administrador;
import static LOGICA.CentroOperaciones.comprobarDato;

/**
 *
 * @author moren
 */
public class InterfazIntegranteComite {
    private IntegranteComite p;
    
    public InterfazIntegranteComite(IntegranteComite p){
        this.p = p;
    }
    
    static String[] opcMenuPpal ={"MOSTRAR PROPUESTAS RECIBIDAS", "ASIGNAR DOCENTE EVALUADOR",
                                                                        "MOSTRAR PROPUETAS ACEPTADAS", "CERRAR SESION"};

    InterfazIntegranteComite(Administrador p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int menuPrincipal(){
        System.out.println("\t     INTEGRANTE DEL COMITE");
        System.out.println("----------------MENU PRINCIPAL----------------");
        System.out.print( opcMenuPpal[0] + "...............(1)\n"
                                            + opcMenuPpal[1] + "..................(2)\n"
                                            + opcMenuPpal[2] + "................(3)\n\n"
                                            + opcMenuPpal[3] + "..............................(0)\n\n"
                                            + "SELECCIONE: ");
        int c = (int)comprobarDato("SELECCIONE: ");
        return c;
    }
    
    public boolean opcionesPrincipales(int c){
        boolean tr = true;
        switch(c){
            case 1:{
                p.verPropuestas();
                break;
            }
            case 2:{
                p.asignarDocentes();
                break;
            }
            case 3:{
                p.verPropuestasAceptadas();
                break;
            }
            case 0:{
                tr = false;
                break;
            }
        }
        
        return tr;
    }
    
      public void iniciar(){
        do{}while(opcionesPrincipales(menuPrincipal()));
    }
}
