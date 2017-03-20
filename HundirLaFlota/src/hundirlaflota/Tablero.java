/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

import java.util.*;
import utilidades67.ES.ES;

/**
 *
 * @author RafaMar
 */
class Tablero {

    HashSet<Coordenada> coordenadas = new HashSet();

    ArrayList<Barco> listaBarcos = new ArrayList();

    int dimensionTablero;

    public Tablero(int dimensionTablero) {
        this.dimensionTablero = dimensionTablero;
    }

    public HashSet<Coordenada> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(HashSet<Coordenada> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public ArrayList<Barco> getListaBarcos() {
        return listaBarcos;
    }

    public void setListaBarcos(ArrayList<Barco> listaBarcos) {
        this.listaBarcos = listaBarcos;
    }

    public int getDimensionTablero() {
        return dimensionTablero;
    }

    public void setDimensionTablero(int dimensionTablero) {
        this.dimensionTablero = dimensionTablero;
    }

    void inicializarTablero() {
        for (int i = 0; i < dimensionTablero; i++) {
            for (int j = 0; j < dimensionTablero; j++) {
                coordenadas.add(new Coordenada(i, j));
            }
        }
    }

    void colocarBarco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Coordenada elegirCoordenada() {
        int x = ES.leeN("Introduzca la posicion x [Entre 1 y " + dimensionTablero + "]", 1, dimensionTablero);
        int y = ES.leeN("Introduzca la posicion y [Entre 1 y " + dimensionTablero + "]", 1, dimensionTablero);
        Coordenada coordenadaPedida = new Coordenada(x, y);

        return obtenCoordenada(coordenadaPedida);
    }

    private Coordenada obtenCoordenada(Coordenada coordenadaPedida) {
        for (Coordenada coordenada : coordenadas) {
            if (coordenadaPedida.equals(coordenada)) {
                return coordenada;
            }
        }
        return null;
    }

    Tipo compruebaCoordenada(Coordenada coordenadaActual) {
        Coordenada coordenadaComprueba = obtenCoordenada(coordenadaActual);

        Tipo tipo = coordenadaComprueba.getEstado();
        if (tipo == Tipo.SinMostrar) {
            tipo = Tipo.Agua;
            for (Barco barco : listaBarcos) {
                TreeSet<Coordenada> coordenadasBarcos = barco.getPosicionBarco();
                for (Coordenada coordenadasBarco : coordenadasBarcos) {
                    if (coordenadaComprueba.equals(coordenadasBarco)) {
                        tipo = Tipo.BarcoTocado;
                    }
                }
            }
        }
        return tipo;
    }

    void mostrarCoordenada(Coordenada coordenada) {
        Coordenada miCoordenada = obtenCoordenada(coordenada);
        miCoordenada.setEstado(compruebaCoordenada(miCoordenada));
    }

    boolean compruebaBarcoHundido(Coordenada coordenada) {
        boolean hundido = false;
        Coordenada miCoordenada = obtenCoordenada(coordenada);
        for (Barco barco : listaBarcos) {
            if (barco.getPosicionBarco().contains(miCoordenada)) {
                int longitudDisponibleBarco = barco.getDimension();

                for (Coordenada coordenadaBarco : barco.getPosicionBarco()) {
                    for (Coordenada coordenadaTablero : coordenadas) {
                        if (coordenadaTablero.equals(coordenadaBarco)) {
                            if (coordenadaTablero.getEstado() == Tipo.BarcoTocado) {
                                longitudDisponibleBarco--;
                            }
                        }
                    }

                }
                if (longitudDisponibleBarco == 0) {
                    hundido = true;
                }
            }

        }
        return hundido;
    }

    void hundirBarco(Coordenada coordenada) {

        Coordenada miCoordenada = obtenCoordenada(coordenada);
        for (Barco barco : listaBarcos) {
            if (barco.getPosicionBarco().contains(miCoordenada)) {

                for (Coordenada coordenadaBarco : barco.getPosicionBarco()) {
                    for (Coordenada coordenadaTablero : coordenadas) {
                        if (coordenadaTablero.equals(coordenadaBarco)) {
                            coordenadaTablero.setEstado(Tipo.BarcoHundido);
                        }
                    }

                }

            }

        }

    }

    void mostrarTablero() {

        TreeMap<String, Coordenada> mapaCoordenadasOrdenadas = new TreeMap();

        for (Coordenada coordenada : coordenadas) {
            int x = coordenada.getX();
            int y = coordenada.getY();
            mapaCoordenadasOrdenadas.put(x + "," + y, coordenada);
        }
    }

}
