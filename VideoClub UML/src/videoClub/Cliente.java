package videoClub;

import java.util.*;

public class Cliente {

    private String nombreCliente;

    private HashMap<String, ArrayList<Copia>> peliculasAlquiladas;

    public Cliente(String nombre) {
        this.nombreCliente = nombre;
        peliculasAlquiladas = new HashMap();
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public HashMap<String, ArrayList<Copia>> getPeliculasAlquiladas() {
        return peliculasAlquiladas;
    }

    public String pintaPeliculasAlquiladas() {
        String salida = "";

        Set<String> setPeliculas = peliculasAlquiladas.keySet();
        if (setPeliculas.isEmpty()) {
            return "No tiene Peliculas Alquiladas";
        } else {
            for (String tituloPelicula : setPeliculas) {
                int numeroCopias = peliculasAlquiladas.get(tituloPelicula).size();
                salida += tituloPelicula + ": " + numeroCopias + " copias\n";

            }
            return salida;
        }

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.nombreCliente);
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
        if (!Objects.equals(this.nombreCliente, other.nombreCliente)) {
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
        ArrayList<Copia> listaCopias = peliculasAlquiladas.get(titulo);
        Copia copia = listaCopias.get(0);
        listaCopias.remove(0);
        if (listaCopias.isEmpty()) {
            peliculasAlquiladas.remove(titulo);
        } else {
            peliculasAlquiladas.replace(titulo, listaCopias);
        }
        return copia;
    }
}
