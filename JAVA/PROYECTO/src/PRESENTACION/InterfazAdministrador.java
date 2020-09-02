
package PRESENTACION;

import DATOS.Usuario;
import LOGICA.Administrador;
import static LOGICA.CentroOperaciones.comprobarDato;
import static LOGICA.CentroOperaciones.diligenciarDocente;
import static LOGICA.CentroOperaciones.diligenciarIntegranteComite;


public class InterfazAdministrador {
    private Administrador admin;
    
    public InterfazAdministrador(Administrador admin){
        this.admin = admin;
    }
    
    static String[] opcMenuPpal = {"AGREGAR USUARIOS", "GESTIONAR LINEAS DE INVESTIGACION",
                                                        "CONFIGURAR HORARIOS", "CERRAR SESION"};
    public int menuPrincipal(){
        
        
        
        System.out.println("\t\tADMINISTRADOR");
        System.out.println("----------------MENU PRINCIPAL----------------");
        System.out.print( opcMenuPpal[0] + "...........................(1)\n"
                                            + opcMenuPpal[1] + "..........(2)\n"
                                            + opcMenuPpal[2] + "........................(3)\n\n"
                                            + opcMenuPpal[3] + "..............................(0)\n\n"
                                            + "SELECCIONE: ");
        int c = (int)comprobarDato("SELECCIONE: ");
        return c;
    }
    
    static String[] opcMenuUsuarios = {"DOCENTE", "INTEGRANTE DEL COMITE",
                                                                         "LISTADO DE USUARIOS"};
    
    public int menuAgregarUsuarios(){
        System.out.println("\t\tADMINISTRADOR");
        System.out.println("---------------"+ opcMenuPpal[0] +"---------------");
        System.out.print( opcMenuUsuarios[0] + "....................................(1)\n"
                                            + opcMenuUsuarios[1] + "......................(2)\n"
                                            + opcMenuUsuarios[2] + "........................(3)\n\n"
                                            + "SALIR......................................(0)\n\n"
                                            + "SELECCIONE: ");
        int c = (int)comprobarDato("SELECCIONE: ");
        return c;
    }
    static String[] opcMenuLineas = {"AGREGAR LINEA DE INVESTIGACION", "AGREGAR SUBLINEA DE INVESTIGACION",
                                                                    "VER LISTADO DE LINEAS DE INVESTIGACION", "VER LISTADO DE SUBLINEAS DE INVESTIGACION"};
    public int menuLineas(){
         System.out.println("\t\tADMINISTRADOR");
        System.out.println("--------------"+ opcMenuPpal[2] +"-------------");
        System.out.print( opcMenuLineas[0] + ".............(1)\n"
                                            + opcMenuLineas[1] + "..........(2)\n"
                                            + opcMenuLineas[2] + ".....(3)\n"
                                            + opcMenuLineas[3] + "..(4)\n\n"
                                            + "SALIR......................................(0)\n\n"
                                            + "SELECCIONE: ");
        int c = (int)comprobarDato("SELECCIONE: ");
        return c;
    }
    
    
    public boolean opcionesMenuLineas(int c){
        boolean tr = true;
        
        switch(c){
            case 0:{
                tr = false;
                break;
            }
            case 1:{
                admin.agregarLineas();
                break;
            }
            case 2:{
                admin.agregarSublineas();
                break;
            }
            case 3:{
                admin.mostrarLineas();
                break;
            }
            case 4:{
                admin.mostrarSublinea();
                break;
            }
        }
        return tr;
    }
    public void iniciar() throws Exception{
        do{}while(opcionesPrincipales(menuPrincipal()));
    }
    
    
    
    public boolean opcionesUsuario(int c) throws Exception{
        Usuario p = null;
        boolean tr = true;
        switch(c){
            case 1:{
                p = diligenciarDocente();
                break;
            } 
            case 2:{
                p = diligenciarIntegranteComite();
                break;
            }
            case 3:{
                admin.verListadoUsuarios();
                break;
            }
            case 0:{
                tr = false;
                break;
            }
        }
         admin.agregarUsuario(p);
        return tr;
    }
    
    public boolean opcionesPrincipales(int c) throws Exception{
        boolean tr = true;
        switch(c){
            case 1:{
                do{}while(opcionesUsuario(menuAgregarUsuarios()));
                break;
            }
            case 2:{
                do{}while(opcionesMenuLineas(menuLineas()));
                break;
            }
            case 3:{
                break;
            }
            case 0:{
                tr = false;
                break;
            }
        }
        
        return tr;
    }
}
