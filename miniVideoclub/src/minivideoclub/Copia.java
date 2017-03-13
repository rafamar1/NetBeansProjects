package minivideoclub;

import java.io.Serializable;

public class Copia implements Serializable {

    private int     numCopia;
    private String  dvd    ;

    public Copia(int numCopia, String dvd) {
        this.numCopia = numCopia;
        this.dvd = dvd;
    }

    public int getNumCopia() {
        return numCopia;
    }

    public void setNumCopia(int numCopia) {
        this.numCopia = numCopia;
    }

    public String getDvd() {
        return dvd;
    }

    public void setDvd(String dvd) {
        this.dvd = dvd;
    }

    @Override
    public String toString() {
        return "\n\t\t{" + "numCopia=" + numCopia + "}";
    }

   
    
    
}
