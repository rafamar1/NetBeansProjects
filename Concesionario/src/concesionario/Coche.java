/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

/**
 *
 * @author RafaMar
 */
public class Coche {
    
    private String marca;
    
    private String modelo;
    
    private int clinidrada;
    
    private String tipoCombustible;
    

    public Coche(String marca, String modelo, int clinidrada, String tipoCombustible) {
        this.marca = marca;
        this.modelo = modelo;
        this.clinidrada = clinidrada;
        this.tipoCombustible = tipoCombustible;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getClinidrada() {
        return clinidrada;
    }

    public void setClinidrada(int clinidrada) {
        this.clinidrada = clinidrada;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }


   
}
