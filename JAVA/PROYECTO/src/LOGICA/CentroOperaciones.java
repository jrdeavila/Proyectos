/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;
import DATOS.Docente;
import DATOS.Estudiante;
import DATOS.Icodigo;
import DATOS.IntegranteComite;
import DATOS.LineaInvestigacion;
import DATOS.OrdenarCodigo;
import DATOS.Persona;
import DATOS.PracticasEmpresariales;
import DATOS.PropuestaGrado;
import DATOS.ProyectoAplicado;
import DATOS.Usuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.io.*;


public class CentroOperaciones implements Serializable{
    public static   List<PropuestaGrado> allPropuestas = new ArrayList();
   public static  List<LineaInvestigacion> allLineas = new ArrayList();
    public static  List<Usuario> allUsuarios = new ArrayList();
    public static Calendar horario = Calendar.getInstance();
    
    public static void extraerInformacion(){
        if(extraerLineas() != null){
            allLineas = extraerLineas();
        }
        if(extraerUsuarios() != null){
            allUsuarios = extraerUsuarios();
        }
        if(extraerPropuestas() != null){
            allPropuestas = extraerPropuestas();
        }
    }
    
    
    public static void guardarPropuestas(){
        try{
            FileOutputStream file = new FileOutputStream("propuestas.txt");
            ObjectOutputStream write = new ObjectOutputStream(file);
            write.writeObject(allPropuestas);
            write.close();
        }
        catch(IOException e){
            System.out.println("El archivo no existe \"propuestas.txt\"");
        }
    }
    
    
    public static List<PropuestaGrado> extraerPropuestas(){
        List<PropuestaGrado> propuestas = null;
        try{
            FileInputStream file = new FileInputStream("propuestas.txt");
            ObjectInputStream read = new ObjectInputStream(file);
            propuestas = (List<PropuestaGrado>)read.readObject();
            read.close();
        }
        catch(Exception e){
            System.out.println("El archivo no existe \"propuetas.txt\"");
        }
        finally{
           return propuestas; 
        }
        
    }
    
    public static void guardarUsuarios(){
        try{
            FileOutputStream file = new FileOutputStream("usuarios.txt");
            ObjectOutputStream write = new ObjectOutputStream(file);
           write.writeObject(allUsuarios);
           write.close();
        }
        catch(IOException e){
            System.out.println("El archi no existe \"usuarios.txt\"");
        }
    }
    
    public static List<Usuario> extraerUsuarios(){
       List<Usuario> usuarios = null;
        try{
            FileInputStream file = new FileInputStream("usuarios.txt");
            ObjectInputStream read = new ObjectInputStream(file);
            usuarios = (List<Usuario>)read.readObject();
            read.close();
        }
        catch(Exception e){
            System.out.println("El archivo no existe \"usuario.txt\"");
        }
        finally{
            return usuarios;
        }
        
    }
    
    public static void guardarLineas(){
        try{
            FileOutputStream file = new FileOutputStream("lineas.txt");
            ObjectOutputStream write = new ObjectOutputStream(file);
           write.writeObject(allLineas);
           write.close();
        }
        catch(IOException e){
            System.out.println("El archi no existe \"lineas.txt\"");
        }
    }
    
    public static List<LineaInvestigacion> extraerLineas(){
        List<LineaInvestigacion> lineas = null;
        try{
            FileInputStream file = new FileInputStream("lineas.txt");
            ObjectInputStream read = new ObjectInputStream(file);
            lineas = (List<LineaInvestigacion>)read.readObject();
            read.close();
        }
        catch(Exception e){
            System.out.println("El archivo no existe \"lineas.txt");
        }
        finally{
            return lineas;
        }
        
    }
    
