package arraylist7;

import java.util.ArrayList;

/**
 *
 * @author RafaMar
 */

public class ArrayList7 extends ArrayList {

    public static ArrayList ArrayList7(int dimension1) {
        ArrayList<Integer> array = rellenaArrayList(dimension1);
        return array;
    }

    public static ArrayList ArrayList7(int dimension1, int dimension2) {

        ArrayList<ArrayList<Integer>> array = new ArrayList();

        for (int i = 0; i < dimension1; i++) {
            array.add(i, rellenaArrayList(dimension2));
        }
        return array;
    }

    public static ArrayList ArrayList7(int dimension1, int dimension2, int dimension3) {
        ArrayList<ArrayList<ArrayList<Integer>>> array = new ArrayList();
        for (int i = 0; i < dimension1; i++) {
            array.add(i, ArrayList7(dimension2, dimension3));
        }
        return array;
    }

    /*METODOS PROPIOS*/
    public static ArrayList rellenaArrayList(int dimension) {

        ArrayList array = new ArrayList(dimension);

        for (int i = 0; i < dimension; i++) {
            array.add(i, generaEntero());
        }
        return array;
    }

    public static int generaEntero() {
        int aleatorio = (int) (Math.random() * (25));
        return aleatorio;
    }

    public static void buscaNumero7(ArrayList array) {
        int posicion = array.indexOf(7);
        if(posicion!=-1){
            System.out.println("Posicion x: "+posicion);
        }else{
            System.out.println("No se ha encontrado el numero 7");
        }
    }

    public static void buscaNumero72D(ArrayList<ArrayList<Integer>> array) {
        int x = 0;
        int y = 0;
        for (ArrayList<Integer> arrayList : array) {
            for (Integer integer : arrayList) {
                if (integer == 7) {
                    System.out.println("Posicion x: " + x + "; Posicion y: " + y);
                    return;
                }
                y++;
            }
            x++;
            y = 0;
        }
        System.out.println("No se ha encontrado el numero");
    }

    public static void buscaNumero73D(ArrayList<ArrayList<ArrayList<Integer>>> array) {
        int x = 0;
        int y = 0;
        int z = 0;
        for (ArrayList<ArrayList<Integer>> arrayList : array) {
            for (ArrayList<Integer> arrayList1 : arrayList) {
                for (Integer integer : arrayList1) {
                    if (integer == 7) {
                        System.out.println("Posicion x: " + x + "; Posicion y: " + y + "; Posicion z: " + z);
                        return;
                    }
                    z++;
                }
                y++;
                z=0;
            }
            x++;
            y=0;
            z=0;
        }
        System.out.println("No se ha encontrado el numero");
    }

    private static void pintarArrayList(ArrayList arrayList) {
        System.out.println("**** ArrayList ****");
        for (Object numero : arrayList) {
            System.out.println(numero);
        }
    }

    public static void main(String[] args) {
        ArrayList prueba = ArrayList7(10);
        pintarArrayList(prueba);
        buscaNumero7(prueba);

        ArrayList prueba2 = ArrayList7(6, 5);
        pintarArrayList(prueba2);

        buscaNumero72D(prueba2);

        ArrayList prueba3 = ArrayList7(10, 10,  10);
        pintarArrayList(prueba3);

        buscaNumero73D(prueba3);
    }

}
