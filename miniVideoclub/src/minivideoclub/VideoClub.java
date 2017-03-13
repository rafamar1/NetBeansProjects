package minivideoclub;

import java.io.*;
import java.util.*;

public class VideoClub implements Serializable {

    private HashMap<String,Cliente> listaClientes;

    private TreeSet<DVD> listaPeliculas;

    public HashMap<String, ArrayList<Copia>> peliculasDisponibles;

    public VideoClub() {
        listaClientes = new HashMap<String, Cliente>();
        // cargaClientesDeFichero(clientes);

        listaPeliculas = new TreeSet<DVD>();
        peliculasDisponibles = new HashMap();
        // cargaPeliculasDeFichero(peliculas);

    }

    public Set<Copia> copias(String titulo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Cliente cliente(String nombre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void alquila(String nombre, String titulo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void devuelve(String nombre, String titulo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String disponibles() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String alquiladas(String nombre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //----------------------------------------
    @Override
    public String toString() {
        return "VideoClub{\n\t" + "listaClientes="
                + listaClientes + "\n\t listaPeliculas=\n\t"
                + listaPeliculas + "\n\t Copias=\n\t"
                + peliculasDisponibles + '}';
    }
    //---------------------------------------

    public HashMap getListaClientes() {
        return listaClientes;
    }

    public TreeSet getListaPeliculas() {
        return listaPeliculas;
    }

    public HashMap<String, ArrayList<Copia>> getPeliculasDisponibles() {
        return peliculasDisponibles;
    }

    public void setListaClientes(HashMap listaClientes) {
        this.listaClientes = listaClientes;
    }

    public void setPeliculasDisponibles(HashMap<String, ArrayList<Copia>> peliculasDisponibles) {
        this.peliculasDisponibles = peliculasDisponibles;
    }

    public void setListaPeliculas(TreeSet listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    // ---métodos par la persistencia de los datos.........
    //---------------------------------------
    public void cargaClientesDeFichero(String nombrefichero) {
        FileReader fichero;
        BufferedReader br = null;
        try {
            String linea;
            fichero = new FileReader(nombrefichero);
            br = new BufferedReader(fichero);
            Cliente cli;
            while ((linea = br.readLine()) != null) {
                cli = new Cliente(linea);
                listaClientes.put(cli.getNombre(), cli);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero -> " + nombrefichero + " no se encuentra");
        } catch (IOException ex) {
            System.out.println("Error de E/S ->" + ex);
        }

    }

    //-------------------------------------------------
    public void cargaClientesDeFicheroScanner(String nombrefichero) {

        File miFile = new File(nombrefichero);

        try {
            Scanner sc = new Scanner(miFile);

            String linea;

            Cliente cli;
            while (sc.hasNextLine()) {
                linea = sc.next();
                cli = new Cliente(linea);
                listaClientes.put(cli.getNombre(), cli);
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero -> " + nombrefichero + " no se encuentra");
        } catch (IOException ex) {
            System.out.println("Error de E/S ->" + ex);
        }

    }

    //-------------------------------------------------
    public VideoClub leeDatosvideoclub(String fichero) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        VideoClub miVideo = null;

        try {
            fis = new FileInputStream(fichero);
            ois = new ObjectInputStream(fis);

            /*  listaClientes=(HashMap)ois.readObject();            
                listaPeliculas=(TreeSet)ois.readObject();
                peliculasDisponibles=(HashMap)ois.readObject();  */
            miVideo = (VideoClub) ois.readObject();

            ois.close();
            return miVideo;
        } //Class
        catch (FileNotFoundException ex) {
            System.out.println("fichero no encontrado: " + fichero + "error-> " + ex);
        } catch (EOFException ex) {
            System.out.println("Final del ficheo de objetos películas");
        } catch (IOException ex) {
            System.out.println("Error de entrada /Salida->" + ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("No existe la clas Treeset");
        }
        return miVideo;
    }
//------------------------------------------------

    public void cargaPeliculasDeFichero(VideoClub miVideoClub, String nombrefichero) {
        FileReader fichero;
        BufferedReader br = null;
        TreeSet listaPeliculas = miVideoClub.getListaPeliculas();
        HashMap peliculasDisponibles = miVideoClub.getPeliculasDisponibles();
        try {
            String linea;
            fichero = new FileReader(nombrefichero);
            br = new BufferedReader(fichero);
            DVD peli;
            while ((linea = br.readLine()) != null) {
                String[] datosP = linea.split("\\*");
                String[] arrayActores = datosP[3].split(",");

                /*  List actores=new ArrayList();
                    actores=Arrays.asList(arrayActores);*/
                ArrayList actores = new ArrayList();

                for (Object actor : arrayActores) {
                    actores.add(actor);
                }

                peli = new DVD(datosP[0],
                        datosP[1],
                        datosP[2],
                        actores);

                listaPeliculas.add(peli);
                //-----Generar las copias de laa peli 
                int numCopias = Integer.parseInt(datosP[4]);
                Copia cp;

                ArrayList copias = new ArrayList();
                for (int i = 1; i < numCopias; i++) {
                    cp = new Copia(i, peli.getCodigo());
                    copias.add(cp);
                }
                peliculasDisponibles.put(peli.getTitulo(), copias);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Fichero -> " + nombrefichero + " no se encuentra");
        } catch (IOException ex) {
          } finally {
            try {
                br.close();
            } catch (IOException ex) {
             }
        }
    }//cargaPeliculasDeFichero
    //--------------------------------------------------

    public void guardaDatosVideoclub(String fichero) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(fichero);
            oos = new ObjectOutputStream(fos);

            /*
               oos.writeObject(this.listaClientes);
               oos.writeObject(this.listaPeliculas);
               oos.writeObject(this.peliculasDisponibles);*/
            oos.writeObject(this);
            oos.close();
            //return 0;   
        } catch (FileNotFoundException ex) {
            System.out.println("Error: fichero no encontrado: " + fichero
                    + "/n error->" + ex);
        } catch (IOException ex) {
            System.out.println("Error de Entrada Salida creando ObjectOutputStream-> " + ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                System.out.println("Error al cerrar el fichero: " + fichero
                        + "/n error->" + ex);
            }
        }
        //  return 0;
    }

    public void cargaPeliculasDeFicheroScanner(VideoClub miVideoClub, String nombrefichero) throws FileNotFoundException {

        File miFile = new File(nombrefichero);
        Scanner sc, scannerPeli, scannerActor = null;

        TreeSet listaPeliculas = miVideoClub.getListaPeliculas();
        HashMap peliculasDisponibles = miVideoClub.getPeliculasDisponibles();
        try {
            sc = new Scanner(miFile);

            DVD pelicula;
            while (sc.hasNextLine()) {
                
                /*Estaba dando error en esta linea porque el metodo sc.next() solo cogia hasta el siguiente espacio*/
                String datosPelicula = sc.nextLine();

                
                scannerPeli = new Scanner(datosPelicula);
                scannerPeli.useDelimiter("\\*");

                
                String codigo = scannerPeli.next();
                String titulo = scannerPeli.next();
                String director = scannerPeli.next();
                String actores = scannerPeli.next();
                int numCopias = scannerPeli.nextInt();

                //AQUI PODRIAMOS REASIGNAR EL SCANNERPELICULAS
                scannerActor = new Scanner(actores);
                scannerActor.useDelimiter(",");
                ArrayList listaActores = new ArrayList();

                while (scannerActor.hasNext()) {
                    String actor = scannerActor.next();
                    listaActores.add(actor);
                }

                pelicula = new DVD(codigo, titulo, director, listaActores);

                listaPeliculas.add(pelicula);
                //-----Generar las copias de las peli 
                Copia copia;

                ArrayList listaCopias = new ArrayList();
                for (int i = 0; i < numCopias; i++) {
                    copia = new Copia(i, pelicula.getCodigo());
                    listaCopias.add(copia);
                }
                peliculasDisponibles.put(pelicula.getTitulo(), listaCopias);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Fichero -> " + nombrefichero + " no se encuentra");
        }
    }
    
    public void generaInformeCopias() throws IOException{
        
        FileWriter informe = new FileWriter ("src/datos/informeCopias.txt");
                
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(informe));
        
        printWriter.println("Informe de Peliculas Alquiladas");
        for (DVD pelicula : listaPeliculas) {
            printWriter.println("\n/*******----"+pelicula.getTitulo()+"----*******\\\n");
            printWriter.println("\tCopias Disponibles --> "+
                                peliculasDisponibles.get(pelicula.getTitulo()).size());
            /*Hacemos un set para obtener las claves del HashMap de listaClientes
            y poder obtener asi los objetos Cliente*/
            Set<String> nombresClientes = listaClientes.keySet();
            for (String nombre : nombresClientes) {
                if(listaClientes.get(nombre).getPeliculasAlquiladas().containsKey(pelicula.getTitulo()))
                    printWriter.println(listaClientes.get(nombre).getNombre()+listaClientes.get(nombre).getPeliculasAlquiladas().get(pelicula.getTitulo()).size());
            }
            /*Si en lugar de obtener la cantidad de copias de cada pelicula que tiene cada cliente, quisieramos obtener el numero propio de copia que tiene el cliente
            tendriamos que recorrer el arrayList y obtener el numero de Copia*/
            
        }
        printWriter.println();
        printWriter.close();
        
    }
    
}
