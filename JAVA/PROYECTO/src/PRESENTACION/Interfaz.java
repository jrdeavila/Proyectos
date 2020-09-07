/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRESENTACION;

import DATOS.Docente;
import DATOS.IntegranteComite;
import DATOS.PropuestaGrado;
import DATOS.Usuario;
import LOGICA.Administrador;
import static LOGICA.CentroOperaciones.agregarPropuesta;
import static LOGICA.CentroOperaciones.comprobarDato;
import static LOGICA.CentroOperaciones.diligenciarPropuesta;
import static LOGICA.CentroOperaciones.loguearse;
import static LOGICA.CentroOperaciones.agregarUsuarios;
import static LOGICA.CentroOperaciones.buscarPropuesta;
import LOGICA.Extras;

/**
 *
 * @author moren
 */
public class Interfaz {
   static String[] opcMenuPpal = {"DILIGENCIAR PROPUESTA", "VER ESTADO DE PROPUESTA", "INICIAR SESION"};
    public static int menuPrincipal(){
        
        System.out.println("----------------MENU PRINCIPAL----------------");
        System.out.print( opcMenuPpal[0] + "......................(1)\n"
                                            + opcMenuPpal[1] + "....................(2)\n"
                                            + opcMenuPpal[2] + ".............................(3)\n\n"
                                            + "SELECCIONE: ");
        int c = (int)comprobarDato("SELECCIONE: ");
        return c;
    }
    
    
    public static boolean opcionesMenuPpal(int c) throws Exception{
        boolean tr = true;
        switch(c){
            case 0:{
                tr = false;
                break;
            }
            case 1:{
                PropuestaGrado p = diligenciarPropuesta();
                agregarPropuesta(p);
                p.verInfo();
                break;
            }
            case 2:{
                System.out.print("CODIGO-PROPUESTA: ");
                long codigo = comprobarDato("CODIGO-PROPUESTA: ");
                
                PropuestaGrado p = buscarPropuesta(codigo);
                p.verInfo();
                break;
            }
            case 3:{
                do{}while(opcionesMenuSesion(menuIniciarSesion()));
            }
        }
        
        return tr;
    }
    static String[] opcMenuSesion = {"DOCENTE", "INTEGRANTE DEL COMITE", "ADMINISTRADOR"};
    public static int menuIniciarSesion(){
        System.out.println("----------------INICIAR SESION----------------");
        System.out.print(opcMenuSesion[0] +"....................................(1)\n"
                                        + opcMenuSesion[1] +"......................(2)\n"
                                        + opcMenuSesion[2] +"..............................(3)\n\n"
                                        + "SALIR......................................(0)\n\n"
                                        + "SELECCIONE: ");
        int c = (int)comprobarDato("SELECCIONE: ");
        return c;
    }
    
    public static Usuario login(){
        return loguearse();        
    }
     
    public static boolean opcionesMenuSesion(int c) throws Exception{
        boolean tr = true;
        switch(c){
            case 0:{
                tr = false;
                break;
            }
            case 1:{
                Usuario q = login();
                if(q instanceof Docente){
                    InterfazDocente p = new InterfazDocente((Docente)q);
                    p.iniciar();
                }
                else{
                    System.out.println("NO EXISTE EL USUARIO");
                }
                break;
            }
            case 2:{
                Usuario q = login();
                if(q instanceof IntegranteComite){
                    InterfazIntegranteComite p = new InterfazIntegranteComite((IntegranteComite) q);
                    p.iniciar();
                }
                else{
                    System.out.println("NO EXITE EL USUARIO");
                }
                break;
            }
            case 3:{
                Usuario q = login();
                 if(q instanceof Administrador){
                     InterfazAdministrador p = new InterfazAdministrador((Administrador) q);
                     p.iniciar();
                 }
                else{
                    System.out.println("USUARIO O CONTRASEÑA EQUIVOCADOS");
                }
                break;
            }
        }
        
        return tr;
    }
    
    public static void iniciar() throws Exception{
         do{}while(opcionesMenuPpal(menuPrincipal()));
    }
   
}