    //METODOS PARA LA GESTION DE PROPUESTAS
    public static boolean agregarPropuesta(PropuestaGrado p){
        boolean tr = allPropuestas.add(p);
        guardarPropuestas();
        extraerPropuestas();
        return tr;
    }
     public static Estudiante diligenciarEstudiante(){
         String nombre, apellido, usuario, password;
        long cedula, telefono, codigo;
        
        System.out.println("-----------------DATOS PERSONALES------------------");
         Extras.entrada.nextLine();
        System.out.print("NOMBRE: ");
        nombre = Extras.entrada.nextLine();
        System.out.print("APELLIDO: ");
        apellido = Extras.entrada.nextLine();
        System.out.print("CEDULA: ");
        cedula = comprobarDato("CEDULA: ");
        System.out.print("TELEFONO: ");
        telefono = comprobarDato("TELEFONO: ");
         System.out.println("-----------------DATOS ACADEMICOS-----------------");
         Extras.entrada.nextLine();
         System.out.print("CARRERA: ");
         String carrera = Extras.entrada.nextLine();
         
         Estudiante p = new Estudiante(nombre, apellido, cedula, telefono, carrera);
         return p;
    }
    
    //METODOS PARA LA GESTION DE USUARIOS (DOCENTE E INTEGRANTE DEL COMITE)
    public static boolean agregarUsuarios(Usuario e){
        boolean tr = false;
        if(e != null){
            tr =  allUsuarios.add(e);
            guardarUsuarios();
            extraerUsuarios();
        }
        return false;
    }
    
    public static Docente diligenciarDocente(){
        String nombre, apellido, usuario, password;
        long cedula, telefono, codigo;
        List<LineaInvestigacion> lineaTrabajo = new ArrayList();
        Docente newDocente = null;
        
         System.out.println("-----------------DATOS PERSONALES------------------");
         Extras.entrada.nextLine();
        System.out.print("NOMBRE: ");
        nombre = Extras.entrada.nextLine();
        System.out.print("APELLIDO: ");
        apellido = Extras.entrada.nextLine();
        System.out.print("CEDULA: ");
        cedula = comprobarDato("CEDULA: ");
        System.out.print("TELEFONO: ");
        telefono = comprobarDato("TELEFONO: ");
        
        System.out.println("-----------------DATOS DE LA CUENTA----------------");
        Extras.entrada.nextLine();
        System.out.print("USUARIO: ");
        usuario = Extras.entrada.nextLine();
        System.out.print("PASSWORD: ");
        password = Extras.entrada.nextLine();
        
        System.out.println("-----------------LINEAS DE TRABAJO-----------------");
        if(mostrarAllLineas()){
            System.out.print("CODIGO-LINEA: ");
            codigo = comprobarDato("CODIGO-LINEA: ");
            LineaInvestigacion p = buscarLinea(codigo);
            lineaTrabajo.add(p);
            newDocente = new Docente(lineaTrabajo,usuario,password,nombre,apellido,cedula,telefono);
        }
        else{
            System.out.println("NO SE PUDO CREAR USUARIO DOCENTE");
        }
        
        
        
        return newDocente;
    }
    
