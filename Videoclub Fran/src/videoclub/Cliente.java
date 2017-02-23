package videoclub;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Cliente {

    private String nombre;

    private HashMap<String, ArrayList<Copia>> peliculasAlquiladas;

    public Cliente(String nombre) {
        this.nombre = nombre;
        peliculasAlquiladas = new HashMap();
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
        hash = 17 * hash + Objects.hashCode(this.nombre);
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

    public void alquila(String titulo, Copia copia) {
        ArrayList<Copia> listaCopias = new ArrayList();
        if (peliculasAlquiladas.containsKey(titulo)) {
            listaCopias = peliculasAlquiladas.get(titulo);
        }
        listaCopias.add(copia);
        peliculasAlquiladas.put(titulo, listaCopias);
    }

    public Copia devuelve(String titulo) {
        assert peliculasAlquiladas.containsKey(titulo);
        ArrayList<Copia> listaCopias = peliculasAlquiladas.get(titulo);
        Copia copia = listaCopias.get(0);
        listaCopias.remove(0);
        if (listaCopias.isEmpty()) {
            peliculasAlquiladas.remove(titulo);
        }
        return copia;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", peliculasAlquiladas=" + peliculasAlquiladas + '}';
    }

}
