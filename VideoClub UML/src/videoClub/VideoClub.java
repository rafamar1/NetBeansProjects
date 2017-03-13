package videoClub;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class VideoClub {

    private HashMap<String, Cliente> listaClientes;

    private TreeSet<DVD> listaPeliculas;

    private HashMap<String, ArrayList<Copia>> copiasDisponibles;

    public VideoClub(String clientes, String peliculas) throws IOException {
        this.listaClientes = new HashMap();
        this.listaPeliculas = new TreeSet();
        this.copiasDisponibles = new HashMap();
        cargaClientesDeFichero(clientes);
        cargaPeliculasDeFichero(peliculas);
    }

    public HashMap getListaClientes() {
        return listaClientes;
    }

    public TreeSet getListaPeliculas() {
        return listaPeliculas;
    }

    public HashMap<String, ArrayList<Copia>> getCopiasDisponibles() {
        return copiasDisponibles;
    }

    @Override
    /*MEJORAR ESTO!!!!!!!*/
    public String toString() {
        return "\t\t\t\t/****----VideoClub----****\\\n" + "Lista de Clientes:" + pintaNombreClientes()
                + ", listaPeliculas=" + listaPeliculas + ", copiasDisponibles=" + copiasDisponibles + '}';
    }

    public Set<Copia> copias(String titulo) {
        /*IDEA - NO SERIA MEJOR QUE DEVOLVIERA UN ARRAYLIST Y NO UN SET????*/
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Cliente cliente(String nombre) {
        return listaClientes.get(nombre);
    }

    public void alquilaPelicula(String nombre, String titulo) {
        Copia copia = copiasDisponibles.get(titulo).get(0);
        cliente(nombre).alquila(titulo, copia);
        copiasDisponibles.get(titulo).remove(copia);
    }

    public void devuelve(String nombre, String titulo) {
        Copia copia = cliente(nombre).devuelve(titulo);
        copiasDisponibles.get(titulo).add(copia);
    }

    public void copiasDisponibles() {
        Set<String> conjuntoTitulosCopias = copiasDisponibles.keySet();
        for (String tituloCopias : conjuntoTitulosCopias) {
            System.out.println(tituloCopias);
            ArrayList<Copia> listaCopias = copiasDisponibles.get(tituloCopias);
            for (Copia copia : listaCopias) {
                System.out.println(copia.toString());
            }
        }
    }
    
    /*METODO ALTERNATIVO
    public void copiasDisponibles() {
        Set<Entry<String, ArrayList<Copia>>> conjuntoListaCopias = copiasDisponibles.entrySet();
        for (Entry<String, ArrayList<Copia>> listaCopias : conjuntoListaCopias) {
            System.out.println(listaCopias.getKey() + ": ");
            for (Copia copia : listaCopias.getValue()) {
                System.out.println("\t" + copia);
            }
        }
    }*/

    public void copiasAlquiladas(String nombreCliente) {
        String peliculasAlquiladas = cliente(nombreCliente).pintaPeliculasAlquiladas();
        System.out.println(peliculasAlquiladas);
    }

    private void cargaClientesDeFichero(String nombreFichero) throws FileNotFoundException, IOException {

        FileReader fileReader;
        BufferedReader bufferedReader = null;
        String linea;
        try {

            fileReader = new FileReader(nombreFichero);
            bufferedReader = new BufferedReader(fileReader);

            while ((linea = bufferedReader.readLine()) != null) {

                Cliente cliente = new Cliente(linea);
                /*Si el metodo fuera estatico la siguiente linea daria error, ya que hemos definido
                  el atributo lineaClientes como no-estatico*/
                listaClientes.put(cliente.getNombreCliente(), cliente);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error en el fichero -> " + nombreFichero + " no se puede abrir");
        } finally {
            bufferedReader.close();
        }
    }

    private void cargaPeliculasDeFichero(String nombreFichero) throws FileNotFoundException, IOException {

        FileReader fileReader;
        BufferedReader bufferedReader = null;
        String linea;
        try {

            fileReader = new FileReader(nombreFichero);
            bufferedReader = new BufferedReader(fileReader);
            DVD pelicula;
            while ((linea = bufferedReader.readLine()) != null) {
                /*Split va añadiendo cada separacion por "*" a una nueva posicion del array*/
                String[] datosPelicula = linea.split("\\*");/*El asterisco es un caracter especial
                                                                y debe tratarse con la doble "\\"*/
                String[] arrayActores = datosPelicula[3].split(",");

                ArrayList actores = new ArrayList();
                for (String actor : arrayActores) {
                    actores.add(actor);
                }
                pelicula = new DVD(datosPelicula[0], datosPelicula[1], datosPelicula[2], actores);
                listaPeliculas.add(pelicula);
                int numeroDeCopias = Integer.parseInt(datosPelicula[4]);
                Copia copiaNumeroX;
                ArrayList<Copia> copias = new ArrayList();
                for (int i = 1; i < numeroDeCopias; i++) {
                    copiaNumeroX = new Copia(i, pelicula.getCodigo());
                    copias.add(copiaNumeroX);
                }
                copiasDisponibles.put(pelicula.getTitulo(), copias);
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error en el fichero -> " + nombreFichero + " no se puede abrir");
        }
    }

    public void escribeSobreFichero(String ficheroPelicula) throws IOException {

        FileWriter fileWriter = new FileWriter(ficheroPelicula, false);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        Iterator iterador = listaPeliculas.iterator();
        while (iterador.hasNext()) {
            Map.Entry pelicula = (Map.Entry) iterador.next();
            DVD peli = (DVD) pelicula.getValue();
            int numeroCopias = copiasDisponibles.get(peli.getCodigo()).size();
            printWriter.println();
            printWriter.print(numeroCopias);
            printWriter.print(";");
            printWriter.print(peli.getCodigo());
            printWriter.print(";");
            printWriter.print(peli.getTitulo());
            printWriter.print(";");
            printWriter.print(peli.getDirector());
            printWriter.print(";");
            ArrayList actores = peli.getListaActores();
            for (Object actor : actores) {
                printWriter.print(actor);
                printWriter.print("#");
            }

            fileWriter.close();
        }

    }

    private String pintaNombreClientes() {
        String cadena = "";
        Iterator iterador = listaClientes.entrySet().iterator();
        while (iterador.hasNext()) {
            Map.Entry entry = (Map.Entry) iterador.next();
            cadena += "\n\t- " + entry.getKey();
        }
        return cadena + "\n";
    }
}
