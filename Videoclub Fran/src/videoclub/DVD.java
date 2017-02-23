package videoclub;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DVD implements Comparable{

    private String codigo;

    private String titulo;

    private ArrayList<String> listaActores;

    private String director;

    public DVD(String codigo,String titulo, String director, ArrayList<String> listaActores) {
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

    public ArrayList<String> getListaActores() {
        return listaActores;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public int compareTo(Object o) {
        DVD dvd = (DVD)o;
        return this.titulo.compareToIgnoreCase(dvd.titulo);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.titulo);
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

    
    
    

    
    
}
