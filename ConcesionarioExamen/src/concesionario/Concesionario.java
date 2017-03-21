/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

import java.io.*;
import java.util.*;
import utilidades67.ES.ES;
import utilidades67.personas.Persona;

/**
 *
 * @author RafaMar
 */
public class Concesionario {

    private HashMap<String, Cliente> listaClientes = new HashMap<>();

    private HashMap<String, Coche> listaCoches = new HashMap<>();

    public void cargaDatosClientesFichero(String rutaFichero) {

        try {
            BufferedReader bufferedEntrada = new BufferedReader(new FileReader(rutaFichero));
            String linea;
            while ((linea = bufferedEntrada.readLine()) != null) {
                String[] datosCliente = linea.split(",");
                Cliente cliente = new Cliente(Integer.parseInt(datosCliente[0]), datosCliente[1], datosCliente[2], datosCliente[3]);
                listaClientes.put(cliente.getNombre(), cliente);
            }
            bufferedEntrada.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado en la ruta " + rutaFichero);
        } catch (IOException ex) {
            System.out.println("Error de E/S");
        }

    }

    public void cargarDatosCochesFichero(String rutaFichero) {

        try {
            BufferedReader bufferedEntrada = new BufferedReader(new FileReader(rutaFichero));
            String linea = "";
            while ((linea = bufferedEntrada.readLine()) != null) {
                String[] datosCoche = linea.split(",");

                Coche coche = new Coche(datosCoche[0], datosCoche[1], Integer.parseInt(datosCoche[2]), datosCoche[3]);
                listaCoches.put(coche.getNumeroBastidor(), coche);

            }
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado en la ruta " + rutaFichero);
        } catch (IOException ex) {
            System.out.println("Error de E/S");
        }
    }

    public void altaNuevoCliente() {
        Cliente cliente = new Cliente(generaCodigoClienteValido(), pideNombre(), pideApellidos(), pideNIF());
        listaClientes.put(cliente.getNombre(), cliente);
    }

    public void altaNuevoVehiculo() {
        Coche coche = new Coche(pideMarcaCoche(), pideColorCoche(), pideNumeroKilometros(), pideNumeroBastidor());
        listaCoches.put(coche.getNumeroBastidor(), coche);
    }

    @Override
    public String toString() {
        return "Concesionario" + "listaClientes=" + listaClientes
                + "\nlistaCoches= " + listaCoches;
    }

    /*-----DATOS-----*/
    public String pideNombre() {
        return ES.leeDeTeclado("Introduzca el Nombre del Cliente");
    }

    public String pideApellidos() {
        return ES.leeDeTeclado("Introduzca los Apellidos del Cliente: ");
    }

    public String pideNIF() {
        return ES.leeDeTeclado("Introduzca el NIF del Cliente: ");
    }

    public String pideNumeroBastidor() {
        return ES.leeDeTeclado("Introduzca el Nº de Bastidor del Coche: ");
    }

    public String pideMarcaCoche() {
        return ES.leeDeTeclado("Introduzca la Marca del Coche: ");
    }

    public String pideColorCoche() {
        return ES.leeDeTeclado("Introduzca el Color del Coche: ");
    }

    public String pideMatricula() {
        return ES.leeDeTeclado("Introduzca la Matricula del Coche: ");
    }

    public String pideFechaMatriculacion() {
        return ES.leeDeTeclado("Introduzca la Fecha de Matriculacion (Formato dd/mm/yyyy): ");
    }

    public int pideNumeroKilometros() {
        return ES.leeN("Introduzca el Nº de Kilometros del Coche: ");
    }

    private String pideCliente() {
        listarClientes();
        return ES.leeDeTeclado("Introduzca el Nombre del Cliente");
    }

    private String pideCoche() {
        listarCoches();
        return ES.leeDeTeclado("Introduzca el Nº de Bastidor del Coche");
    }

    /**
     * ***-------*****
     */
    private int generaCodigoClienteValido() {
        int codigoClienteValido = (int) (Math.random() * (500) + 1);

        Set<String> nombresClientes = listaClientes.keySet();

        ArrayList<Integer> listaCodigos = new ArrayList();

        for (String nombreCliente : nombresClientes) {
            listaCodigos.add(listaClientes.get(nombreCliente).getCodigoCliente());
        }

        while (listaCodigos.contains(codigoClienteValido)) {
            codigoClienteValido = (int) (Math.random() * (500) + 1);
        }

        return codigoClienteValido;

    }

    public void matricularNuevoVehiculo() {
        String nombreCliente = pideCliente();
        String numeroBastidor = pideCoche();
        String fechaMatriculacion = pideFechaMatriculacion();

        Matriculacion matriculacion = new Matriculacion(compruebaMatricula(pideMatricula()), numeroBastidor, listaClientes.get(nombreCliente).getNif(), fechaMatriculacion);
        listaClientes.get(nombreCliente).getListaMatriculaciones().add(matriculacion);
    }

    private void listarClientes() {
        System.out.println("\n***Listado de Clientes***");
        int i = 1;

        Set<String> nombresClientes = listaClientes.keySet();
        for (String nombreCliente : nombresClientes) {
            Cliente cliente = listaClientes.get(nombreCliente);
            System.out.println("\t" + (i) + "- Nombre " + cliente.getNombre() + "; NIF -" + cliente.getNif());
            i++;
        }
    }

    private void listarCoches() {
        System.out.println("\n***Listado de Coches Disponibles***");
        int i = 1;

        Set<String> numerosBastidorCoche = listaCoches.keySet();
        for (String numeroBastidor : numerosBastidorCoche) {
            Coche coche = listaCoches.get(numeroBastidor);
            System.out.println("\t" + (i) + "- Numero de Bastidor " + coche.getNumeroBastidor() + "; Marca -" + coche.getMarca());
            i++;
        }
    }

    private String compruebaMatricula(String matricula) {

        while (!(matricula.matches("[0-4]{8}[a-zA-Z]{3}"))) {
            matricula = ES.leeDeTeclado("Formato de Matricula Incorrecto!\n "
                    + "Recuerde el FORMATO [NNNN-LLL] Vuelva a introducir la matricula: ");
        }
        return matricula;
    }

    /*METODOS PARA LISTAR*/
    void listadoClientes() {
        System.out.println("***---Clientes del Concesionario---***");
        
        Iterator<Cliente> iteratorClientes = listaClientes.values().iterator();
        while (iteratorClientes.hasNext()) {
            System.out.println(iteratorClientes.next());
        }
    }

    void listadoVehiculos() {
        System.out.println("***---Vehiculos del Concesionario---***");
        
        Iterator<Coche> iteratorCoches = listaCoches.values().iterator();
        while (iteratorCoches.hasNext()) {
            System.out.println(iteratorCoches.next());//Redefinir el toString() de Coche!!
        }
    }

    void listadoVehiculosMatriculados() {
        System.out.println("***---Vehiculos Matriculados---***");
        
        Iterator<Cliente> iteratorClientes = listaClientes.values().iterator();
        while (iteratorClientes.hasNext()) {
            iteratorClientes.next().getListaMatriculaciones().toString();
        }
    
    }

}
