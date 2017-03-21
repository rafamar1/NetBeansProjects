/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

import java.util.TreeSet;
import utilidades67.personas.Persona;

/**
 *
 * @author RafaMar
 */
public class Cliente extends Persona{
    
    int codigoCliente;
    
    TreeSet<Matriculacion> listaMatriculaciones = new TreeSet();
    
    public Cliente(String nombre, String nif) {
        super(nombre, nif);
    }

    public Cliente(int codigoCliente, String nombre, String apellidos, String nif) {
        super(nombre, apellidos, nif);
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    @Override
    public String toString() {
        return "CodigoCliente: " + codigoCliente + "Coches Matriculados" + pintaListaMatriculaciones() + super.toString();
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public TreeSet<Matriculacion> getListaMatriculaciones() {
        return listaMatriculaciones;
    }

    public void setListaMatriculaciones(TreeSet<Matriculacion> listaMatriculaciones) {
        this.listaMatriculaciones = listaMatriculaciones;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.codigoCliente;
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
        if (this.codigoCliente != other.codigoCliente) {
            return false;
        }
        return true;
    }

    private String pintaListaMatriculaciones() {
        String salida="";
        for (Matriculacion matriculacion : listaMatriculaciones) {
            salida+= matriculacion;
        }
    return salida;
    }

}
