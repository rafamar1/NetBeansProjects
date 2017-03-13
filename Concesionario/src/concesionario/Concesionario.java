/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

import java.io.*;
import java.util.*;

/**
 *
 * @author RafaMar
 */
public class Concesionario {

    private String nombreMercantil;

    private String direccion;

    private String Gerente;

    private ArrayList<Vendedor> listaTrabajadores;

    private ArrayList<CocheStock> listaCoches;

    private ArrayList<Cliente> listaClientes;

    private ArrayList<Cliente> listaClientesPotenciales;

    public Concesionario(String nombreMercantil, String direccion, String Gerente) {
        this.nombreMercantil = nombreMercantil;
        this.direccion = direccion;
        this.Gerente = Gerente;
        listaTrabajadores = new ArrayList<>();
        listaCoches = new ArrayList<>();
        listaClientes = new ArrayList<>();
        listaClientesPotenciales = new ArrayList<>();
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

    public ArrayList<CocheStock> getListaCoches() {
        return listaCoches;
    }

    public void setListaCoches(ArrayList<CocheStock> listaCoches) {
        this.listaCoches = listaCoches;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
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
    public void cargaDatosClientesFichero(String rutaFichero) {

        try {
            BufferedReader bufferedEntrada = new BufferedReader(new FileReader(rutaFichero));
            String linea;
            while ((linea = bufferedEntrada.readLine()) != null) {
                String[] datosCliente = linea.split(";");
                String[] datoCochesComprados = datosCliente[6].split("$");
                ArrayList<String> matriculasCochesComprados = new ArrayList(datoCochesComprados.length);

                for (String matricula : datoCochesComprados) {
                    matriculasCochesComprados.add(matricula);
                }
                Cliente cliente = new Cliente(datosCliente[0], datosCliente[1], datosCliente[3], Integer.parseInt(datosCliente[2]), Integer.parseInt(datosCliente[4]), datosCliente[5], matriculasCochesComprados);
                listaClientes.add(cliente);
            }
            bufferedEntrada.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado en la ruta " + rutaFichero);
        } catch (IOException ex) {
            System.out.println("Error de E/S");
        }

    }

    @Override
    public String toString() {
        return "Concesionario{" + "nombreMercantil=" + nombreMercantil + ", direccion=" + direccion + ", Gerente=" + Gerente + ", listaTrabajadores=" + listaTrabajadores + ", listaCoches=" + listaCoches + ", listaClientes=" + listaClientes + ", listaClientesPotenciales=" + listaClientesPotenciales + '}';
    }

    public void cargarDatosCochesFichero(String rutaFichero) {

        try {
            BufferedReader bufferedEntrada = new BufferedReader(new FileReader(rutaFichero));
            String linea = "";
            while ((linea = bufferedEntrada.readLine()) != null) {
                String[] datosCoche = linea.split(";");

                if (datosCoche.length > 5) {
                    String[] datosCocheMatriculado = datosCoche[5].split("\\,");
                    String nifCliente = datosCocheMatriculado[0];
                    String matricula = datosCocheMatriculado[1];
                    ArrayList<String> listaAccesorios = new ArrayList<>();
                    for (int i = 2; i < datosCocheMatriculado.length; i++) {
                        listaAccesorios.add(datosCocheMatriculado[i]);
                    }

                    CocheMatriculado coche = new CocheMatriculado(datosCoche[0], datosCoche[1], Integer.parseInt(datosCoche[2]), datosCoche[3], datosCoche[4], matricula, "Fecha de Matriculacion", nifCliente, listaAccesorios);
                    listaCoches.add(coche);
                } else {
                    CocheStock coche = new CocheStock(datosCoche[0], datosCoche[1], Integer.parseInt(datosCoche[2]), datosCoche[3], datosCoche[4]);
                    listaCoches.add(coche);
                }

            }
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado en la ruta " + rutaFichero);
        } catch (IOException ex) {
            System.out.println("Error de E/S");
        }
    }
}
