package videoclub;


import java.util.ArrayList;
import java.util.Objects;

public class Copia {

    private int numeroCopias;
    
    private String codigoPelicula;

    public Copia(int numeroCopias, String codigoPelicula) {
        this.numeroCopias = numeroCopias;
        this.codigoPelicula = codigoPelicula;
    }

    public int getNumeroCopias() {
        return numeroCopias;
    }

    public void setNumeroCopias(int numeroCopias) {
        this.numeroCopias = numeroCopias;
    }

    public String getCodigoPelicula() {
        return codigoPelicula;
    }

    public void setCodigoPelicula(String codigoPelicula) {
        this.codigoPelicula = codigoPelicula;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigoPelicula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Copia other = (Copia) obj;
        if (!Objects.equals(this.codigoPelicula, other.codigoPelicula)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Copia{" + "numeroCopias=" + numeroCopias + ", codigoPelicula=" + codigoPelicula + '}';
    }
    
    
    
}
