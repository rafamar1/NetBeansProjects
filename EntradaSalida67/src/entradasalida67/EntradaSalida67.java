/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradasalida67;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author RafaMar
 */
public class EntradaSalida67 {

    public static void main(String[] args) throws IOException {
        
        guardaCliente("src/datos/");
        
       
        System.out.println("Listado de clientes");
        leeDeFichero("src/datos/clientes.txt");
        /*escribeSobreFichero("src/datos/clientes.txt");*/
        
        
        
      
    }

    static void leeDeTeclado(String mensaje) throws IOException {

        int c;
        int contador = 0;
        System.out.println(mensaje);
        //se lee hasta encontrar el fin de línea
        while ((c = System.in.read()) != '\n') {
            contador++;
            System.out.println((char) c);
        }
        System.out.println(); //Se escribe el cambio de linea
        System.err.println("Contados " + contador + " bytes en total.");
    }

    private static String leeDeTeclado2(String mensaje) throws IOException {

        int c;
        String salida = "";
        System.out.println(mensaje);
        //Lo va guardando y cuando damos enter lo imprime
        while ((c = System.in.read()) != '\n') {
            salida += (char) c;

        }
        return salida;
    }

    private static String leeDeTecladoBuffer(String mensaje) throws IOException {
        System.out.println(mensaje);
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader Teclado = new BufferedReader(isr);
        return Teclado.readLine();
    }

    private static int leeInt(String mensaje) throws IOException {

        String entrada = "";
        int entero = 0;
        boolean esEntero = false;
        do {
            try {
                entrada = leeDeTecladoBuffer(mensaje);
                entero = Integer.parseInt(entrada);
                esEntero = true;
            } catch (NumberFormatException e) {
                System.out.println("No es un entero válido!!!");
            }
        } while (!esEntero);
        return entero;
    }

    private static void leeDeFichero(String nombreFichero) throws FileNotFoundException, IOException {

        FileReader fileReader;
        BufferedReader bufferedReader = null;
        String linea;
        try {

            fileReader = new FileReader(nombreFichero);
            bufferedReader = new BufferedReader(fileReader);

            while ((linea = bufferedReader.readLine()) != null) {

                System.out.println(linea);

            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error en el fichero -> " + nombreFichero + " no se puede abrir");
        } finally {
            bufferedReader.close();
        }

    }
    
    public static void escribeSobreFichero(String ficheroCliente) throws IOException{
                 
        String nombre=leeDeTeclado2("Introduzca el nombre: ");
        String apellido=leeDeTeclado2("Introduzca el apellido: ");
        
        FileWriter fileWriter = new FileWriter(ficheroCliente, true); 
        PrintWriter printWriter = new PrintWriter(fileWriter);
        /*El true de este metodo FileWriter permite añadir linea, si fuera
        false sobreescribiria el fichero con lo que nosotros vamos a almacenar*/
        
        printWriter.println();
        printWriter.print(nombre);
        printWriter.print(" ");
        printWriter.print(apellido);
        
        fileWriter.close(); /*Hay que cerrar el canal de comunicacion*/
    }
    
     public static void guardaCliente(String carpeta) throws IOException{
         
        File directorio = new File(carpeta);
        
        System.out.println("Listado de Ficheros del Directorio *"+directorio+"*");
        String [] listaFichero = directorio.list();
        
        for (String fichero:listaFichero){
            
             System.out.println(fichero);
        }
        String nombreFichero=leeDeTeclado2("Introduzca el nombre del Fichero: ");
        
        String nombre=leeDeTeclado2("Introduzca el nombre: ");
        String apellido=leeDeTeclado2("Introduzca el apellido: ");
        
        
        FileWriter fileWriter = new FileWriter(carpeta + "\\" 
                                              + nombreFichero, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        
        printWriter.println();
        printWriter.print(nombre);
        printWriter.print(" ");
        printWriter.print(apellido);
        
        fileWriter.close(); /*Hay que cerrar el canal de comunicacion*/
    }
    
}
