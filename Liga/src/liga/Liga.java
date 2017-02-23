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
public class Liga {

    static Persona[] listaMiembros= new Persona[30]; 
    //Supongamos un equipo de 30 miembros(jugadores+entrenador+presidente)//
    static Equipo[] listaEquipos= new Equipo[15];
    //Suponemos una Liga con 15 equipos//
    
    public static void main(String[] args) {
      
        int opcion;
        do{
            System.out.println("1.- Crear Equipo");
            System.out.println("2.- Contratar Jugador");
            System.out.println("3.- Contratar Entrenador");
            System.out.println("4.- Listar Plantilla de un equipo");
            System.out.println("5.- SALIR");
	
            opcion=ES.leeN("Introduzca opcion: ");
		switch(opcion){
			
		case 1:
                        String nomEquipo= ES.leeDeTeclado("Introduzca el nombre del Equipo: ");
                        String nomEstadio= ES.leeDeTeclado("Introduzca el nombre del Estadio: ");
                        String localidad = ES.leeDeTeclado("Introduzca una localidad: "); 
                        Equipo equipo = new Equipo(nomEquipo,nomEstadio,localidad);
                        System.out.println("Dar de alta al presidente del Equipo: \n");
                        altaMiembro('p');
                        //Buscamos una posición libre en la Liga//
                        int i= buscaPosicionLibre(listaEquipos);
                        
                        if ( i!=-1)
                            listaEquipos[i]=equipo;
                        else System.out.println("La Liga está completa!");
                        break;
		case 2: 
                    System.out.println("¿Que jugador desea dar de alta?\n"
                            + "1)Jugador Normal\n"
                            + "2)Capitán del Equipo\n");
                    int opcionjug=ES.leeN("Introduzca la opción deseada: ");
                    
                    if(opcionjug==1){
                        altaMiembro('j');
                    }else if (opcionjug==2){
                        altaMiembro('c');
                    }
                    break;
                    
                case 3:
                    altaMiembro('e');
                    break;
                    
                case 4:
                       System.out.println("Listado de Equipos");
                       i=0;
                       while (i <listaEquipos.length && listaEquipos[i]!=null) {
                            System.out.println(listaEquipos[i].toString());
                            i++;
                        }break;
                        
                case 5: break;         
                default:System.out.println("Opcion Errónea...");        
		}
       
        }while(opcion != 5);
    }
    //Debe ser static porque la llamamos desde el main que es static
    //sino, no funcionaria
    static void altaMiembro(char tipo){
        Jugador jugador;
        Jugador capitan;
        Persona presidente;
        Entrenador entrenador;
        
        //----------LISTA EQUIPOS------//
            System.out.println("Listado de Equipos de la LIGA");
        int i=0;
        while (i <listaEquipos.length && listaEquipos[i]!=null) {
            System.out.println("\t"+(i+1)+"-"+listaEquipos[i].getNomEquipo());
            i++;
        }
        int nequipo=ES.leeN("Introduzca el equipo deseado");
            
        //----Recogida de Datos comunes----//
        String dni=ES.leeDeTeclado("Introduzca el DNI del miembro de la plantilla: ");
                    String nombre=ES.leeDeTeclado("Introduzca su  Nombre: ");
                    String apellidos=ES.leeDeTeclado("Introduzca sus Apellidos: ");
                    int edad=ES.leeN("Introduzca la edad del miembro de la plantilla: ");
                    String sexo=ES.leeDeTeclado("Introduzca su sexo: ");
                    String localidad=ES.leeDeTeclado("Introduzca su localidad: ");
                    
        switch (tipo) {
            case 'j':                
            case 'c':
                {
                    //Recoge Datos para el capitán(es tambien un Jugador)//
                    int n_calzado=ES.leeN("Introduzca el numero de calzado del jugador: ");
                    int dorsal=ES.leeN("Introduzca el dorsal del Jugador: ");
                    String posicion=ES.leeDeTeclado("Introduzca la posición del Jugador: ");
                    
                    if (tipo == 'j'){
                    jugador=new Jugador(n_calzado,posicion,dorsal,0, 0,nombre,apellidos,dni,edad,sexo,localidad);
                    listaEquipos[nequipo-1].altaJugador(jugador);
                    break;}
                    else if (tipo == 'c'){
                    capitan=new Jugador(n_calzado,posicion,dorsal,0, 0,nombre,apellidos,dni,edad,sexo,localidad);
                    listaEquipos[nequipo-1].altaCapitan(capitan);
                    break;
                    }
                }
            case 'e':
                {
                    //Recoge Datos para el entrenador//
                    int numVict=ES.leeN("Introduzca el numero de Victorias: ");
                    int numEmp=ES.leeN("Introduzca el dorsal de Empates: ");
                    int numDer=ES.leeN("Introduzca el dorsal de Derrotas: ");
                    
                    entrenador=new Entrenador( numVict, numEmp,  numDer,nombre,apellidos, dni,edad, sexo, localidad);
                    listaEquipos[nequipo-1].altaEntrenador(entrenador);
                    break;
                }
            case 'p':
                {
                    presidente = new Persona( nombre, apellidos, dni);
                    listaEquipos[nequipo-1].altaPresi(presidente);
                    break;
                }
            default:
                break;
        }
        
    }
    
    static int buscaPosicionLibre(Object [] vector){
    
        int i=0;
        while(vector[i]!=null && i<vector.length){
            i++;
        }
        if (i==vector.length){
            return -1;
        }else
            return i;
        
    }
    
}

  
    