    public static LineaInvestigacion buscarLinea(String nombre, List<LineaInvestigacion> lista){
        LineaInvestigacion p = null;
        for(LineaInvestigacion i : lista){
            if(nombre.equals(i.getNombreLinea())){
                p = i;
            }
        }
        return p;
    }

    
    public static IntegranteComite diligenciarIntegranteComite(){
        String nombre, apellido, usuario, password;
        long cedula, telefono, codigo;
        IntegranteComite p = null;
        Extras.entrada.nextLine();
        System.out.println("-----------------DATOS PERSONALES------------------");
        System.out.print("NOMBRE: ");
        nombre = Extras.entrada.nextLine();
        System.out.print("APELLIDO: ");
        apellido = Extras.entrada.nextLine();
        System.out.print("CEDULA: ");
        cedula = comprobarDato("CEDULA: ");
        System.out.print("TELEFONO: ");
        telefono = comprobarDato("TELEFONO: ");
        
        System.out.println("-----------------DATOS DE LA CUENTA----------------");
        Extras.entrada.nextLine();
        System.out.print("USUARIO: ");
        usuario = Extras.entrada.nextLine();
        System.out.print("PASSWORD: ");
        password = Extras.entrada.nextLine();
        
        p = new IntegranteComite(usuario, password, nombre, apellido, cedula, telefono);
        
        
        return p;
    }
    
    
    public static Persona diligenciarDocenteAcesor(){
         String nombre, apellido, usuario, password;
        long cedula, telefono, codigo;
        System.out.println("-----------------DATOS PERSONALES DOCENTE----------------");
         Extras.entrada.nextLine();
        System.out.print("NOMBRE: ");
        nombre = Extras.entrada.nextLine();
        System.out.print("APELLIDO: ");
        apellido = Extras.entrada.nextLine();
        System.out.print("CEDULA: ");
        cedula = comprobarDato("CEDULA: ");
        System.out.print("TELEFONO: ");
        telefono = comprobarDato("TELEFONO: ");
        
        Persona p = new Docente(nombre, apellido, cedula, telefono);
        
        return p;
    }
    
    public static char continuar(char op){
        do{ 
                      System.out.print("DESEA CONTINUAR S/N: ");
                      op = Extras.entrada.next().charAt(0);
                      op = Character.toUpperCase(op);
                }while(op != 'S' && op != 'N');
        
        return op;
    }
    
    public static char evaluar(char op){
        do{ 
                      System.out.print("ACEPTAR(S)   RECHAZAR(N): ");
                      op = Extras.entrada.next().charAt(0);
                      op = Character.toUpperCase(op);
                }while(op != 'S' && op != 'N');
        
        return op;
    }
    public static char enviar(char op){
        do{ 
                      System.out.print("ENVIAR(E)       CANCELAR(C):  ");
                      op = Extras.entrada.next().charAt(0);
                      op = Character.toUpperCase(op);
                }while(op != 'E' && op != 'C');
         return op;
    }
    
    
    public static boolean mostrarPracticas(){
        int j = 0;
        System.out.println("\t\tMOSTRAR PRACTICAS EMPRESARIALES");
        if(!allPropuestas.isEmpty()){
            for(PropuestaGrado i : allPropuestas){
                 if(i  instanceof PracticasEmpresariales){
                       System.out.printf("CODIGO: %d    DATOS DE LA EMPRESA: %s      NIT: %d     # ESTUDIANTES: %d\n", 
                              i.getCodigo(), ((PracticasEmpresariales) i).getDatosEmpresa(), 
                              ((PracticasEmpresariales) i).getNIT(), i.getIntegrantes().size());
                 }   
             }
            return true;
        }
        else{
            System.out.println("NO HAY PRACTICAS EMPRESARIALES");
            return false;
        }
        
    }
    public static PropuestaGrado buscarPropuesta(long codigo){
        PropuestaGrado p = null;
        for(PropuestaGrado i : allPropuestas){
            if(codigo == i.getCodigo()){
                p = i;
                break;
            }
        }
        
        return p;
    }
    public static void mostrarPropuestasAceptadas(){
        System.out.println("\t\tPROPUESTAS ACEPTADAS");
        if(allPropuestas.isEmpty()){
            System.out.println("NO HAY PROPUESTAS ACEPTADAS");
        }
        else{
             for(PropuestaGrado i : allPropuestas){
                  if("ACEPTADA".equals(i.getEstado())){
                     if(i  instanceof PracticasEmpresariales){
                        System.out.printf("CODIGO: %d    DATOS DE LA EMPRESA: %s      NIT: %d     # ESTUDIANTES: %d\n", 
                               i.getCodigo(), ((PracticasEmpresariales) i).getDatosEmpresa(), 
                                  ((PracticasEmpresariales) i).getNIT(), i.getIntegrantes().size());
                    }
                    if(i  instanceof ProyectoAplicado){
                        System.out.printf("CODIGO: %d  PROYECTO APLICADO: %s     # ESTUDIANTES:  %d\n",
                               i.getCodigo(), ((ProyectoAplicado) i).getJustificacion(), i.getIntegrantes().size());
                    }
                
                }
        }
        }
       
    }
    public static void asignarDocenteAcesor(Docente docenteAcesor, PropuestaGrado p){
        p.setDocenteEvaluador(docenteAcesor);
        List<PropuestaGrado> n = docenteAcesor.getProyectosAsignados();
        n.add(p);
        docenteAcesor.setProyectosAsignados(n);
    }
    
