/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesonasordenadas;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;
import utilidades67.personas.Persona;

/**
 *
 * @author profesor
 */
public class PesonasOrdenadas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TreeSet<Persona> apellidosNombre = new TreeSet();
        TreeSet<Persona> perLocalidad    = 
                new TreeSet(new OrdenaLocalidad());
        TreeSet<Persona> perNif    = 
                new TreeSet( new PersonaOrdenada.OrdenaNif());
        
        TreeMap <String,Persona> treeMapPersonas = new TreeMap(); 
        HashMap <String,Persona> hashMapPersonas = new HashMap();
        
        
        
        
        PersonaOrdenada per1=new PersonaOrdenada("Pepe", "Lopez", "11111111A");
        PersonaOrdenada per2=new PersonaOrdenada("Pepe", "Perez", "11111111B","Ronda");
        PersonaOrdenada per3=new PersonaOrdenada("Pepe", "Alvarez", "11111113Z","Arriate");
        PersonaOrdenada per4=new PersonaOrdenada("Luisa", "Alvarez", "11111114g","Juzcar");
        
        treeMapPersonas.put(per1.getNif(), per1);
        hashMapPersonas.put(per1.getNif(), per1);
        
        treeMapPersonas.put(per2.getNif(), per2);
        hashMapPersonas.put(per2.getNif(), per2);
        
        treeMapPersonas.put(per3.getNif(), per3);
        hashMapPersonas.put(per3.getNif(), per3);
        
        treeMapPersonas.put(per4.getNif(), per4);
        hashMapPersonas.put(per4.getNif(), per4);
        
        
        
        
        
        
        
        apellidosNombre.add(per1);perLocalidad.add(per1);
        apellidosNombre.add(per2);perLocalidad.add(per2);
        apellidosNombre.add(per3);perLocalidad.add(per3);
        apellidosNombre.add(per4);perLocalidad.add(per4);
        perNif.add(per1);
        perNif.add(per2);
        perNif.add(per3);
        perNif.add(per4);
        
       /* //listarArbol(apellidosNombre);
        System.out.println("Listado Por Apellidos, Nombre---------");
        System.out.println("listarArbol:"+apellidosNombre);
        System.out.println("Listado Por Localidad        ---------");
        System.out.println("listarArbol:"+perLocalidad);
        System.out.println("Listado Por Nif        ---------");
        System.out.println("listarArbol:"+perNif);*/
        
        System.out.println("listado de treeMap");
        System.out.println(treeMapPersonas);
        
        System.out.println("listado de hashmap");
        System.out.println(hashMapPersonas);
        
    }
}
