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
public class ContactoInput {

    private FileInputStream fileInput;
    private ObjectInputStream objectInput;

    public void abrir() throws IOException {
        fileInput = new FileInputStream("contactos.dat");
        objectInput = new ObjectInputStream(fileInput);
    }

    public void cerrar() throws IOException {
        if (objectInput != null) {
            objectInput.close();
        }
    }

    public Contacto leer() throws IOException, ClassNotFoundException {
        Contacto contacto = null;
        if (objectInput != null) {
            contacto = (Contacto) objectInput.readObject();
        }
        return contacto;
    }

}
