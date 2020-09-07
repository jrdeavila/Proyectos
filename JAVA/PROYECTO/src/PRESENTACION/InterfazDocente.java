/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRESENTACION;

import DATOS.Docente;
import static LOGICA.CentroOperaciones.comprobarDato;

/**
 *
 * @author moren
 */
public class InterfazDocente {
    private Docente docente;
    
    public InterfazDocente(Docente docente){
        this.docente = docente;
    }
    
   static String[] opcMenuPpal = {"PROPUESTAS RECIBIDAS", "HISTORIAL DE PROPUESTAS", 
                                                                "EVALUAR PROPUESTAS", "CERRAR SESION"};
    public int menuPrincipal(){

        System.out.println("\t\t  DOCENTE");
        System.out.println("----------------MENU PRINCIPAL----------------");
        System.out.print( opcMenuPpal[0] + ".......................(1)\n"
                                            + opcMenuPpal[1] + "....................(2)\n"
                                            + opcMenuPpal[2] + ".........................(3)\n\n"
                                            + opcMenuPpal[3] + "..............................(0)\n\n"
                                            + "SELECCIONE: ");
        int c = (int)comprobarDato("SELECCIONE: ");
        return c;
    }
    
    public boolean opcionesPrincipales(int c){
        boolean tr = true;
        switch(c){
            case 1:{
                docente.verPropuestas();
                break;
            }
            case 2:{
                docente.verHistorialPropuestas();
                break;
            }
            case 3:{
                docente.evaluarPropuesta();
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
