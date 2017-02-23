/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicavideoclub;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author RafaMar
 */
public class DVD {
    private String codigo;
    private String titulo;
    private String director;
    private ArrayList <String> actores;
    

    private DVD (){
    }
    
    public DVD(String codigo, String titulo, String director, ArrayList<String> actores) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.actores = actores;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<String> getActores() {
        return actores;
    }

    public void setActores(ArrayList<String> actores) {
        this.actores = actores;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.codigo);
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
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DVD{" + codigo +": "+ titulo + "(dirigida por" + director + "e interpetada por[" + actores +"])"+'}';
    }
    
    
    
    
    
    
    
    
    
    
}
