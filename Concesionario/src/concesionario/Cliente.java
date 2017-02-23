/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

import java.util.ArrayList;
import utilidades67.personas.Persona;

/**
 *
 * @author RafaMar
 */
public class Cliente extends Persona{
    
    private ArrayList<String> matriculasCochesComprados;
    
    private String sexo;


    public Cliente(String nombre,String apellidos, String nif, int edad,int telefono,String sexo) {
        super(nombre, nif , apellidos , edad, telefono);
        this.sexo=sexo;
    }
    public Cliente(String nombre, String apellidos,String nif, int edad,int telefono, String sexo,ArrayList<String> matriculasCochesComprados) {
       super(nombre, nif , apellidos , edad, telefono);
       this.matriculasCochesComprados=matriculasCochesComprados;
       this.sexo=sexo;
    }

    public ArrayList<String> getMatriculasCochesComprados() {
        return matriculasCochesComprados;
    }

    public void setMatriculasCochesComprados(ArrayList<String> matriculasCochesComprados) {
        this.matriculasCochesComprados = matriculasCochesComprados;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
}
