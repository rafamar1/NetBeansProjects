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
class Turno {
    
    private int turno;

    Turno(int turnoInicial) {
        this.turno = turnoInicial;
    }

    int esTurnoDe() {
        return turno;
    }

    int noEsTurnoDe() {
        int noEsTurnoDe;
        if(esTurnoDe()==0){
            noEsTurnoDe = 1;
        }
        else{
            noEsTurnoDe = 0;
        }
        return noEsTurnoDe;
    }

    void cambiaTurno() {
        turno = esTurnoDe() == 0 ? 1:0;
    }
    
}
