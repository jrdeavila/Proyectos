/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.LineaInvestigacion;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author moren
 */
public class Extras {
    
    public static final Scanner entrada = new Scanner(System.in);
    
    public static long generarCodigo(){
        long codigo;
        
        codigo = (long)Math.floor(Math.random() * (200000 - 100000+1) +  100000);
        return codigo;
    }
    
     
}
