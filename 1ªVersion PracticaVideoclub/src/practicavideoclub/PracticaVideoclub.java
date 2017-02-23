/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicavideoclub;

import java.util.ArrayList;

/**
 *
 * @author RafaMar
 */
public class PracticaVideoclub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> listaActores=new ArrayList();
        listaActores.add("Carrey");
        listaActores.add("Freeman");
        listaActores.add("Aniston");
        
        
        DVD comoDios= new DVD("0005","Como Dios","Shadyac",listaActores);
        
        System.out.println(comoDios);
    }
    
}
