/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import java.util.Collection;
import java.util.Set;
import utilidades67.ES.ES;

/**
 *
 * @author RafaMar
 */
public class GestionClientes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empresa miEmpresa = new Empresa("11111");

        Cliente per1 = new Cliente("pepeL@correo.es", "Pepe", "Lopez", "12345542Q");
        Cliente per2 = new Cliente("pepeR@correo.es", "Pepe", "Ramirez", "11111113C");
        Cliente per3 = new Cliente("joseM@correo.es", "Jose", "Martinez", "12345678Z");
        Cliente per4 = new Cliente("Luisa@correo.es", "Luisa", "Alvarez", "11111114K");

        miEmpresa.getClientesNIF().put(per1.getNif(), per1);
        miEmpresa.getClientesNIF().put(per2.getNif(), per2);
        miEmpresa.getClientesNIF().put(per3.getNif(), per3);
        miEmpresa.getClientesNIF().put(per4.getNif(), per4);

        miEmpresa.getClientesOrdenados().put(per1.getApellidos() + ", " + per1.getNombre(), per1.getNif());
        miEmpresa.getClientesOrdenados().put(per2.getApellidos() + ", " + per2.getNombre(), per2.getNif());
        miEmpresa.getClientesOrdenados().put(per3.getApellidos() + ", " + per3.getNombre(), per3.getNif());
        miEmpresa.getClientesOrdenados().put(per4.getApellidos() + ", " + per4.getNombre(), per4.getNif());

        //---menu
        int opcion = 0;
        do {

            //menú principal
            System.out.println("1.- Listar Clientes");
            System.out.println("2.- Buscar Cliente por Nif");
            System.out.println("3.- alta Cliente");
            System.out.println("4.- Borrar Cliente");
            System.out.println("5.- Modificar Cliente");
            System.out.println("6.- Salir");

            opcion = ES.leeN("Introduzca opcion: ");

            switch (opcion) {
                case 1:
                    System.out.println("Listado de Clientes Ordenados");
                    Collection valores = miEmpresa.getClientesOrdenados().values();
                    int i = 1;
                    for (Object nif : valores) {
                        Cliente cli = miEmpresa.getClientesNIF().get(nif);
                        System.out.println(i + "->" + cli);
                        i++;
                    }
                    break;

                case 2:
                    System.out.println(miEmpresa.getClientesOrdenados());
                    System.out.println(miEmpresa.getClientesNIF().get(pideNIF()));
                    break;

                case 3:
                    String correo = ES.leeDeTeclado("Introduzca el e-mail del Cliente: ");
                    String nombre = ES.leeDeTeclado("Introduzca el nombre del Cliente: ");
                    String apellido = ES.leeDeTeclado("Introduzca el apellido del Cliente: ");

                    Cliente cliente = new Cliente(correo, nombre, apellido, pideNIF());
                    miEmpresa.getClientesNIF().put(cliente.getNif(), cliente);
                    miEmpresa.getClientesOrdenados().put(cliente.getApellidos() + ", "
                            + cliente.getNombre(), cliente.getNif());
                    break;

                case 4:
                    System.out.println(miEmpresa.getClientesOrdenados());
                    String DNI = pideNIF();
                    borrarCliente(miEmpresa, DNI);
                    break;

                case 5:
                    System.out.println("Indique que cliente desea modificar: ");
                    System.out.println(miEmpresa.getClientesOrdenados());
                    String clave = pideNIF();

                    System.out.println("1.- Cambiar Nombre");
                    System.out.println("2.- Cambiar Apellidos");
                    System.out.println("3.- Cambiar NIF");
                    System.out.println("4.- Cambiar e-Mail");
                    System.out.println("5.- Salir");

                    int opc = ES.leeN("Seleccione una opcion opcion: ");
                    Cliente clienteModificado;

                    switch (opc) {

                        case 1:
                            String nombreActual = miEmpresa.getClientesNIF().get(clave).getNombre();
                            String apellidoActual = miEmpresa.getClientesNIF().get(clave).getApellidos();

                            System.out.println("Nombre Actual: " + nombreActual);
                            String nombreNuevo = ES.leeDeTeclado("Introduzca un nuevo nombre: ");

                            miEmpresa.getClientesNIF().get(clave).setNombre(nombreNuevo);
                            clienteModificado = miEmpresa.getClientesNIF().get(clave);
                            /*Creamos un cliente con los nuevos datos*/

                            miEmpresa.getClientesNIF().replace(clave, clienteModificado);
                            /*MODIFICO EL HASH*/

                            miEmpresa.getClientesOrdenados().remove(apellidoActual + ", " + nombreActual);
                            /*BORRO EL TREE ACTUAL*/

                            miEmpresa.getClientesOrdenados().put(clienteModificado.getApellidos() /*CREO UN TREE CON EL NUEVO NOMBRE Y EL MISMO NIF*/
                                    + ", " + clienteModificado.getNombre(), clave);
                            break;

                        case 2:
                            String nombreAct = miEmpresa.getClientesNIF().get(clave).getNombre();
                            String apellidoAct = miEmpresa.getClientesNIF().get(clave).getApellidos();

                            System.out.println("Apellido Actual: " + apellidoAct);
                            String apellidoNuevo = ES.leeDeTeclado("Introduzca un nuevo Apellido: ");

                            miEmpresa.getClientesNIF().get(clave).setApellidos(apellidoNuevo);
                            clienteModificado = miEmpresa.getClientesNIF().get(clave);/*Creamos un cliente con los nuevos datos*/

                            miEmpresa.getClientesNIF().replace(clave, clienteModificado);
                            /*MODIFICO EL HASH*/

                            miEmpresa.getClientesOrdenados().remove(apellidoAct + ", " + nombreAct);
                            /*BORRO EL TREE ACTUAL*/

                            miEmpresa.getClientesOrdenados().put(clienteModificado.getApellidos() /*CREO UN TREE CON EL NUEVO NOMBRE Y EL MISMO NIF*/
                                    + ", " + clienteModificado.getNombre(), clave);
                            break;

                        case 3:
                            System.out.println("DNI Actual: " + miEmpresa.getClientesNIF().get(clave).getNif());
                            String nifNuevo = ES.leeDeTeclado("Introduzca un nuevo NIF: ");

                            miEmpresa.getClientesNIF().get(clave).setNif(nifNuevo);
                            clienteModificado = miEmpresa.getClientesNIF().get(clave);
                            //miEmpresa.getClientesNIF().remove(clave);
                            miEmpresa.getClientesNIF().put(nifNuevo, clienteModificado);

                            miEmpresa.getClientesOrdenados().replace(clienteModificado.getApellidos()
                                    + ", " + clienteModificado.getNombre(), nifNuevo);

                            break;

                        case 4:
                            System.out.println("e-Mail Actual: " + miEmpresa.getClientesNIF().get(clave).geteMail());
                            String eMail = ES.leeDeTeclado("Introduzca un nuevo e-Mail: ");
                            miEmpresa.getClientesNIF().get(clave).seteMail(eMail);

                            break;
                    }
                    break;
            }

        } while (opcion != 6);

    }

    private static String pideNIF() {
        return ES.leeDeTeclado("Introduzca el DNI:");
    }

    public static void borrarCliente(Empresa miEmpresa, String DNI) {
        Cliente cliBorrar = miEmpresa.getClientesNIF().get(DNI);
        String apenom = cliBorrar.getApellidos() + ", " + cliBorrar.getNombre();
        miEmpresa.getClientesNIF().remove(DNI);
        miEmpresa.getClientesOrdenados().remove(apenom);

    }

}
