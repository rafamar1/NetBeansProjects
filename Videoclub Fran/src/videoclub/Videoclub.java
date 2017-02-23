package videoclub;

import java.io.*;
import java.util.*;
import utilidades67.ES.ES;

public class Videoclub {

    private HashMap<String, Cliente> listaClientes;

    private TreeSet<DVD> listaPeliculas;

    private HashMap<String, ArrayList<Copia>> peliculasDisponibles;

    public Videoclub(String clientes, String peliculas) {
        listaClientes = new HashMap();
        listaPeliculas = new TreeSet();
        peliculasDisponibles = new HashMap();
        cargaClientesDeFichero(clientes);
        cargaPeliculasDeFichero(peliculas);
    }

    public void gestionarMenuPrincipal() {
        int opcion;
        do {
            listarMenu();
            opcion = ES.leeN("Introduzca opcion: ");
            switch (opcion) {

                case 1:
                    verPeliculasVideoclub();
                    break;

                case 2:
                    obtenerCliente();
                    break;

                case 3:
                    alquilarPelicula();
                    break;

                case 4:
                    devolverPelicula();
                    break;

                case 5:
                    verCopiasDisponibles();
                    break;

                case 6:
                    verCopiasAlquiladas();
                    break;

                case 7:
                    altaPeliculas();
                    break;

                case 8:
                    guardaPeliculasFichero("src/datos/peliculas2.txt");
                    break;

                case 9:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion Errónea...");
                    break;
            }

        } while (opcion != 9);
    }

    private void listarMenu() {
        ArrayList menu = new ArrayList();
        System.out.println("\n--Menú Principal--\n");
        menu.add("Ver Peliculas Del Videoclub");
        menu.add("Obtener Datos Cliente");
        menu.add("Alquilar Película");
        menu.add("Devolver Película");
        menu.add("Ver Copias Disponibles");
        menu.add("Ver Copias Alquiladas por cliente");
        menu.add("Dar de Alta una Pelicula");
        menu.add("Guardar Peliculas en el Fichero");
        menu.add("Salir\n");
        Menu menus = new Menu();
        menus.pintaMenu(menu);
    }

    private void obtenerCliente() {
        Cliente cliente = cliente(pideNombre());
        System.out.println(cliente);
    }

    public Cliente cliente(String nombre) {
        assert listaClientes.containsKey(nombre);
        return listaClientes.get(nombre);
    }

    private void alquilarPelicula() {
        alquila(pideNombre(), pideTitulo());
    }

    public void alquila(String nombre, String titulo) {
        assert peliculasDisponibles.containsKey(titulo);
        assert listaClientes.containsKey(nombre);
        Copia copia = peliculasDisponibles.get(titulo).get(0);
        listaClientes.get(nombre).alquila(titulo, copia);
        peliculasDisponibles.get(titulo).remove(0);
    }

    private void devolverPelicula() {
        devuelve(pideNombre(), pideTitulo());
    }

    public void devuelve(String nombre, String titulo) {
        assert listaClientes.containsKey(nombre);
        assert listaPeliculas.contains(titulo);
        assert listaClientes.get(nombre).getPeliculasAlquiladas().containsKey(titulo);
        Copia copia = listaClientes.get(nombre).devuelve(titulo);
        peliculasDisponibles.get(titulo).add(copia);
    }

    private void verCopiasAlquiladas() {
        boolean error = false;
        String nombreCliente = "";
        do {
            nombreCliente = pideNombre();
            if (!listaClientes.containsKey(nombreCliente)) {
                try {
                    throw new VideoClubException("Error");
                } catch (VideoClubException e) {
                    error = true;
                    System.err.println(e.getMessage());
                }
            } else {
                error = false;
            }
        } while (error);
        System.out.println(alquiladas(nombreCliente));
    }

    public String alquiladas(String nombreCliente) {
        assert listaClientes.containsKey(nombreCliente);
        String salida = "";
        Cliente cliente = listaClientes.get(nombreCliente);
        Set<String> conjuntoPeliculasAlquiladas = cliente.getPeliculasAlquiladas().keySet();
        for (String pelicula : conjuntoPeliculasAlquiladas) {
            int numeroCopias = cliente.getPeliculasAlquiladas().get(pelicula).size();
            if (numeroCopias == 1) {
                salida += pelicula + ": " + numeroCopias + " copia.";
            } else {
                salida += pelicula + ": " + numeroCopias + " copias.";
            }
            salida += "\n";
        }
        if(conjuntoPeliculasAlquiladas.isEmpty()){
            salida = "\nNo tiene Peliculas Alquiladas";
        }
        
        return salida;
    }

