/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;
import utilidades67.personas.*;
/**
 *
 * @author Pedro
 */
public class Excepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       try{
        provocaExcepciones();
       }
       catch (Exception e){
             System.err.println("Error inesperado en el Main->"+ e.toString());
             
        }
    }
    //-----
    static void provocaExcepciones(){  
        
         Persona[] listaPersonas=new Persona[10];
         Persona pepe=null;
         
         try {
             String numero="33";
             
             int otroNumero= Integer.parseInt(numero);
             
             otroNumero/=0;
             
             pepe.toString();
             
             listaPersonas[10].toString();
            
            
            
        } catch (NumberFormatException | NullPointerException e) {
             System.err.println("Error Formato de numero incorrecto ->"+ e.toString());
        
        } 
         catch (ArrayIndexOutOfBoundsException e) {
             System.err.println("Fuera de índice->"+ e.toString());
         }
        
    
    }
}