    public static void actualizarEstadoPropuesta(PropuestaGrado p){
        char op = 'S';
        op = evaluar(op);
        String estado = "ACEPTADA";
        if(op == 'N'){
            estado = "RECHAZADO";
        }
        p.setEstado(estado);
    }
   
    public static Usuario loguearse(){
        String usuario, password;
        Extras.entrada.nextLine();
        System.out.print("USUARIO: ");
        usuario = Extras.entrada.nextLine();
        System.out.print("PASSWORD: ");
        password = Extras.entrada.nextLine();
        
        Usuario p = null;
        
        for(Usuario i : allUsuarios){
            if(i.loguearse(usuario, password)){
                p = i;
                break;
            }
        }
        
        return p;
    }
    
    public static boolean mostrarProyectos(){
        System.out.println("\t\tPROYECTOS DE INVESTIGACION");
        if(!allPropuestas.isEmpty()){
            for(PropuestaGrado i : allPropuestas){
                 if(i  instanceof ProyectoAplicado){
                       System.out.printf("CODIGO: %d  PROYECTO APLICADO: %s     # ESTUDIANTES:  %d\n",
                               i.getCodigo(), ((ProyectoAplicado) i).getJustificacion(), i.getIntegrantes().size());
                 }   
             }
            return true;
        }
        else{
            System.out.println("NO HAY PROYECTOS DE INVESTIGACION");
            return false;
        }
    }
    
    public static ProyectoAplicado diligenciarProyecto(LineaInvestigacion linea, List<LineaInvestigacion> sublinea, Docente acesor, List<Estudiante> integrantes, int dias, Calendar g){
        ProyectoAplicado f = null; 
        System.out.print("RESUMEN DEL PROBLEMA: ");
        Extras.entrada.nextLine();
        String resumen = Extras.entrada.nextLine();
                   
        List<String> objGenerales = new ArrayList();
        List<String> objEspecificos = new ArrayList();
           
         char op = 'S';
           
         while(op == 'S'){
                System.out.print("OBJETIVO GENERAL: ");
                String obj = Extras.entrada.nextLine();
                objGenerales.add(obj);
                op = continuar(op);
         }
           
         op = 'S';
         
          while(op == 'S'){
              Extras.entrada.nextLine();
               System.out.print("OBJETIVO ESPECIFICO: ");
               String obj = Extras.entrada.nextLine();
               objEspecificos.add(obj);
               op = continuar(op);
           }
          Extras.entrada.nextLine();
           System.out.print("JUSTIFICACION: ");
            String justificacion = Extras.entrada.nextLine();
                    
           
          f =new ProyectoAplicado("propuesta",resumen, objGenerales, objEspecificos,
          justificacion, integrantes, acesor, dias, linea, sublinea, g);
                     
          return f;
    }
    
