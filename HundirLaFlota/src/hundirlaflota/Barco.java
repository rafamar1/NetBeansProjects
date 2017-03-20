/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

import java.util.*;

/**
 *
 * @author RafaMar
 */
class Barco {
    
    private int dimension;
    
    TreeSet <Coordenada> posicionBarco= new TreeSet();
    
    public Barco(int dimension){
        this.dimension = dimension;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public TreeSet<Coordenada> getPosicionBarco() {
        return posicionBarco;
    }

    public void setPosicionBarco(TreeSet<Coordenada> posicionBarco) {
        this.posicionBarco = posicionBarco;
    }
    
    
}
