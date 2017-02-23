/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package empresahashandmap;

import java.util.HashMap;
import java.util.TreeMap;


public class Empresa {

    private String cif;
    private String nombre;
    private String localidad;
    private HashMap<String, Cliente> listaNifClientes;
    private TreeMap<String, String> listaNombreClientes;
    
    public Empresa(String cif, String nombre, String localidad){
        this.cif = cif;
        this.nombre = nombre;
        this.localidad = localidad;
        listaNifClientes = new HashMap();
        listaNombreClientes = new TreeMap();
    }
    
    public String getCif(){
        return cif;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getLocalidad(){
        return localidad;
    }
    
    public HashMap getListaNifClientes(){
        return listaNifClientes;
    }
    
    public TreeMap getListaNombreClientes(){
        return listaNombreClientes;
    }
    
    
}
