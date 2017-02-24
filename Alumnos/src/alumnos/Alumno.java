/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

import utilidades67.personas.Persona;

/**
 *
 * @author RafaMar
 */
public class Alumno extends Persona{
    
    private int nie;
    private boolean beca;
    private String centroProcedencia;
    
    /*Constructor Básico*/
    public Alumno(String nombre, String apellidos, String nif) {
        super(nombre, apellidos, nif);
    }
    
    /*Constructor con los atributos propios de la clase Alumno*/
    public Alumno(String nombre, String apellidos, String nif, int nie, boolean beca, String centroProcedencia) {
        super(nombre, apellidos, nif);
        this.nie = nie;
        this.beca = beca;
        this.centroProcedencia = centroProcedencia;
    }
                                /******GETTERS & SETTERS******/
    public int getNie() {
        return nie;
    }

    public void setNie(int nie) {
        this.nie = nie;
    }

    public String getCentroProcedencia() {
        return centroProcedencia;
    }

    public void setCentroProcedencia(String centroProcedencia) {
        this.centroProcedencia = centroProcedencia;
    }

    public boolean isBeca() {
        return beca;
    }

    public void setBeca(boolean beca) {
        this.beca = beca;
    }
    
    
    /*MODIFICAMOS EL TOSTRING PARA QUE SE ADAPTE AL ESTILO PEDIDO*/
    @Override
    public String toString() {
        return apellidos+", "+nombre+", " + nie+", "+pintaBeca()+", "+centroProcedencia+"\n";
    }

    private String pintaBeca() {
        if (this.isBeca()){
            return "Tiene Beca";
        }else
            return "No tiene Beca";
    }

    
   
}
