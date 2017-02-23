/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;
import utilidades67.ES.ES;
import utilidades67.personas.Persona;

/**
 *
 * @author profesor
 */
public class Empresa {

    private HashMap<String, Cliente> clientesNIF;
    private TreeMap<String, String> clientesOrdenados;
    /*El segundo String es el nif que permite identificar al cliente de forma unica, el primero es para ordenar*/
    private String Cif;

    public Empresa(String Cif) {
        this.Cif = Cif;
        clientesNIF         = new HashMap();
        clientesOrdenados   = new TreeMap();
    }

    public Empresa(HashMap<String, Cliente> clientesNIF, TreeMap<String, String> clientesOrdenados, String Cif) {
        this.clientesNIF = clientesNIF;
        this.clientesOrdenados = clientesOrdenados;
        this.Cif = Cif;
    }

    public HashMap<String, Cliente> getClientesNIF() {
        return clientesNIF;
    }

    public void setClientesNIF(HashMap<String, Cliente> clientesNIF) {
        this.clientesNIF = clientesNIF;
    }

    public TreeMap<String, String> getClientesOrdenados() {
        return clientesOrdenados;
    }

    public void setClientesOrdenados(TreeMap<String, String> clientesOrdenados) {
        this.clientesOrdenados = clientesOrdenados;
    }

    public String getCif() {
        return Cif;
    }

    public void setCif(String Cif) {
        this.Cif = Cif;
    }

}