/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

import alumnos.CiclosError;
import java.util.ArrayList;
import utilidades67.ES.ES;

/**
 *
 * @author RafaMar
 */
public class GestionAlumnos {

    /**
     * @param args the command line arguments
     */
    static ArrayList<CicloFormativo> listaCiclos = new ArrayList();

    public static void main(String[] args) throws CiclosError {

        int opcion;

        do {
            menu();

            opcion = ES.leeN("\nIntroduzca una opcion: ");

            switch (opcion) {

                case 1:
                    creacionDeCiclo();
                    break;

                case 2:
                    altaAlumno();
                    break;

                case 3:
                    listadoDeCiclo();
                    break;

                case 4:
                    break;

                default:
                    System.out.println("¡¡Opcion NO Válida!!");
                    break;
            }

        } while (opcion != 4);
    }

                            /***--CREACION & ALTAS--***/
    private static void altaAlumno() throws CiclosError {
        CicloFormativo cicloFormativo = obtenerCiclo();
        if(cicloFormativo.compruebaMaximo()){
           Alumno alumno = new Alumno(pideNombre(), pideApellidos(), pideNif(), pideNIE(), pideBeca(), pideCentro());
           cicloFormativo.matriculaAlumno(alumno); 
        }else
            System.out.println("El Ciclo Formativo tiene el maximo de alumnos");
        
    }

    private static CicloFormativo obtenerCiclo() {
        CicloFormativo ciclo = null;
        listaNombreCiclos();
        int numeroCiclo;

        /*Controlamos el error por si metemos un numero que no este dentro de la lista*/
        do {
            numeroCiclo = pideNoCiclo();
            try {
                ciclo = (CicloFormativo) listaCiclos.get(numeroCiclo - 1);
            } catch (IndexOutOfBoundsException error) {
                System.out.println("¡Numero de Ciclo no Válido!");
            }

        } while (ciclo == null);
        return ciclo;
    }
    
        private static void creacionDeCiclo() {
        int opcionCiclo;
                    do {
                        menuCiclo();
                        opcionCiclo = ES.leeN("Introduzca una opcion: ");
                        switch (opcionCiclo) {
                            case 1:
                                listaCiclos.add(new CicloFormativo(pideNombreCiclo(), pideNAños(), pideMaxAlumnos()));
                                break;

                            case 2:
                                listaCiclos.add(new CicloFormativo(pideNombreCiclo(), pideNAños(), pideMaxAlumnos(), introduceModulos()));
                                break;

                            case 3:
                                break;

                            default:
                                System.out.println("¡¡Opcion NO Válida!!");
                                break;
                        }

                    } while (opcionCiclo != 3);

    }

    private static void listadoDeCiclo() {
        int opcionListado;
                    do {
                        menuListado();
                        opcionListado = ES.leeN("Introduzca una opcion: ");
                        switch (opcionListado) {
                            case 1:
                                listarCiclo();
                                break;

                            case 2:
                                CicloFormativo cicloFormativo = obtenerCiclo();
                                System.out.println(cicloFormativo.listadoCiclo());
                                break;

                            case 3:
                                break;

                            default:
                                System.out.println("¡¡Opcion NO Válida!!");
                                break;
                        }

                    } while (opcionListado != 3);

    }


                                /***--MENUS--***/
    private static void menu() {
        System.out.println("\t\t/**-- GESTIÓN DE CICLOS & ALUMNOS --**\\");
        System.out.println("\n1.- Dar de Alta un Nuevo Ciclo");
        System.out.println("2.- Matricular un Alumno");
        System.out.println("3.- Listar Ciclo");
        System.out.println("4.- Salir");
    }

    private static void menuCiclo() {
        System.out.println("\t\t/**-- MENÚ CICLO --**\\");
        System.out.println("\n1.- Ciclo nuevo");
        System.out.println("2.- Ciclo nuevo, introduciendo los Módulos que lo componen ");
        System.out.println("3.- Salir");
    }
    
    private static void menuListado() {
        System.out.println("\t\t/**-- MENÚ LISTADO --**\\");
        System.out.println("\n1.- Listado de los Alumnos del Ciclo");
        System.out.println("2.- Listado de las Características del ciclo ");
        System.out.println("3.- Salir");
    }

                            /*METODOS PARA LISTAR*/
    private static void listaNombreCiclos() {
        System.out.println("\n\t\t***Lista de Ciclos***");
        int i = 0;
        for (CicloFormativo ciclo : listaCiclos) {
            System.out.println("\t" + (i + 1) + "-" + ciclo.getNombreCiclo());
            i++;
        }
    }

    private static void listarCiclo() {
        CicloFormativo cicloFormativo = obtenerCiclo();
        ArrayList listaAlumnos = cicloFormativo.getListaAlumnos();
        System.out.println("\nCiclo: " + cicloFormativo.getNombreCiclo() + ", "
                + listaAlumnos.size() + " alumnos matriculados");
        System.out.println("\tListado de Alumnos:");

        for (int i = 0; i < listaAlumnos.size(); i++) {
            System.out.println("\t\t" + (i + 1) + ".-" + cicloFormativo.listarAlumnos());
        }

    }

                        /***-METODOS PARA PEDIR DATOS--***/
    private static String pideNombreCiclo() {
        return ES.leeDeTeclado("Introduzca el Nombre del Ciclo: ");
    }

    private static int pideNAños() {
        return ES.leeN("Introduzca el Numero de Años que durara el Ciclo: ");
    }

    private static int pideMaxAlumnos() {
        return ES.leeN("Introduzca el Numero Máximo de Alumnos: ");
    }

    private static String pideNombre() {
        return ES.leeDeTeclado("Introduzca el Nombre: ");
    }

    private static String pideApellidos() {
        return ES.leeDeTeclado("Introduzca los Apellidos: ");
    }

    private static String pideNif() {
        return ES.leeDeTeclado("Introduzca el NIF: ");
    }

    private static int pideNoCiclo() {
        return ES.leeN("Seleccione el Nº del Ciclo Formativo: ");
    }

    private static int pideNIE() {
        return ES.leeN("Introduzca el NIE: ");
    }

    private static boolean pideBeca() {
        String beca = ES.leeDeTeclado("Introduzca si el alumno dispone de beca(s/n): ");

        return beca.equalsIgnoreCase("s");
    }

    private static String pideCentro() {
        return ES.leeDeTeclado("Introduzca el Centro de Procedencia: ");
    }

    private static ArrayList<String> introduceModulos() {
        ArrayList<String> modulos = new ArrayList();
        int numModulos = ES.leeN("Introduzca el numero de modulos: ");
        String nombre="";
        
        for (int i = 0; i < numModulos; i++) {
            nombre = ES.leeDeTeclado("Introduzca el nombre del Modulo: ");
            modulos.add(nombre);
        }
        return modulos;
    }


}
