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
        return tablero.elegirCoordenada();
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


   public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }



}
