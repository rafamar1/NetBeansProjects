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
public class Jugador extends Persona {
    
    //-------ATRIBUTOS MIEMBRO-----//
    private int n_calzado;
    private String posicion;
    private int dorsal;
    private int t_amarillas;
    private int t_rojas;
    
    
    //------METODOS MIEMBRO----//
    
    /*------Constructores------*/
    
    public Jugador(int n_calzado, String posicion, int t_amarillas, int t_rojas, String nombre, String apellidos, String dni) {
        super(nombre, apellidos, dni);
        this.n_calzado = n_calzado;
        this.posicion = posicion;
        this.t_amarillas = t_amarillas;
        this.t_rojas = t_rojas;
    }

    public Jugador(int n_calzado, String posicion, int dorsal, int t_amarillas, int t_rojas, String nombre, String apellidos, String dni, int edad, String sexo, String localidad) {
        super(nombre, apellidos, dni, edad, sexo, localidad);
        this.n_calzado = n_calzado;
        this.posicion = posicion;
        this.dorsal = dorsal;
        this.t_amarillas = t_amarillas;
        this.t_rojas = t_rojas;
    }
    
    
    
    //------Métodos miembro-----//
    public int getN_calzado() {
        return n_calzado;
    }

    public String getPosicion() {
        return posicion;
    }

    public int getDorsal() {
        return dorsal;
    }

    /*HEMOS SUPUESTO QUE UN JUGADOR NO CAMBIA DE Nº CALZADO, POSICION, NI DORSAL DURANTE LA LIGA
      POR LO QUE VAMOS A OMITIR LOS SETTERS DE ESTOS ATRIBUTOS*/
    
    public int getT_amarillas() {
        return t_amarillas;
    }

    public void setT_amarillas(int t_amarillas) {
        this.t_amarillas = t_amarillas;
    }

    public int getT_rojas() {
        return t_rojas;
    }

    public void setT_rojas(int t_rojas) {
        this.t_rojas = t_rojas;
    }
    
    /*----Método para actualizar las tarjetas de un jugador*/
    protected void calculaTarjeta(int namarilla,int nroja){
        /*nt amarillaAnt=this.getT_amarillas();
        int amarillaAct=amarillaAnt+namarilla;
        this.setT_amarillas(amarillaAct);????*/
        this.setT_amarillas(this.getT_amarillas()+namarilla);//Actualiza el numero de amarillas
        
       this.setT_rojas(this.getT_rojas()+nroja); //Actualiza el numero de rojas
    }
    
}
