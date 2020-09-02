 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRESENTACION;


import DATOS.Docente;
import DATOS.Estudiante;
import DATOS.IntegranteComite;
import DATOS.LineaInvestigacion;
import DATOS.Usuario;
import LOGICA.Administrador;
import LOGICA.CentroOperaciones;
import static LOGICA.CentroOperaciones.agregarLinea;
import static LOGICA.CentroOperaciones.agregarUsuarios;
import static LOGICA.CentroOperaciones.allLineas;
import static PRESENTACION.Interfaz.iniciar;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 *
 * @author moren
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*
        agregarLinea("BIG DATA");
        agregarLinea("PROGRAMACION WEB");
        List<LineaInvestigacion> lineaTrabajo = allLineas;
        Docente p = new Docente(lineaTrabajo, "DOCENTE", "1234", "ANDRES FELIPE", "DE AVILA MORENO", 1065837969, 311589076);
        agregarUsuarios(p);
        IntegranteComite w = new IntegranteComite("INTEGRANTE", "TR123", "RODRIGO ANDRES", "DE AVILA MORENO", 1065636960, 300666911);
        agregarUsuarios(w);
        Docente k = new Docente(lineaTrabajo, "YHDMORENO", "YH1234", "YOHEINIS", "DE AVILA MORENO", 1065837494, 300432210);
        List<String> objGenerales = new ArrayList();
        String c1 = "CREAR UN SOFTWARE CAPAZ DE MANEJAR UNA BUEN ADMINISTRACION DE LOS RECURSOS ACADEMICOS";
        objGenerales.add(c1);
        String c2 = "MEJORAR LA BASE DE DATOS DE LAS NOTAS ACADEMICAS DE UNA ENTIDAD EDUCATIVA";
        List<String> objEspecificos = new ArrayList();
        objEspecificos.add(c2);
        String resumen = "LAS ENTIDADES NO CUENTAN CON UN SOFTWARE SOLIDO CAPAZ DE MANEJAR TODA LA INFORMACION ACADEMICA";
        String justificacion = "SE CREARA UN APLICATIVO CAPAZ DE MAJEAR TODA ACTIVIDAD ACADEMICA, CON REGISTROS DE CADA ITERACION QUE EN ESTE SE VEA";
        Estudiante e1 = new Estudiante("JOSE RICARDO", "DE AVILA MORENO", 1003316620, 310453561, "INGENIERIA DE SISTEMAS");
        Estudiante e2 = new Estudiante("EVA SANDRITH", "VIDES SALAS", 12345234, 23423434, "INGENIRIA DE SISTEMAS");
        List<Estudiante> listEstudiante = new ArrayList();
        listEstudiante.add(e1);
        listEstudiante.add(e2);
        Scanner entrada = new Scanner(System.in);
        CentroOperaciones.mostrarAllLineas();
        long codigo = entrada.nextLong();
        CentroOperaciones.mostrarSublineas(codigo);
         */
        //InterfazIntegranteComite fg = new InterfazIntegranteComite((IntegranteComite)p);
        //fg.iniciar();
        //Usuario p1 = new Administrador("DEFAULT", "DEFAULT", "ADMINISTRADOR", "DEL SISTEMA", 1010101010, 101010101);
        //agregarUsuarios(p1);
        // iniciar()
        CentroOperaciones.extraerInformacion();
       principalGUI principalGUI = new principalGUI();
//new TipoPropuesta(null);
    }
    
}
