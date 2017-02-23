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
public class Cliente {
    private String nombre;
    private ArrayList <DVD> peliculasAlquiladas;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    

    public ArrayList<DVD> getpeliculasAlquiladas() {
        return peliculasAlquiladas;
    }

    public void setPpeliculasAlquiladas(ArrayList<DVD> peliculasAlquiladas) {
        this.peliculasAlquiladas = peliculasAlquiladas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nombre);
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
        if (!Objects.equals(this.nombre.toLowerCase(), other.nombre.toLowerCase())) {
            return false;
        }
        return true;
    }
    
    public void alquila(DVD pelicula){
        this.peliculasAlquiladas.add(pelicula);
    }
    
    public DVD devuelve (String titulo){
        for(DVD element:peliculasAlquiladas){
            if(element.getTitulo().equalsIgnoreCase(titulo)) 
                return element;
                }
        return null;
    }
    
    public void devuelve(DVD pelicula){
        for(DVD elemento:peliculasAlquiladas){
            if (elemento.getTitulo().equalsIgnoreCase(pelicula.getTitulo())) {
                this.peliculasAlquiladas.remove(elemento);
            }
        }
    }
    
    
    
}
