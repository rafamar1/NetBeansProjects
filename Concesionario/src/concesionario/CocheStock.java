/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

/**
 *
 * @author RafaMar
 */
public class CocheStock extends Coche {
    
    private String numBastidor;

    public CocheStock(String marca, String modelo, int clinidrada, String tipoCombustible) {
        super(marca, modelo, clinidrada, tipoCombustible);
    }

    public void setNumBastidor(String numBastidor) {
        this.numBastidor = numBastidor;
    }
    
}
