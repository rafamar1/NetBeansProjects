/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minivideoclub;

import java.io.File;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author profesor
 */
public class MiniVideoclub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
     
        VideoClub miVideoClub= new VideoClub();
        
        miVideoClub.cargaClientesDeFicheroScanner("src/datos/clientes.txt");
        
        File fichDvd=new File("src/datos/datosVideoclub.dat");
            if(fichDvd.exists())
        miVideoClub=miVideoClub.leeDatosvideoclub
                            ("src/datos/datosVideoclub.dat");
            else
                
           miVideoClub.cargaPeliculasDeFicheroScanner(miVideoClub,"src/datos/peliculas.txt");  
           miVideoClub.generaInformeCopias();
           
        guardaDatosVideoClub(miVideoClub,"src/datos/datosVideoclub");
            
            //System.out.println("Estado del videoclub...");
            //System.out.println(miVideoClub);

        

    }

    private static void guardaDatosVideoClub(VideoClub videoclub, String rutaFichero) {
        
        try {
            try (ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(rutaFichero))) {
                 objectOutput.writeObject(videoclub);
            }
        } catch (IOException ex) {
            System.out.println("Error de E/S");
        }
    }
    
}
