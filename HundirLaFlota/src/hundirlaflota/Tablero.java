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
class Tablero {
    
    HashSet <Coordenada> coordenadas = new HashSet();
    
    ArrayList <Barco> listaBarcos = new ArrayList();
    
    int dimensionTablero;

    public Tablero(int dimensionTablero) {
        this.dimensionTablero = dimensionTablero;
    }
     public HashSet<Coordenada> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(HashSet<Coordenada> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public ArrayList<Barco> getListaBarcos() {
        return listaBarcos;
    }

    public void setListaBarcos(ArrayList<Barco> listaBarcos) {
        this.listaBarcos = listaBarcos;
    }

    public int getDimensionTablero() {
        return dimensionTablero;
    }

    public void setDimensionTablero(int dimensionTablero) {
        this.dimensionTablero = dimensionTablero;
    }   
    
    void inicializarTablero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void colocarBarco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
