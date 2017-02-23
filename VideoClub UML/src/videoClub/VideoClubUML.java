package videoClub;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import utilidades67.ES.ES;

/**
 *
 * @author RafaMar
 */
public class VideoClubUML {

    public static void main(String[] args) throws IOException {

        VideoClub miVideoClub = new VideoClub("src/datos/clientes.txt", "src/datos/peliculas.txt");
        int opcion;
        do {
            pintaMenu(generaListMenuPrincipal());

            opcion = ES.leeN("Introduzca una opcion: ");

            switch (opcion) {

                case 1:
                    //Alta Cliente    
                    break;

                case 2:
                    //Listar Clientes
                    break;

                case 3:
                    //Listar Peliculas
                    break;

                case 4:
                    //Listar Peliculas Disponibles
                    break;

                case 5:
                    //Listar Peliculas Alquiladas
                    break;

                case 6:
                    //Alquila DVD
                    break;

                case 7:
                    //Devuelve DVD
                    break;
                case 8:
                    miVideoClub.escribeSobreFichero("peliculas2.txt");
                    break;

                case 9:
                    DVD pelicula = new DVD(pideCodigo(), pideTitulo(), pideDirector(), pideActores());
                    miVideoClub.getListaPeliculas().add(pelicula);
                    int numeroDeCopias = ES.leeN("Introduzca el Numero de Copias que desee: ");
                    Copia copiaNumeroX;
                    ArrayList<Copia> copias = new ArrayList();
                    for (int i = 1; i < numeroDeCopias; i++) {
                        copiaNumeroX = new Copia(i, pelicula.getCodigo());
                        copias.add(copiaNumeroX);
                    }
                    miVideoClub.getCopiasDisponibles().put(pelicula.getTitulo(), copias);
                    break;
                case 10:
                    break;
                default:

                    break;
            }

        } while (opcion != 10);
    }
    
    private static String pideTitulo() {
        return ES.leeDeTeclado("Titulo de la Pelicula: ");
    }
    
    private static String pideCodigo() {
        return ES.leeDeTeclado("Codigo de la Pelicula: ");
    }
    
    private static String pideDirector() {
        return ES.leeDeTeclado("Director de la Pelicula: ");
    }
    
    private static ArrayList pideActores() {
        ArrayList listaActores = new ArrayList();
        /*FALTA DESARROLLAR EL IR PIDIENDO UNO A UNO LOS ACTORES,
        HASTA PULSAR UNA TECLA Y DECIR QUE YA NO HAY MAS*/
        return listaActores;
    }
    
    private static void pintaMenu(ArrayList<String> menu) {

        int i = 1;
        for (String posicion : menu) {
            System.out.println(i + ".- " + posicion);
            i++;
        }
    }

    private static ArrayList<String> generaListMenuPrincipal() {

        ArrayList<String> menuPrincipal = new ArrayList();
        menuPrincipal.add("Alta Cliente");
        menuPrincipal.add("Listar Clientes");
        menuPrincipal.add("Listar Peliculas");
        menuPrincipal.add("Listar Peliculas Disponibles");
        menuPrincipal.add("Listar Peliculas Alquiladas");
        menuPrincipal.add("Alquila DVD");
        menuPrincipal.add("Devuelve DVD");
        menuPrincipal.add("GENERAR FICHERO DE PELICULAS");
        menuPrincipal.add("DAR DE ALTA UNA NUEVA PELICULA");
        menuPrincipal.add("Salir");

        return menuPrincipal;
    }



}
