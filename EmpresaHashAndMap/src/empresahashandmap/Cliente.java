
package empresahashandmap;

import java.util.Objects;
import utilidades67.personas.Persona;


class Cliente {

    private String nif;
    private String nombre;
    private String apellido;
    private String correo;
    
    public Cliente(String nombre, String apellido, String nif){
        this.nombre = nombre;
        this.apellido = apellido;
        this.nif = nif;
        correo = "nada";
    }
        
    
    
    public String getNif(){
        return nif;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getApellido(){
        return apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nif);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.nif, other.nif)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nif=" + nif + ", nombre=" + nombre + ", apellido=" + apellido + " "+correo+'}';
    }
    
    
}
