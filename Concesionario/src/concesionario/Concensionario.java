/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author RafaMar
 */
public class Concensionario {

    private String nombreMercantil;
    
    private String direccion;
    
    private String Gerente;
    
    private ArrayList<Vendedor> listaTrabajadores;
    
    private ArrayList<Coche> listaCoches;
    
    private ArrayList<Cliente> listaClientes;

    public Concensionario(String nombreMercantil, String direccion, String Gerente) {
        this.nombreMercantil = nombreMercantil;
        this.direccion = direccion;
        this.Gerente = Gerente;
    }

    public String getNombreMercantil() {
        return nombreMercantil;
    }

    public void setNombreMercantil(String nombreMercantil) {
        this.nombreMercantil = nombreMercantil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGerente() {
        return Gerente;
    }

    public void setGerente(String Gerente) {
        this.Gerente = Gerente;
    }

    public ArrayList<Vendedor> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(ArrayList<Vendedor> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    public ArrayList<Coche> getListaCoches() {
        return listaCoches;
    }

    public void setListaCoches(ArrayList<Coche> listaCoches) {
        this.listaCoches = listaCoches;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    
    private void cargaClientesDeFichero(String nombreFichero) throws FileNotFoundException, IOException{
        
        FileReader fileReader = new FileReader(nombreFichero);
        BufferedReader bufferedReader= new BufferedReader(fileReader);
        String linea ;
        
        while((linea=bufferedReader.readLine())!=null){
            String [] datosCliente=linea.split(";");
            String [] cochesComprados=datosCliente[6].split("\\$");
            ArrayList<String> matriculasCochesComprados = new ArrayList();
            
            for (String matricula : cochesComprados) {
                matriculasCochesComprados.add(matricula);
            }
            
            int edad= Integer.parseInt(datosCliente[2]);
            int telefono= Integer.parseInt(datosCliente[4]);
                    
            Cliente cliente = new Cliente(datosCliente[0], datosCliente[1], datosCliente[3], edad, telefono, datosCliente[5],matriculasCochesComprados);
            listaClientes.add(cliente);
        }
        
       /*private void cargaCochesDeFichero(String nombreFichero) throws FileNotFoundException, IOException{
           
           FileReader fileReader = new FileReader(nombreFichero);
           BufferedReader bufferedReader= new BufferedReader(fileReader);
           String linea;
           
            while((linea=bufferedReader.readLine())!=null){
            String [] datosCoche=linea.split(";");
            
                if(datosCoche.length>5){
                    String [] datosCocheMatriculado=linea.split(";");   
                }else {
                    CocheStock coche=new CocheStock(linea, linea, 0, nombreFichero);
                    
                }
                    
                    }
       }*/
        
    }
}

