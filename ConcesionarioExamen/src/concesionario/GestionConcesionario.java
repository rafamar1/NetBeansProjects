/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

import java.util.*;
import utilidades67.ES.ES;

/**
 *
 * @author RafaMar
 */
public class GestionConcesionario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Concesionario concesionario = new Concesionario();
        cargarDatosdeFichero(concesionario);

        int opcion, opcion2;
        do {
            pintaMenu(generaListMenuPrincipal());

            opcion = ES.leeN("Introduzca una opcion: ");

            switch (opcion) {

                case 1:
                    concesionario.altaNuevoCliente();
                    break;

                case 2:
                    concesionario.altaNuevoVehiculo();
                    break;

                case 3:
                    concesionario.matricularNuevoVehiculo();
                    break;

                case 4:
                    pintaMenu(generaListMenuListados());
                    do {
                        opcion2 = ES.leeN("Introduzca una opcion: ");
                        switch (opcion2) {
                            case 1:
                                concesionario.listadoClientes();
                                break;
                            case 2:
                                concesionario.listadoVehiculos();
                                break;
                            case 3:
                                concesionario.listadoVehiculosMatriculados();
                                break;
                            case 4:
                                break;
                        }

                    } while (opcion2 != 4);

                    break;

                case 5:
                    break;

                default:

                    break;
            }

        } while (opcion != 10);
    }

    private static void cargarDatosdeFichero(Concesionario concesionario) {
        concesionario.cargaDatosClientesFichero("src/datos/clientes.txt");
        concesionario.cargarDatosCochesFichero("src/datos/coches.txt");
    }

    private static void pintaMenu(ArrayList<String> menu) {
        int i = 1;
        for (String posicion : menu) {
            System.out.println(i + ".- " + posicion);
            i++;
        }
    }

    private static ArrayList<String> generaListMenuPrincipal() {
        ArrayList<String> menuPrincipal = new ArrayList();
        menuPrincipal.add("Dar de Alta un nuevo Cliente");
        menuPrincipal.add("Dar de Alta un nuevo Vehículo");
        menuPrincipal.add("Matricular un Vehículo");
        menuPrincipal.add("Listados");
        menuPrincipal.add("Salir");

        return menuPrincipal;
    }

    private static ArrayList<String> generaListMenuListados() {
        ArrayList<String> menuListados = new ArrayList();
        menuListados.add("Listar Clientes");
        menuListados.add("Listar Vehículos");
        menuListados.add("Listar Vehículos Matriculados");
        menuListados.add("Volver al Menú Principal");

        return menuListados;
    }

}
