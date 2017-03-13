/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probandoscanner;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RafaMar
 */
public class ProbandoScanner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File palabras = new File("palabras.txt");
        leeNumerosDeTeclado();

    }

    private static void leeDeFicheroLineaSC(File fichero) {

        try {
            String salida = "";
            Scanner scanner = new Scanner(fichero);
            while (scanner.hasNextLine()) {
                salida += scanner.nextLine();
                salida += "\n";
            }
            scanner.close();
            System.out.println(salida);
        } catch (FileNotFoundException ex) {
            System.out.println("Error de E/S de Fichero");
        }
    }

    private static List<String> leeDeFicheroDelimitanteSC(String nombreFichero, String delimitante) {
        List<String> lista = new LinkedList();
        try (Scanner scanner = new Scanner(nombreFichero).useDelimiter("\\s*" + delimitante + "\\s*")) {
            while (scanner.hasNext()) {
                lista.add(scanner.next());
            }
        }
        return lista;
    }

    private static void creaListaDeEnteros(File fichero) {
        //Modificar por doubles en caso de no ser enteros
        try {
            List<Integer> lista = new LinkedList();
            Scanner scanner = new Scanner(fichero);
            while (scanner.hasNextInt()) {
                lista.add(scanner.nextInt());
            }
            scanner.close();
            System.out.println("La lista de Numeros leidos es: " + lista);
        } catch (FileNotFoundException ex) {
            System.out.println("Error de E/S de Fichero");
        }
    }

    private static void leeNumerosDeTeclado() {

        List<Integer> lista = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca los numeros."
                + "\nPara SALIR introduzca numero negativo");
        boolean fin = false;
        while (!fin && scanner.hasNext()) {
            int entero = scanner.nextInt();
            if (entero >= 0) {
                lista.add(entero);
                fin = false;
            } else {
                fin = true;
            }
        }
        scanner.close();
        System.out.println("La lista de Numeros leidos es: " + lista);
    }
}
