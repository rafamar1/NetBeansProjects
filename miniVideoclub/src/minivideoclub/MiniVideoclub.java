/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minivideoclub;

import java.io.File;

/**
 *
 * @author profesor
 */
public class MiniVideoclub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        VideoClub miVideoClub= new VideoClub();
        
        miVideoClub.cargaClientesDeFicheroScanner("src/datos/clientes.txt");
        
        File fichDvd=new File("src/datos/datosVideoclub.dat");
            if(fichDvd.exists())
        miVideoClub=miVideoClub.leeDatosvideoclub
                            ("src/datos/datosVideoclub.dat");
            else
           miVideoClub.cargaPeliculasDeFichero(miVideoClub,"src/datos/peliculas.txt");  
                                   
        
        System.out.println("Estado del videoclub...");
        System.out.println(miVideoClub);
        
        miVideoClub.guardaDatosVideoclub("src/datos/datosVideoclub.dat");
        

    }
    
}
