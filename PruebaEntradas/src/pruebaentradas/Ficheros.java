/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaentradas;

import java.io.*;

/**
 * @since 2017/03/08
 * @author RafaMar
 */
public class Ficheros implements Serializable{
    
   /* public static void main (String [] args){
        try {
            copiaFichero();
        } catch (IOException ex) {
            System.out.println("Error de E/S");
        }
    }*/

    private static void copiaFichero() throws IOException {
        File ficheroEntrada = new File("original.txt");    
        File ficheroSalida = new File ("copia.txt");
        
        FileWriter salida;
        try (FileReader entrada = new FileReader(ficheroEntrada)) {
            salida = new FileWriter(ficheroSalida);
            int dato;
            while ((dato=entrada.read())!=-1)
                salida.write(dato);
        }
        salida.close();
    }
    
    
    
}