       private static PropuestaGrado diligenciarPractica(LineaInvestigacion p, List<LineaInvestigacion> listSubs, Docente docente, List<Estudiante> integrantes, int dias, Calendar g) {
           PracticasEmpresariales  f = null;
            Extras.entrada.nextLine();
           System.out.print("DATOS DE LA EMPRESA: ");
           String datos = Extras.entrada.nextLine();
           System.out.print("DEPARTAMENTO DE TRABAJO: ");
           String depTrabajo = Extras.entrada.nextLine();
           System.out.print("AREA DE TRABAJO: ");
           String area = Extras.entrada.nextLine();
           System.out.print("NIT DE LA EMPRESA: ");
           long NIT = comprobarDato("NIT DE LA EMPRESA: ");
           List<String> funciones = new ArrayList();
           char op = 'S';
            Extras.entrada.nextLine();
           while(op == 'S'){
               Extras.entrada.nextLine();
               System.out.print("FUNCIONES A DESARROLLAR:");
               String funcion = Extras.entrada.nextLine();
               funciones.add(funcion);
               op = continuar(op);
           }
           
           f = new PracticasEmpresariales("propuesta",datos, depTrabajo, depTrabajo, 
                   funciones, NIT, integrantes, docente, dias, p, listSubs, g);
           return f;
       }
    public static PropuestaGrado diligenciarPropuesta(){
        Calendar g = Calendar.getInstance();
        PropuestaGrado f = null;
        System.out.println("\t\t PROPUESTA DE GRADO");
           Persona docenteAcesor = diligenciarDocenteAcesor();
           System.out.println("--------------------LINEA DE INVESTIGACION----------------");
           LineaInvestigacion p = buscarLinea();
           System.out.println("--------------SUBLINEA DE INVESTIGACION----------------");
          List<LineaInvestigacion> listSubs = new ArrayList();
            char op = 'S';
           while(op == 'S'){
               LineaInvestigacion newSubs = buscarSublinea(p);
               listSubs.add(newSubs);
               op = continuar(op);
            }
           System.out.println("---------------------------INTEGRANTES-------------------------");
           List<Estudiante> integrantes = new ArrayList();
           op = 'S';
           while(op == 'S'){
               Estudiante q = diligenciarEstudiante();
               integrantes.add(q);
               op = continuar(op);
            }
           
           System.out.print("TIEMPO DE DESARROLLO (DIAS): ");
            int dias = (int)comprobarDato("TIEMPO DE DESARROLLO (DIAS): ");
           
         
           System.out.print("\t\tOPCIONES\n"
                                            + "PROYECTO APLICADO....................(1)\n"
                                            + "PRACTICAS EMPRESARIALES..............(2)\n"
                                            + "CANCELAR.............................(0)\n"
                                            + "SELECCIONE: ");
           int c = (int)comprobarDato("SELECCIONE: ");
           switch(c){
               case 0:{
                   f = null;
               }
               case 1:{
                   f = diligenciarProyecto(p, listSubs, (Docente) docenteAcesor, integrantes, dias, g);
                   
                    break;
               }
               case 2:{
                   f = diligenciarPractica(p, listSubs, (Docente) docenteAcesor, integrantes, dias, g);
                   break;
               }
           }         
           return f;
    }    
    
   public static boolean mostrarDocentes(){
       boolean tr = true;
       if(!allUsuarios.isEmpty()){
           for(Usuario i : allUsuarios){
               if(i instanceof Docente){
                   ((Docente) i).mostrarInfo();
               }
           }
       }
       else{
           tr = false;
       }
       
       return tr;
   }
    
   public static Usuario buscarUsuario(long codigo){
       Usuario p = null;
       for(Usuario i : allUsuarios){
           if(codigo == i.getCedula()){
               p = i;
               break;
           }
       }
       
       return p;
   }
   
