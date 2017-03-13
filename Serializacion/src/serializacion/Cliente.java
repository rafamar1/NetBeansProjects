/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion;

import java.io.*;

/**
 *
 * @author RafaMar
 */
public class Cliente  implements Serializable{
    
    private String nombre;
    private transient String password;
    
    public Cliente(String nombre, String pass){
        this.nombre=nombre;
        this.password=pass;
    }
    
    @Override
    public String toString(){
        String texto=(password==null)?"(No Disponible)":password;
        texto+=nombre;
        return texto;
    }
}
