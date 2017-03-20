/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

import utilidades67.ES.ES;
/**
 *
 * @author RafaMar
 */
class Jugador {

    private int numeroBarcosDisponibles;
    
    Tablero tablero;
    
    private final int NUMERO_BARCOS = 5;
    
    private final int DIMENSION_TABLERO = 5;
    
    
    
    public Jugador(){
        numeroBarcosDisponibles = NUMERO_BARCOS;
        
        tablero = new Tablero(DIMENSION_TABLERO);
        
    }
    
    void inicializarTablero() {
        tablero.inicializarTablero();
    }

    void posicionaBarcos() {
        
        for (int i = 0; i < NUMERO_BARCOS; i++) {
            tablero.colocarBarco();
        }
    }

    Coordenada elegirCoordenada() {
        int x = ES.leeN("Introduzca la posicion x [Entre 1 y "+DIMENSION_TABLERO+"]", 1, DIMENSION_TABLERO);
        int y = ES.leeN("Introduzca la posicion y [Entre 1 y "+DIMENSION_TABLERO+"]", 1, DIMENSION_TABLERO);
        Coordenada coordenada = new Coordenada (x,y);
        //tablero.ENCONTRARBARCO
        return coordenada;
    }

    Tipo compruebaCoordenada(Coordenada posicionActual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void mostrarCoordenada(Coordenada coordenadaActual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean compruebaBarco(Coordenada coordenadaActual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNumeroBarcosDisponibles() {
        return numeroBarcosDisponibles;
    }

    public void setNumeroBarcosDisponibles(int numeroBarcosDisponibles) {
        this.numeroBarcosDisponibles = numeroBarcosDisponibles;
    }

    void decrementarNumeroBarcosDisponibles() {
       setNumeroBarcosDisponibles(getNumeroBarcosDisponibles() - 1);
    }

    void hundirBarco(Coordenada coordenadaActual) {
        //Cambiar TIPO a BarcoHundido
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void mostrarTablero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }



}
