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
public class ContactoOutput {

    private FileOutputStream fileOutput;
    private ObjectOutputStream objectOutput;

    
    public void abreFichero() throws IOException {
        fileOutput = new FileOutputStream("clientes.ser");
        objectOutput = new ObjectOutputStream(fileOutput);
    }
    
    public void cierraFichero() throws IOException {
        if (objectOutput != null) {
            objectOutput.close();
        }
    }
    
    public void escribeFichero(Contacto contacto) throws IOException {
        if (objectOutput != null) {
            objectOutput.writeObject(contacto);
        }
    }

}
