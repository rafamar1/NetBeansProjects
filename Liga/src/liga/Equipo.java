/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liga;

/**
 *
 * @author RafaMar
 */
public class Equipo {
    
    private Jugador [] jugadores = new Jugador [24];
    private Jugador [] capitan = new Jugador [1];
    private Entrenador [] entrenadores = new Entrenador [4];
    private Persona []  presidente = new Persona [1];
    private String nomEquipo;
    private String nomEstadio;
    private String localidad;
    
    //-----METODOS DE LA CLASE----//
    
    //CONSTRUCTORES//

    public Equipo(Jugador[] jugadores, Jugador [] capitan, Entrenador[] entrenador, Persona[] presidente, String nomEquipo, String nomEstadio, String localidad) {
        this.jugadores = jugadores;
        this.capitan = capitan;
        this.entrenadores = entrenador;
        this.presidente = presidente;
        this.nomEquipo = nomEquipo;
        this.nomEstadio = nomEstadio;
        this.localidad = localidad;
    }
    
    public Equipo(String nomEquipo, String nomEstadio, String localidad){
        this.nomEquipo = nomEquipo;
        this.nomEstadio = nomEstadio;
        this.localidad = localidad;
     
    }
    
  //Getter&Setters//

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    public Jugador[] getCapitan() {
        return capitan;
    }

    public void setCapitan(Jugador[] capitan) {
        this.capitan = capitan;
    }

    public Entrenador[] getEntrenador() {
        return entrenadores;
    }

    public void setEntrenador(Entrenador[] entrenador) {
        this.entrenadores = entrenador;
    }

    public Persona[] getPresidente() {
        return presidente;
    }

    public void setPresidente(Persona[] presidente) {
        this.presidente = presidente;
    }

    public String getNomEquipo() {
        return nomEquipo;
    }

    public void setNomEquipo(String nomEquipo) {
        this.nomEquipo = nomEquipo;
    }

    public String getNomEstadio() {
        return nomEstadio;
    }

    public void setNomEstadio(String nomEstadio) {
        this.nomEstadio = nomEstadio;
    }

    public String getLocalidad() {   //Suponemos que el equipo no cambia de localidad
        return localidad;
    }

    /*-----METODO TOSTRING*/    
    @Override
    public String toString() {
        return "Equipo{" + "jugadores=" + imprimirJugador(jugadores) + ", capitan=" + imprimirJugador(capitan) + ", entrenadores=" + imprimirEntrenador(entrenadores)
                            + ", presidente=" + imprimirPersona(presidente) + ", nomEquipo=" + nomEquipo + ", nomEstadio=" + nomEstadio + ", localidad=" + localidad + '}';
    }
    
    

  
    
       
    //DAR DE ALTA JUGADORES ENTRENADORES Y CAPITAN//
    
      public void altaJugador(Jugador jugador){
        
          int i=0;
        while(jugadores[i] !=null)
            i++;
        if(i==jugadores.length)
            System.out.println("Plantilla de jugadores al completo");
        else    
            this.jugadores[i]=jugador;
        
    }
      
      public void altaEntrenador(Entrenador entrenador){
       int i=0;
        while(entrenadores[i] !=null)
            i++;
        if(i==entrenadores.length)
            System.out.println("Staff de entrenadores completo");
        else    
            this.entrenadores[i]=entrenador;
        
    }
    
    public void altaCapitan(Jugador capitan){
        this.capitan[0]=capitan;
    }
    
    public void altaPresi(Persona presi){
        this.presidente[0]=presi;
    }
  
    
/*METODOS PARA IMPRIMIR LOS ARRAYS*/
    private String imprimirJugador(Jugador[] array){
            int i=0;
            String salida="";
            while(array[i]!=null){
                salida+=", ";
                salida+=array[i];
                i++;
            }
            salida+=".";
            return salida;
        }
    
    private String imprimirEntrenador(Entrenador[] array){
            int i=0;
            String salida="";
            while(array[i]!=null){
                salida+=", ";
                salida+=array[i];
                i++;
            }
            salida+=".";
            return salida;
        }
    private String imprimirPersona(Persona[] array){
            int i=0;
            String salida="";
            while(array[i]!=null){
                salida+=", ";
                salida+=array[i];
                i++;
            }
            salida+=".";
            return salida;
        }
    
}
