/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

/**
 *
 * @author RafaMar
 */
public class HundirLaFlota {
    
    public static final int JUGADOR1 = 0;
    
    public static final int JUGADOR2 = 1;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Jugador [] jugadores = new Jugador [2];
        
        Turno turno = new Turno(JUGADOR1);
        
        for (Jugador jugador : jugadores) {
            jugador = new Jugador();
            jugador.inicializarTablero();
            jugador.posicionaBarcos();
        }
        
        boolean fin = false;
        
        while(!fin){
            jugadores[turno.esTurnoDe()].getTablero().mostrarTablero();
            Coordenada coordenadaActual = jugadores[turno.esTurnoDe()].elegirCoordenada();
            if(jugadores[turno.noEsTurnoDe()].getTablero().compruebaCoordenada(coordenadaActual)==Tipo.Agua){
                jugadores[turno.noEsTurnoDe()].getTablero().mostrarCoordenada(coordenadaActual);
                turno.cambiaTurno();
            }else {
                jugadores[turno.noEsTurnoDe()].getTablero().mostrarCoordenada(coordenadaActual);
                boolean barcoHundido = jugadores[turno.noEsTurnoDe()].getTablero().compruebaBarcoHundido(coordenadaActual);
                
                if(barcoHundido){
                    jugadores[turno.noEsTurnoDe()].decrementarNumeroBarcosDisponibles();
                    jugadores[turno.noEsTurnoDe()].getTablero().hundirBarco(coordenadaActual);
                }
                if(jugadores[turno.noEsTurnoDe()].getNumeroBarcosDisponibles()==0){
                    fin = true;
                }
            }
        }
        
        for (Jugador jugador : jugadores) {
            jugador.getTablero().mostrarTablero();
        }
        
        
    }

   
}
