/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;
import utilidades67.ES.ES;
import utilidades67.personas.Persona;
/**
 *
 * @author profesor
 */
public class Cliente extends Persona{
    

   private String eMail;
   private int compras=0;

    public Cliente(String eMail, String nombre, String apellidos, String nif) {
        super(nombre, apellidos, nif);
        this.eMail = eMail;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getCompras() {
        return compras;
    }

    public void setCompras(int compras) {
        this.compras = compras;
    }

    @Override
    public String toString() {
        return super.toString() + "eMail=" + eMail + ", compras=" + compras;
    }
   
   
           
    
}
