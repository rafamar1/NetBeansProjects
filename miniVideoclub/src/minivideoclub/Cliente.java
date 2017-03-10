package minivideoclub;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Cliente implements Serializable {

    private String nombre;

    private HashMap<String,ArrayList<Copia>> peliculasAlquiladas;

    public Cliente(String nombre) {
        this.nombre = nombre;
        peliculasAlquiladas= new HashMap();
    }

    public String getNombre() {
        return nombre;
    }

    public HashMap<String, ArrayList<Copia>> getPeliculasAlquiladas() {
        return peliculasAlquiladas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.nombre);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
  

    public void alquila(DVD p) {
    }

    public DVD devuelve(String t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + "\n\t peliculasAlquiladas=" + peliculasAlquiladas + "}\n";
    }
    
}
