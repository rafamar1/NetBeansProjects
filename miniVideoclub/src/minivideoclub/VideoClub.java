package minivideoclub;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VideoClub implements Serializable{

    private HashMap listaClientes;

    private TreeSet listaPeliculas;

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
                linea= sc.next();
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
        VideoClub miVideo=null;
        
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
            Logger.getLogger(VideoClub.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(VideoClub.class.getName()).log(Level.SEVERE, null, ex);
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
        Scanner sc,scPeli = null;
        
        TreeSet listaPeliculas = miVideoClub.getListaPeliculas();
        HashMap peliculasDisponibles = miVideoClub.getPeliculasDisponibles();
        try {
            sc = new Scanner(miFile);
            
            String linea;
            
            DVD peli;
            while (sc.hasNextLine()) {
                String datosP = sc.nextLine();
                
                scPeli=new Scanner(datosP);
                scPeli.useDelimiter("*");
                
                /*while(scPeli.hasNext()){
                                }*/
                
                
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
            Logger.getLogger(VideoClub.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(VideoClub.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//cargaPeliculasDeFichero
}