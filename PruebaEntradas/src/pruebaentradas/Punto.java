/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaentradas;

import java.io.*;

/**
 *
 * @author RafaMar
 */
public class Punto implements Serializable {

    int x, y;

    java.util.Date fecha;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Punto[ " + x + "," + y + "]";
    }

    private void writeObject(ObjectOutputStream salida) throws IOException {
        salida.writeInt(x);
        salida.writeInt(y);
    }
    
    private void readObject(ObjectInputStream entrada) throws IOException, ClassNotFoundException{
        x=entrada.readInt();
        y=entrada.readInt();
        fecha = new java.util.Date();
    }

}
