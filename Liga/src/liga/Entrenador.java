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
public class Entrenador extends Persona {
    

    //-------ATRIBUTOS MIEMBRO-----//
    private int numVict;
    private int numEmp;
    private int numDer;
    
    
    //------METODOS MIEMBRO----//
    
    /*------Constructores------*/

    public Entrenador(int numVict, int numEmp, int numDer) {
        this.numVict = numVict;
        this.numEmp = numEmp;
        this.numDer = numDer;
    }
    
    public Entrenador(int numVict, int numEmp, int numDer, String nombre, String apellidos, String dni, int edad, String sexo, String localidad) {
        super(nombre, apellidos, dni, edad, sexo, localidad);
        this.numVict = numVict;
        this.numEmp = numEmp;
        this.numDer = numDer;
    }
    
     
    //------Métodos miembro-----//

    public int getNumVict() {
        return numVict;
    }

    public void setNumVict(int numVict) {
        this.numVict = numVict;
    }

    public int getNumEmp() {
        return numEmp;
    }

    public void setNumEmp(int numEmp) {
        this.numEmp = numEmp;
    }

    public int getNumDer() {
        return numDer;
    }

    public void setNumDer(int numDer) {
        this.numDer = numDer;
    }
    
    
    
    /*----Método para actualizar los resultados de un entrenador-----*/
    /*Dependiendo del entero introducido el resultado será:
            - Si 0-->Derrota
            - Si 1-->Empate
            - Si 3-->Victoria                   */
    
    protected void calculaResultado(int resultado){
        
        switch (resultado) {
            case 0:
                this.setNumDer(this.getNumDer()+1);
                break;
            case 1:
                this.setNumEmp(this.getNumEmp()+1);
                break;  
            case 3:
                this.setNumVict(this.getNumVict()+1);
                break;
            default:
                System.out.println("No se ha introducido un numero correcto!");
                break;
        }
            
    }
}
