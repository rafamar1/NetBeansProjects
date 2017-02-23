/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.HashSet;
import java.util.TreeSet;

/**
 *
 * @author RafaMar
 */
public class Colecciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashSet<Cliente> hashSetCliente = new HashSet();
        Cliente cliente1 = new Cliente("Fran");
        Cliente cliente2 = new Cliente("Fran1");
        Cliente cliente3 = new Cliente("Fran2");
        Cliente cliente4 = new Cliente("Fran3");
        Cliente cliente5 = new Cliente("Fran");
        Cliente cliente6 = new Cliente("Fraa");
        Cliente cliente7 = new Cliente("Frap");
        Cliente cliente8 = new Cliente("Fran9");
        hashSetCliente.add(cliente1);
        hashSetCliente.add(cliente2);
        hashSetCliente.add(cliente3);
        hashSetCliente.add(cliente4);
        hashSetCliente.add(cliente5);
        hashSetCliente.add(cliente6);
        hashSetCliente.add(cliente7);
        hashSetCliente.add(cliente8);
        System.out.println(hashSetCliente);
        
        TreeSet<Cliente> treeSetCliente = new TreeSet();
        treeSetCliente.add(cliente1);
        treeSetCliente.add(cliente2);
        treeSetCliente.add(cliente3);
        treeSetCliente.add(cliente4);
        treeSetCliente.add(cliente5);
        treeSetCliente.add(cliente6);
        treeSetCliente.add(cliente7);
        treeSetCliente.add(cliente8);
        System.out.println(treeSetCliente);
        
    }
    
}