    public static boolean mostrarAllUsuarios(){
        if(!allUsuarios.isEmpty()){
            for(Usuario i : allUsuarios){
                
                if(i instanceof Docente){
                    System.out.printf("CARGO: DOCENTE   CEDULA: %d  NOMBRE: %s %s   TELEFONO: %d\n",
                  i.getCedula(), i.getApellido(), i.getNombre(), i.getTelefono());
             }
                if(i instanceof Administrador){
                    System.out.printf("CARGO: ADMINISTRADOR    CEDULA: %d  NOMBRE: %s %s   TELEFONO: %d\n",
                  i.getCedula(), i.getNombre(), i.getApellido(), i.getTelefono());
                }
                else{
                    System.out.printf("CARGO: INTEGRANTE DEL COMITE    CEDULA: %d  NOMBRE: %s %s   TELEFONO: %d\n",
                  i.getCedula(), i.getApellido(), i.getNombre(), i.getTelefono());
             }
            
            }
                  
            return true;
        }
        else{
            System.out.println("NO HAY USUARIOS");
            return false;
        }
    }
  
    public static void revisarPropuestas(){
        
    }
    
    public static void establecerHorario(){
        System.out.println("\tESTABLECA EL ORDEN DE LLEGADA DE LAS PROPUESTAS");
        System.out.println("\t\tESCOGA EL DIA");
        System.out.print("DIAS DE LA SEMANA\n"
                                         + "LUNES......................(1)\n"
                                         + "MARTES..................(2)\n"
                                         + "MIERCOLES............(3)\n"
                                         + "JUEVES.....................(4)\n"
                                         + "VIERNES..................(5)\n"
                                         + "SELECCIONE: ");
        int dia = (int)comprobarDato("SELECCIONE: ");
        
    }
    
    public static void ordenarICodigo(){
        Comparator p = new OrdenarCodigo();
        Collections.sort(allLineas, p);
        Collections.sort(allPropuestas, p);
        Collections.sort(allUsuarios, p);
    }
    
    //INTENTAR INTRODUCIR UN DATO NUMERICO - EXCEPCION DATOS ALFANUMERICOS
    public static long comprobarDato(String nP){
        long n = 0;
        boolean tr = true;
        do{
            try{
                n = Extras.entrada.nextLong();
                tr = false;
            }
            catch(InputMismatchException e){
                System.out.println("Error. valor no numerico");
                tr = true;
                System.out.print(nP);
                Extras.entrada.nextLine();
            }
        }while(tr);
        
        return n;
 }
    
    //METODOS PARA LA GESTION DE LINEAS Y SUBLINEAS
     public static boolean agregarLinea(String nombreLinea){
         
         LineaInvestigacion p = new LineaInvestigacion(nombreLinea);
        
         boolean tr =allLineas.add(p);
        guardarLineas();
        extraerLineas();
        
        return tr;
    }
     public static LineaInvestigacion diligenciarLinea(){
         String nombre;
         Extras.entrada.nextLine();
         System.out.print("NOMBRE-SUBLINEA: ");
         nombre = Extras.entrada.nextLine();
         LineaInvestigacion p = new LineaInvestigacion(nombre);
         return p;
         
     }
     
     public static void agregarLinea(LineaInvestigacion p ){
         if(p != null && allLineas != null){
             allLineas.add(p);
             guardarLineas();
             extraerLineas();
             System.out.println("SE AGREGO A LA BASE DE DATOS");
         }
         else{
             System.out.println("NO SE AGREGO A LA BASE DE DATOS");
         }
     }
     
     public static boolean agregarSublinea(){
         if(allLineas != null){
              if(mostrarAllLineas()){
                 System.out.print("CODIGO-LINEA: ");
                   long codigo = comprobarDato("CODIGO-LINEA: ");
                    LineaInvestigacion p = buscarLinea(codigo);
                    if(p != null){
                         List<LineaInvestigacion> newSublineas = p.getSublineas();
                        LineaInvestigacion q = diligenciarLinea();
                        newSublineas.add(q);
                        p.setSublineas(newSublineas);
                        System.out.println("SE AGREGO A LA BASE DE DATOS");
                        guardarLineas();
                        extraerLineas();
                        return true;
                    }
                    else{
                        System.out.println("NO SE ENCUENTRA EN LA BASE DE DATOS");
                        return false;
                    }
            }
            else{
                 return false;
            }
         }
         else{
             System.out.println("NO HAY LINEAS DE INVESTIGACION");
             return false;
         }
        
        
     }
     
