/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbasedatos;

import java.sql.SQLException;

/**
 *
 * @author RafaMar
 */
public class ConexionBaseDatos {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws SQLException {
        
        Conexion conexion = new Conexion();
        
        conexion.conectar();
        
        if(conexion.compruebaConexion()){
            System.out.println("Base de Datos Conectada");
        }
            
        
    }
    
}
