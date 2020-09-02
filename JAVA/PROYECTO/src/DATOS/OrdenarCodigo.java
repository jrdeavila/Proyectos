/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

import java.util.Comparator;

/**
 *
 * @author moren
 */
public class OrdenarCodigo implements  Comparator<Icodigo>{
    
    @Override
    public int compare(Icodigo o1, Icodigo o2) {
        if(o1.getKeys() > o2.getKeys()){
            return 1;
        }
        else if(o1.getKeys() == o2.getKeys()){
            return 0;
        }
        else{
            return -1;
        }
    }
        
    
}
