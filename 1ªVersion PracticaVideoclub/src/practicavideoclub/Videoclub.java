/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicavideoclub;

import java.util.ArrayList;

/**
 *
 * @author RafaMar
 */
public class Videoclub {
    private ArrayList<Cliente> listaClientes;
    private ArrayList<DVD> listaPeliculas;
    private ArrayList<DVD> peliculasDisponibles;

    public Videoclub(ArrayList<Cliente> clientes, ArrayList<DVD> peliculas) {
        this.listaClientes.addAll(clientes);
        this.listaPeliculas.addAll(peliculas);
        peliculasDisponibles=this.listaPeliculas;
    }
    
    public ArrayList<DVD> copias(String titulo){
        ArrayList<DVD> copias = new ArrayList();
        for (DVD pelicula:listaPeliculas){
           if (pelicula.getTitulo().equalsIgnoreCase(titulo))
               for(Cliente cliente:listaClientes){
                   if(cliente.devuelve(titulo)==null)
                       copias.add(pelicula);
               }
        }
        return copias;
    }  
    
    public Cliente cliente(String nombre){
        for(Cliente cliente:listaClientes){
            if(cliente.getNombre().equalsIgnoreCase(nombre))
                return cliente;
        }
        return null;
    }
    
    public void alquila (String nombre, String titulo){
       for(Cliente cliente:listaClientes){
            if (cliente.getNombre().equalsIgnoreCase(nombre)){ 
                for(DVD pelicula:peliculasDisponibles){
                  if(pelicula.getTitulo().equalsIgnoreCase(titulo)){
                      cliente(nombre).alquila(pelicula);
                  }
                }
                System.out.println("No existe la pelicula");
                return;
            }
            System.out.println("No existe el cliente");
        }
    }
       
    public void devuelve (String nombre, String titulo){
       for(Cliente cliente:listaClientes){
            if (cliente.getNombre().equalsIgnoreCase(nombre)){ 
                for(DVD pelicula:listaPeliculas){
                  if(pelicula.getTitulo().equalsIgnoreCase(titulo)){
                      peliculasDisponibles.add(cliente(nombre).devuelve(titulo));
                      cliente.devuelve(pelicula);
                  }
                }
            }
            System.out.println("No existe el cliente");
        }
    } 
     
     
    public String disponibles(){
        String pelisDisponibles="";
        for(DVD pelicula:peliculasDisponibles){
            if(!this.copias(pelicula.getTitulo()).isEmpty())
                    pelisDisponibles+=pelicula.getTitulo();
        }
        return pelisDisponibles;
    }
    
    /*REVISAR CUANDO NO HAY PELICULA ALQUILADA*/
    public String alquiladas(String nombre){
        String pelisAlquiladas="";
            for(Cliente cliente:listaClientes){
                if(cliente.getNombre().equalsIgnoreCase(nombre))
                    pelisAlquiladas+=cliente.getpeliculasAlquiladas();
            }
       return pelisAlquiladas;
    }
    
       
    
}
    

