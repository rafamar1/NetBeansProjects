/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author RafaMar
 */
public class CocheMatriculado extends CocheStock {
    
    private String numMatricula;
    
    private String fechaMatricula;
    
    private String nifCliente;
    
    private ArrayList<String> listaAccesorios = new ArrayList<>();

    public CocheMatriculado(String marca,String modelo, int cilindrada, String tipoCombustible, String numBastidor,String numMatricula, String fechaMatricula, String nifCliente, ArrayList accesorios) {
        super(marca, modelo, cilindrada, tipoCombustible,numBastidor);
        this.numMatricula = numMatricula;
        this.fechaMatricula = fechaMatricula;
        this.nifCliente = nifCliente;
        this.listaAccesorios = accesorios;
    }
    
    
    
}
