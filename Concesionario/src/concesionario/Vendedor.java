/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

import utilidades67.personas.Persona;

/**
 *
 * @author RafaMar
 */
public class Vendedor extends Persona{
    
    private double totalVentas;
    
    public Vendedor(String nombre, String nif) {
        super(nombre, nif);
        totalVentas=0;
    }
    
}
