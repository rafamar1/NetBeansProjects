/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbasedatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author RafaMar
 */
public class Conexion {
    
        public String nombreBD = "XE";
        public String direccion = "@localhost:1521";
        public String urlORACLE = "jdbc:oracle:thin:" + direccion + ":" + nombreBD ;
        public String user = "system";
        public String pass = "system";
        
        Connection conexionBD = null;
        
        Driver driver = new oracle.jdbc.OracleDriver();
        
        
        public Connection conectar() {

            try {
                
                DriverManager.registerDriver(driver);

                conexionBD = DriverManager.getConnection(this.urlORACLE, this.user, this.pass);

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, ex);

            }

            return conexionBD;
           

        }
        
        public boolean compruebaConexion() throws SQLException {
            return !conexionBD.isClosed();
        }
        
        public void cerrar() {
            
            if(conexionBD!=null){
                try {
                    if(!conexionBD.isClosed()){
                        conexionBD.close();
                    }
                } catch (SQLException ex) {
                    System.out.println("Error cerrando Base de Datos");
                }
            }
        }

}
