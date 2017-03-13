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
    
    private int cilindrada;
    
    private String tipoCombustible;
    

    public Coche(String marca, String modelo, int clinidrada, String tipoCombustible) {
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = clinidrada;
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

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    @Override
    public String toString() {
        return "Coche{" + "marca=" + marca + ", modelo=" + modelo + ", clinidrada=" + cilindrada + ", tipoCombustible=" + tipoCombustible + '}';
    }


   
}
