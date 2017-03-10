package minivideoclub;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class DVD implements Comparable, Serializable {

    private String codigo;

    private String titulo;

    private String director;

    private ArrayList listaActores;
    private static final long serialVersionUID =1L;

    public DVD(String codigo, String titulo, String director, ArrayList listaActores) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.listaActores = listaActores;
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
    public String toString() {
        return "\n\t\tDVD{" + "codigo=" + codigo + ", titulo=" + titulo + ", director=" + director + "\n\t\t, listaActores=" + listaActores + "}\n";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.titulo);
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
    public int compareTo(Object o) {
        return this.titulo.compareToIgnoreCase(((DVD)o).titulo);
    }

    

   

}
