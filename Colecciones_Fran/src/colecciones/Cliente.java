/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.Objects;

/**
 *
 * @author RafaMar
 */
public class Cliente implements Comparable{
    String nombre;
    
    public Cliente(String nombre){
        this.nombre=nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.nombre);
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

    @Override
    public int compareTo(Object o) {
        Cliente cliente = (Cliente)o;
        return this.nombre.compareToIgnoreCase(cliente.nombre);
    }
    
}
