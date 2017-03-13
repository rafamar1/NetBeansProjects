/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

import utilidades67.ES.ES;

/**
 *
 * @author RafaMar
 */
public class ManejaConcesionario {

    public static void main(String[] args) {

        Concesionario concesionario = new Concesionario(pideNombreMercantil(), pideDireccion(), pideNombreGerente());
        concesionario.cargaDatosClientesFichero("src/datos/Clientes.txt");
        concesionario.cargarDatosCochesFichero("src/datos/Coches.txt");
        System.out.println(concesionario);
    }

    private static String pideNombreMercantil() {
        return ES.leeDeTeclado("Introduzca el Nombre Mercantil: ");
    }

    private static String pideDireccion() {
        return ES.leeDeTeclado("Introduzca la Direccion del Concesionario: ");
    }

    private static String pideNombreGerente() {
        return ES.leeDeTeclado("Introduzca el Nombre del Gerente: ");
    }

}
