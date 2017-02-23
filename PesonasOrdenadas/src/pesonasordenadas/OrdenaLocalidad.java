/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesonasordenadas;

import java.util.Comparator;

/**
 *
 * @author profesor
 */
public class OrdenaLocalidad  implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        PersonaOrdenada p1= (PersonaOrdenada)o1;
        PersonaOrdenada p2= (PersonaOrdenada)o2;
        
        return p1.localidad.compareToIgnoreCase(p2.localidad);
    }
    
}
