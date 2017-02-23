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
    
    private Date fechaMatricula;
    
    private String nifCliente;
    
    private ArrayList accesorios;

    public CocheMatriculado(String numMatricula, Date fechaMatricula, String nifCliente, ArrayList accesorios, String marca, String modelo, int clinidrada, String tipoCombustible) {
        super(marca, modelo, clinidrada, tipoCombustible);
        this.numMatricula = numMatricula;
        this.fechaMatricula = fechaMatricula;
        this.nifCliente = nifCliente;
        this.accesorios = accesorios;
    }
    
    
}
