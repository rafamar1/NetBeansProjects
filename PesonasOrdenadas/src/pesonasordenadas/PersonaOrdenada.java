/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesonasordenadas;

import java.util.Comparator;
import utilidades67.personas.Persona;

/**
 *
 * @author profesor
 */
public class PersonaOrdenada 
        extends Persona implements Comparable{

    String localidad;
    
    public PersonaOrdenada(String nombre, String apellidos, String nif) {
        super(nombre, apellidos, nif);
        localidad="no se sabe";
    }
    
     public PersonaOrdenada(String nombre, String apellidos, 
                            String nif   ,String pueblo) {
        this(nombre, apellidos, nif);
        localidad=pueblo;
    }
    

    @Override
    public int compareTo(Object o) {
        
       PersonaOrdenada per=(PersonaOrdenada)o;
       
       int compara=this.apellidos.compareTo(per.apellidos);
       
     if(compara==0)
        return  
            this.nombre.compareTo(per.nombre);
     
     else return compara;
        
    }
    //-----------------------

    @Override
    public String toString() {
        return "\n\t"+super.apellidos+" ,"
                     +super.nombre+" nif: "
                     +super.getNif()+" Loc: "
                     +localidad;
                
    }
/**Clase Interna (inner Class) que implementa Comparator
*    para order po nif
*/ 

    static public class OrdenaNif  implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        PersonaOrdenada p1= (PersonaOrdenada)o1;
        PersonaOrdenada p2= (PersonaOrdenada)o2;
        
        return p1.getNif().compareToIgnoreCase(p2.getNif());
    }
    
}
    

    
    
    
    
}//class...