    public static LineaInvestigacion buscarLinea(long codigo){
        return buscarLinea(codigo, allLineas);
    }
    public static LineaInvestigacion buscarLinea(long codigo, List<LineaInvestigacion> lineas){
        LineaInvestigacion p = null;
        for(LineaInvestigacion i : lineas){
            if(codigo == i.getCodigo()){
                p = i;
            }
        }
        
        return p;
    }
    public static LineaInvestigacion buscarLinea(List<LineaInvestigacion> sublineas){
        LineaInvestigacion p = null;
        if(sublineas(sublineas)){
            System.out.print("CODIGO-SUBLINEA: ");
            long cod = comprobarDato("CODIGO-SUBLINEA: ");
            p = buscarLinea(cod, sublineas);
        }
        else{
            System.out.println("NO HAY SUBLINEAS");
        }
        
        return p;
    }
   public static LineaInvestigacion buscarSublinea(long codigo, long codigoSublinea){
       
       
       LineaInvestigacion p = buscarLinea(codigo);
       LineaInvestigacion q = null;
       if(p!=null){
           List<LineaInvestigacion> sublineas = p.getSublineas();
           q = buscarLinea(codigoSublinea, sublineas);
       }
       
       return q;
   }
   
   
    public static boolean isNumeric(String filtro) {
        try{
            Long.parseLong(filtro);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
   
   public static List<LineaInvestigacion> filtrarLineas(String filtro){
       List<LineaInvestigacion> lista = new ArrayList();
       boolean tr = isNumeric(filtro);
       if(tr){
           for(LineaInvestigacion i : allLineas){
               String cod = Long.toString(i.getCodigo());
               if(cod.contains(filtro)){
                   lista.add(i);
               }
           }
       }
       else{
           for(LineaInvestigacion i : allLineas){
               if(i.getNombreLinea().contains(filtro)){
                   lista.add(i);
               }
           }
       }
       
       return lista;
   }
    public static LineaInvestigacion buscarSublinea(LineaInvestigacion linea){
        LineaInvestigacion q = null;
        if(linea!=null){
           List<LineaInvestigacion> sublineas = linea.getSublineas();
           
           q = buscarLinea( sublineas);
       }
        
        return q;
    }
    public static boolean mostrarSublineas(long codigo){
                LineaInvestigacion p = buscarLinea(codigo);
                if(p != null){
                    List<LineaInvestigacion> sublineas = p.getSublineas();
                    return sublineas(sublineas);
                }
                else{
                    System.out.println("NO SE ENCUENTRA EN LA BASE DE DATOS");
                    return false;
                }
    }
    
    public static boolean mostrarSublineas(LineaInvestigacion p ){
        return sublineas(p.getSublineas());
    }
     
    public static boolean sublineas(List<LineaInvestigacion> sublineas){
        if(!sublineas.isEmpty()){
            for(LineaInvestigacion i : sublineas){
                i.mostrar();
            }
            return true;
        }
        else{
            System.out.println("NO HAY SUBLINEAS");
            return false;
        }
    }
    
     public static boolean mostrarAllLineas(){
         if(allLineas != null){
            
              for(LineaInvestigacion i : allLineas) {
               i.mostrar();
            }
               return true;
         }
         else{
             System.out.println("NO HAY LINEAS");
             return false;
         }
        
     }
     
     public static LineaInvestigacion buscarLinea(){
         LineaInvestigacion p = null;
         if(mostrarAllLineas()){
             System.out.print("CODIGO-LINEA: ");
              long codigo = comprobarDato("CODIGO-LINEA: ");
              p = buscarLinea(codigo);
         }
         return p;
     }
     
     
     
     
}
