package utilidades67.personas;


import utilidades67.es.ES;
import java.util.Objects;


/**
 *
 * @author profesor
 */
public class Persona implements Comparable{
    
    //Atributos miembro de la clase
   protected String  nombre,apellidos;
   private   String  nif;
             int     edad,telefono;
   static    int     censo    = 0;
    
    
    //Métodos miembro de la clase-----------------------

    // Métodos Constructores------------------------------
    
    public Persona(String nombre, String nif) {
        this.nombre = nombre;
        this.nif = compruebaNif(nif);
        apellidos="no tiene apellidos";
        censo++;
    }

    public Persona(String nombre, String nif, String apellidos,  int edad, int telefono) {
       // this.nombre = nombre;
       // this.nif = nif;
        this(nombre,nif);
        this.apellidos = apellidos;
        this.edad = edad;
        this.telefono = telefono;
       
    }

    public Persona(String nombre, String apellidos, String nif) {
        this(nombre,nif);
        this.apellidos = apellidos;
    }
    
    // Getters & Setters------------------------------------
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = compruebaNif(nif);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    //------Descripcion de una Persona -------

    @Override
    public String toString() {
       //super.toString()+"\n"+
        return  "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos +", nif=" + nif + ", edad=" + edad + ", telefono=" + telefono + '}';
    }
    
    //-----------------

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nif);
        return hash;
    }
    //------------------------------------
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        //if (!Objects.equals(this.nif, other.nif)) {
        if(this.nif.equals(other.nif))
            return true;
        
        return false;
    }
    //---------------------------------------
    private String compruebaNif(String nif) {
        
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        
        while( !(nif.matches("[0-9]{8}")) && !(nif.matches("[0-9]{8}[a-zA-Z]")) ) {
            nif = ES.leeDeTeclado("Formato de Nif incorrecto, repita el nif: "); 
           }
        if ( nif.matches("[0-9]{8}") ) {
            int  numero= Integer.parseInt(nif);
            return nif + letras.charAt(numero%23);
        }
        else  {
                int  numero= Integer.parseInt(nif.substring(0,8));
                if ( nif.charAt(8) != letras.charAt(numero%23) ){
                      System.out.println("Letra del nif incorrecta...se recalculara ");
                      return nif.substring(0,8) + letras.charAt(numero%23);
                  }
               else return nif; 
            }
              
    }

    @Override
    public int compareTo(Object objeto) {
        
       Persona per2=(Persona)objeto;
       
       int compara=this.apellidos.compareTo(per2.apellidos);
       
     if(compara==0)
        return  
            this.nombre.compareTo(per2.nombre);
     else return compara;
        
    }
    
    
    
    
    
    
    
    
    
    
    
}
