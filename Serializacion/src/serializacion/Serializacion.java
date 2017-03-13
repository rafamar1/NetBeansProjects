/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion;

import java.io.*;

/**
 *
 * @author RafaMar
 */
public class Serializacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Cliente cliente = new Cliente("Pedrin","password123");
        
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("src/datos/cliente.obj"));
            
            salida.writeObject("Datos del cliente\n");
            salida.writeObject(cliente);
            salida.close();
            
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("src/datos/cliente.obj"));
            String string = (String) entrada.readObject();
            Cliente objeto = (Cliente) entrada.readObject();
            
            System.out.println("/**-----------**\\");
            System.out.println(string+" "+objeto);
            System.out.println("/**-----------**\\");
            entrada.close();
            
        } catch (IOException ex) {
            System.out.println("Error de E/S!");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        
        try{
            //Esto se hace para esperar la pulsacion de una tecla y luego intro
            System.in.read();
        } catch (Exception e){}
        
    }
    
}
