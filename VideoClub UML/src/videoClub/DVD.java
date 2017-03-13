package videoClub;


import java.io.*;
import java.util.*;

public class DVD implements Comparable,Serializable {

    private String codigo;

    private String titulo;

    private String director;

    private ArrayList<String> listaActores;

   public DVD (String codigo, String titulo, String director, ArrayList listaActores){
       this.codigo=codigo;
       this.titulo=titulo;
       this.director=director;
       this.listaActores=listaActores;
   }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public ArrayList getListaActores() {
        return listaActores;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.titulo);
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
        final DVD other = (DVD) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "Titulo de la Pelicula= " + titulo + "Codigo= " + codigo + "Director= " +
                                        director + "Lista de Actores=" + listaActores ;
    }

    
    @Override
    public int compareTo(Object objeto) {
        DVD dvd = (DVD) objeto;
        return this.getTitulo().compareToIgnoreCase(dvd.getTitulo());
    }
    
}
