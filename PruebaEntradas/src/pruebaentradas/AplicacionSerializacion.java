/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaentradas;

import java.io.*;

/**
 *
 * @author RafaMar
 */
 public class AplicacionSerializacion {
     
    public static void main (String [] args)throws IOException,ClassNotFoundException{
        Punto punto = new Punto(1,5);
        ObjectOutputStream ficheroObjetosSalida= new ObjectOutputStream(new FileOutputStream("ficheroTemporal"));
        
        ficheroObjetosSalida.writeObject(punto);
        ficheroObjetosSalida.close();
        
        ObjectInputStream ficheroObjetoEntrada = new ObjectInputStream(new FileInputStream("ficheroTemporal"));
        
        Punto punto2 = (Punto) ficheroObjetoEntrada.readObject();
        ficheroObjetoEntrada.close();
        
        System.out.println(punto2);
    }  
 }   
   
