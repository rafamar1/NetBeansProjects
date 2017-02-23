
package liga;

/**
 *
 * @author RafaMar
 */
public class Persona {
// Atributos miembros de la clase
   protected String nombre,apellidos;
   protected String dni;
   protected int edad;
   protected String sexo;
   protected String localidad;
   static int miembro=0;
   
// Métodos miembros de la clase...........  
   //Constructores------------------------
   
   public Persona(){
      miembro++;
      nombre= String.valueOf(miembro) +"->"+ super.toString();
       
   }
   //----------------------------------------------
   public Persona(String nombre, String apellidos){
       this.nombre   =nombre;
       this.apellidos=apellidos;
       miembro++;
   }
   
   public Persona(String nombre, String apellidos, String dni){
       this(nombre, apellidos);
       this.dni      =dni; 
       miembro++;
       
   }

    public Persona(String nombre, String apellidos, String dni, int edad, String sexo, String localidad) {
        this(nombre, apellidos,dni);
        this.edad = edad;
        this.sexo = sexo;
        this.localidad = localidad;
        miembro++;
    }
   
   
   //--------Métodos para leer y escribir los atributos---------//

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.substring(0,1).toUpperCase() + 
                      nombre.substring(1);
    }
    
    public String leerNombre(){
     return nombre;  
   }
    
   public void cambiarNombre(String nombre){
       this.nombre=nombre;
            
   } 

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", edad=" + edad + ", sexo=" + sexo + ", localidad=" + localidad + '}';
    }

   

}
