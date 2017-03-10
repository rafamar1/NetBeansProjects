package minivideoclub;

import java.io.Serializable;

public class Copia implements Serializable {

    private int     numCopia;
    private String  dvd    ;

    public Copia(int numCopia, String dvd) {
        this.numCopia = numCopia;
        this.dvd = dvd;
    }

    @Override
    public String toString() {
        return "\n\t\t{" + "numCopia=" + numCopia + "}";
    }

   
    
    
}
