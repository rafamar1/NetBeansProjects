/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

import java.util.Objects;

/**
 *
 * @author RafaMar
 */
public class Coche {
    
    String marca;
    
    String color;
    
    int km;
    
    String numeroBastidor;
    
    int numeroCoches;
    
    int numeroMatriculaciones;

    public Coche(String marca, String color, int km, String numeroBastidor) {
        this.marca = marca;
        this.color = color;
        this.km = km;
        this.numeroBastidor = numeroBastidor;
        numeroCoches++;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getNumeroBastidor() {
        return numeroBastidor;
    }
    
    public int getNumeroCoches() {
        return numeroCoches;
    }

    public void setNumeroCoches(int numeroCoches) {
        this.numeroCoches = numeroCoches;
    }

    public int getNumeroMatriculaciones() {
        return numeroMatriculaciones;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatriculaciones = numeroMatricula;
    }

    @Override
    public String toString() {
        return "Numero de Bastidor=" + numeroBastidor +"\nMarca: " + marca + "; Color: " + color + "; Nº de Kilometros:" + km;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.numeroBastidor);
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
        final Coche other = (Coche) obj;
        if (!Objects.equals(this.numeroBastidor, other.numeroBastidor)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