    private void verCopiasDisponibles() {
        Set<Map.Entry<String, ArrayList<Copia>>> entrySet = peliculasDisponibles.entrySet();
        for (Map.Entry<String, ArrayList<Copia>> entry : entrySet) {
            System.out.println(entry.getKey() + ": ");
            for (Copia copia : entry.getValue()) {
                System.out.println("\t" + copia);
            }
        }
    }

    public String disponibles() {
        String salida = "";
        Set<HashMap.Entry<String, ArrayList<Copia>>> entrySet = peliculasDisponibles.entrySet();
        for (Map.Entry<String, ArrayList<Copia>> entry : entrySet) {
            salida += "\t" + entry.getKey() + "\n";
        }
        return salida;
    }

    private void cargaClientesDeFichero(String nombreFichero) {
        try {
            FileReader fichero;
            BufferedReader bufferedReader = null;
            String linea;
            try {
                fichero = new FileReader(nombreFichero);
                bufferedReader = new BufferedReader(fichero);
                Cliente cliente;
                while ((linea = bufferedReader.readLine()) != null) {
                    cliente = new Cliente(linea);
                    this.listaClientes.put(cliente.getNombre(), cliente);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Error accediendo el fichero: " + nombreFichero);
            } finally {
                bufferedReader.close();
            }
        } catch (IOException excepcion) {
            System.err.println("Excepcion en el cliente de fichero: "+ excepcion.getMessage());
        }

    }

    private void cargaPeliculasDeFichero(String nombreFichero){
        try {
            FileReader fichero;
            BufferedReader bufferedReader = null;
            String linea;
            try {
                fichero = new FileReader(nombreFichero);
                bufferedReader = new BufferedReader(fichero);
                DVD pelicula;
                while ((linea = bufferedReader.readLine()) != null) {
                    String[] datosPelicula = linea.split("\\*");
                    String[] actores = datosPelicula[3].split(",");
                    ArrayList<String> listaActores = new ArrayList();
                    for (String actor : actores) {
                        listaActores.add(actor);
                    }
                    Copia copia;
                    pelicula = new DVD(datosPelicula[0], datosPelicula[1], datosPelicula[2], listaActores);
                    listaPeliculas.add(pelicula);
                    int numeroCopias;
                    numeroCopias = Integer.parseInt(datosPelicula[4]);
                    ArrayList<Copia> listaCopias = new ArrayList();
                    for (int i = 1; i <= numeroCopias; i++) {
                        copia = new Copia(i, pelicula.getCodigo());
                        listaCopias.add(copia);
                    }
                    peliculasDisponibles.put(pelicula.getTitulo(), listaCopias);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Error accediendo el fichero: " + nombreFichero);
            } finally {
                bufferedReader.close();
            }
        } catch (IOException excepcion) {
            System.err.println("Excepcion en el cliente de fichero: "+ excepcion.getMessage());
        }

    }

    private String pideNombre() {
        listarClientes();
        return ES.leeDeTeclado("\nIntroduce el Nombre del Cliente: ");
    }

    private String pideTitulo() {
        listarPeliculasDisponibles();
        return ES.leeDeTeclado("\nIntroduce el Titulo de la Pelicula: ");
    }

    private void listarPeliculasDisponibles() {
        System.out.println("\n*** Lista de Peliculas ***");
        Set<String> conjuntoPeliculas = peliculasDisponibles.keySet();
        for (String pelicula : conjuntoPeliculas) {
            System.out.println(pelicula);
        }
    }

    private void listarClientes() {
        System.out.println("\n*** Lista de Clientes ***\n");
        Set<String> conjuntoClientes = listaClientes.keySet();
        for (String cliente : conjuntoClientes) {
            System.out.println(cliente);
        }
    }

    public HashMap<String, Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(HashMap<String, Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public TreeSet<DVD> getListaPeliculas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(TreeSet<DVD> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    public HashMap<String, ArrayList<Copia>> getPeliculasDisponibles() {
        return peliculasDisponibles;
    }

    public void setPeliculasDisponibles(HashMap<String, ArrayList<Copia>> peliculasDisponibles) {
        this.peliculasDisponibles = peliculasDisponibles;
    }

    public void guardaPeliculasFichero(String nombreArchivo) {
        try {
            FileWriter fileWriter = new FileWriter(nombreArchivo, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Set<String> keySet = peliculasDisponibles.keySet();
            for (String key : keySet) {
                int numeroCopias = getPeliculasDisponibles().get(key).size();
                DVD pelicula;
                Iterator iterator = listaPeliculas.descendingIterator();
                bufferedWriter.newLine();
                while (iterator.hasNext()) {
                    pelicula = (DVD) iterator.next();
                    if (pelicula.getTitulo().equalsIgnoreCase(key)) {
                        bufferedWriter.newLine();
                        bufferedWriter.write("" + numeroCopias);
                        bufferedWriter.write(";");
                        bufferedWriter.write(pelicula.getCodigo());
                        bufferedWriter.write(";");
                        bufferedWriter.write(pelicula.getTitulo());
                        bufferedWriter.write(";");
                        bufferedWriter.write(pelicula.getDirector());
                        bufferedWriter.write(";");
                        for (int i = 0; i < pelicula.getListaActores().size() - 1; i++) {
                            bufferedWriter.write(pelicula.getListaActores().get(i));
                            bufferedWriter.write("#");
                        }
                        bufferedWriter.write(pelicula.getListaActores().get(pelicula.getListaActores().size() - 1));
                    }
                }
            }
            bufferedWriter.close();
        } catch (IOException excepcion) {
            System.err.println("Excepcion en el cliente de fichero: "+ excepcion.getMessage());
        }

    }

    public void altaPeliculas() {
        try {
            DVD pelicula = null;
            String titulo = pideNuevoTitulo();
            Iterator iterator = listaPeliculas.descendingIterator();
            ArrayList<DVD> conjuntoPeliculas = new ArrayList();
            while (iterator.hasNext()) {
                conjuntoPeliculas.add((DVD) iterator.next());
            }
            for (DVD peliculas : conjuntoPeliculas) {
                if (peliculas.getTitulo().equalsIgnoreCase(titulo)) {
                    throw new VideoClubException("Ya existe la pelicula");
                }

            }
            ArrayList<String> listaActores = pideListaActores();
            pelicula = new DVD(pideCodigo(), titulo, pideDirector(), listaActores);
            listaPeliculas.add(pelicula);
            ArrayList<Copia> listaCopias = new ArrayList();
            Copia copia;
            int numeroCopias = ES.leeN("Introduce la cantidad de copias:");
            for (int i = 1; i <= numeroCopias; i++) {
                copia = new Copia(i, pelicula.getCodigo());
                listaCopias.add(copia);
            }
            peliculasDisponibles.put(titulo, listaCopias);
        } catch (VideoClubException excepcion) {
            System.err.println(excepcion.getMessage());
        }

    }

    public String pideCodigo() {

        return "" + listaPeliculas.size();
    }

    public String pideNuevoTitulo() {
        return ES.leeDeTeclado("Introduce el Nombre de la nueva Pelicula: ");
    }

    private String pideDirector() {
        return ES.leeDeTeclado("Introduce el Nombre del Director");
    }

    private static ArrayList<String> pideListaActores() {
        boolean salir = false;
        ArrayList<String> listaActores = new ArrayList();
        do {
            String nombre = ES.leeDeTeclado("Introduce un Actor o Introduce X para concluir");

            if (nombre.equalsIgnoreCase("x")) {
                salir = true;
            } else {
                listaActores.add(nombre);
            }
        } while (!salir);
        return listaActores;
    }

    private void verPeliculasVideoclub() {
        Iterator iterator = listaPeliculas.descendingIterator();
        System.out.println("*** Listado Peliculas ***\n");
        while (iterator.hasNext()) {
            DVD pelicula = (DVD) iterator.next();
            System.out.println(pelicula.getTitulo());
        }
    }
}
