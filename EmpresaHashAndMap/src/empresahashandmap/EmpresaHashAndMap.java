package empresahashandmap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import utilidades67.ES.ES;

public class EmpresaHashAndMap {

    static Empresa empresa;

    public static void main(String[] args) {
        empresa = new Empresa("98754", "Mercadroga", "Ronda");
        Cliente cliente = new Cliente("Francisco", "Marquez", "15598196");
        empresa.getListaNifClientes().put(cliente.getNif(), cliente);
        empresa.getListaNombreClientes().put(concatenacionApellidoCliente(cliente), cliente.getNif());
        cliente = new Cliente("Francisco2", "Marquez2", "25598196R");
        empresa.getListaNifClientes().put(cliente.getNif(), cliente);
        empresa.getListaNombreClientes().put(concatenacionApellidoCliente(cliente), cliente.getNif());
        gestionarMenu();

    }

    private static void gestionarMenu() {
        int numero;
        do {
            listarMenu();
            numero = pideNumero();
            switch (numero) {
                case 1:
                    añadirCliente();
                    break;
                case 2:
                    borrarCliente();
                    break;
                case 3:
                    modificarCliente();
                    break;
                case 4:
                    listarCliente();
                    break;
                case 5:
                    listarCliente();
                    String nif = ES.leeDeTeclado("Introduce el nif: ");
                    System.out.println(empresa.getListaNifClientes().get(nif));
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción incorrecta");
                    break;

            }
        } while (numero != 6);
    }

    private static void listarMenu() {
        System.out.println("1.- Añadir Cliente.");
        System.out.println("2.- Borrar Cliente.");
        System.out.println("3.- Modificar Cliente.");
        System.out.println("4.- Listar Clientes.");
        System.out.println("5.- Busca Cliente.");
        System.out.println("6.- Salir.");
    }

    private static int pideNumero() {
        return ES.leeN("Introduce la opción: ");
    }

    private static void añadirCliente() {
        Cliente cliente = new Cliente(pideNombre(), pideApellidos(), pideNif());
        empresa.getListaNifClientes().put(cliente.getNif(), cliente);
        empresa.getListaNombreClientes().put(concatenacionApellidoCliente(cliente), cliente.getNif());
    }

    private static void borrarCliente() {
        if (!empresa.getListaNombreClientes().isEmpty()) {
            listarCliente();
            String nif;
            do {
                nif = pideNif();
            } while (!empresa.getListaNifClientes().containsKey(nif));
            Cliente cliente = (Cliente) empresa.getListaNifClientes().get(nif);
            empresa.getListaNifClientes().remove(nif);
            empresa.getListaNombreClientes().remove(concatenacionApellidoCliente(cliente));
        }
    }

    private static void modificarCliente() {
        if (!empresa.getListaNombreClientes().isEmpty()) {
            listarCliente();
            String nif;
            do {
                nif = pideNif();
            } while (!empresa.getListaNifClientes().containsKey(nif));
            gestionarModificacion(nif);
        }
    }

    private static void listarCliente() {
        System.out.println(empresa.getListaNombreClientes()); // Lista Tree
        /*Set<String> conjuntoNif = empresa.getListaNombreClientes().keySet();
        Iterator iteratorNif = conjuntoNif.iterator();
        while(iteratorNif.hasNext()){
            String clave = (String)iteratorNif.next();
            String nif = (String)empresa.getListaNombreClientes().get(clave);
            System.out.println(empresa.getListaNifClientes().get(nif));
        }
        Collection valores = empresa.getListaNombreClientes().values();
        for (Object nif : valores) {
            Cliente cli = (Cliente)empresa.getListaNifClientes().get(nif);
            System.out.println("\n"+cli);
        }
        Set<Cliente> conjunto = empresa.getListaNifClientes().keySet();
        Iterator iterator = conjunto.iterator();
        int i = 1;
        while (iterator.hasNext()) {
            Cliente cliente = (Cliente)empresa.getListaNifClientes().get(iterator.next());
            System.out.println("\t" + i + ".- " + cliente.toString());
            i++;
        }*/
    }

    private static String pideNombre() {
        return ES.leeDeTeclado("Introduce el Nombre: ");
    }

    private static String pideApellidos() {
        return ES.leeDeTeclado("Introduce el Apellido: ");
    }

    private static String pideNif() {
        return ES.leeDeTeclado("Introduce el NIF: ");
    }

    private static void listarModificacion() {
        System.out.println("1.- Cambiar Nombre.");
        System.out.println("2.- Cambiar Apellido.");
        System.out.println("3.- Salir.");
    }

    private static void gestionarModificacion(String nif) {
        int numero;
        do{
        listarModificacion();
        numero = pideNumero();
        Cliente cliente;
        switch(numero){
            case 1:
                cliente = (Cliente)empresa.getListaNifClientes().get(nif);
                empresa.getListaNombreClientes().remove(concatenacionApellidoCliente(cliente));
                cliente.setNombre(ES.leeDeTeclado("\nIntroduce el nuevo nombre: "));
                empresa.getListaNombreClientes().put(concatenacionApellidoCliente(cliente), cliente.getNif());
                break;
            case 2:
                cliente = (Cliente)empresa.getListaNifClientes().get(nif);
                empresa.getListaNombreClientes().remove(concatenacionApellidoCliente(cliente));
                cliente.setApellido(ES.leeDeTeclado("\nIntroduce el nuevo apellido: "));
                empresa.getListaNombreClientes().put(concatenacionApellidoCliente(cliente), cliente.getNif());
                break;
            case 3:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Entrada Incorrecta");
                break;
            
        }
        }while(numero!=3);
        
    }

    private static String concatenacionApellidoCliente(Cliente cliente) {
        return cliente.getApellido() + ", " + cliente.getNombre();
    }
}
