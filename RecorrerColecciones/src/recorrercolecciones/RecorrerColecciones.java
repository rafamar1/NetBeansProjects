

package recorrercolecciones;
import java.util.*;
import utilidades67.personas.Persona;
public class RecorrerColecciones {

    
    public static void main(String[] args) {
        ArrayList<Persona> arrayList = new ArrayList();
        LinkedList<Persona> linkedList = new LinkedList();
        HashSet<Persona> hashSet = new HashSet();
        TreeSet<Persona> treeSet = new TreeSet();
        HashMap<String,Persona> hashMap = new HashMap();
        TreeMap<String,Persona> treeMap = new TreeMap();
        Persona persona1 = new Persona("Francisco", "25598196R");
        Persona persona3 = new Persona("Braulio", "98765432");
        Persona persona2 = new Persona("Alvaro", "12345678");
        Persona persona4 = new Persona("Salvador", "87654321");
        
        arrayList.add(persona1);
        arrayList.add(persona2);
        arrayList.add(persona3);
        arrayList.add(persona4);
        listarArrayList(arrayList);
        
        linkedList.add(persona1);
        linkedList.add(persona2);
        linkedList.add(persona3);
        linkedList.add(persona4);
        listarLinkedList(linkedList);
        
        hashSet.add(persona1);
        hashSet.add(persona2);
        hashSet.add(persona3);
        hashSet.add(persona4);
        listarHashSet(hashSet);
        
        treeSet.add(persona1);
        treeSet.add(persona2);
        treeSet.add(persona3);
        treeSet.add(persona4);
        listarTreeSet(treeSet);
        
        hashMap.put(persona1.getNif(), persona1);
        hashMap.put(persona2.getNif(), persona2);
        hashMap.put(persona3.getNif(), persona3);
        hashMap.put(persona4.getNif(), persona4);
        listarHashMap(hashMap);
        
        treeMap.put(persona1.getNombre(), persona1);
        treeMap.put(persona2.getNombre(), persona2);
        treeMap.put(persona3.getNombre(), persona3);
        treeMap.put(persona4.getNombre(), persona4);
        listarTreeMap(treeMap);
    }

    private static void listarArrayList(ArrayList<Persona> arrayList) {
        System.out.println("**** ArrayList ****");
        System.out.println("**** For Each ****");
        for (Persona persona : arrayList) {
            System.out.println(persona);
        }
        System.out.println("**** For Normal ****");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    private static void listarLinkedList(LinkedList<Persona> linkedList) {
        System.out.println("**** LinkedList ****");
        System.out.println("**** For Each ****");
        for (Persona persona : linkedList) {
            System.out.println(persona);
        }
        System.out.println("**** For Normal ****");
        for(int i = 0; i < linkedList.size(); i++){
            System.out.println(linkedList.get(i));
        }
    }

    private static void listarHashSet(HashSet<Persona> hashSet) {
        System.out.println("**** HashSet ****");
        System.out.println("**** For Each ****");
        for (Persona persona : hashSet) {
            System.out.println(persona);
        }
        System.out.println("**** Iterator Normal ****");
        Iterator iterator = hashSet.iterator();
        while(iterator.hasNext()){
            System.out.println((Persona)iterator.next());
        }
    }

    private static void listarTreeSet(TreeSet<Persona> treeSet) {
        System.out.println("**** TreeSet ****");
        System.out.println("**** For Normal ****");
        for (Persona persona : treeSet) {
            System.out.println(persona);
        }
        System.out.println("**** Iterator Descendente ****");
        Iterator iterator = treeSet.descendingIterator();
        while(iterator.hasNext()){
            System.out.println((Persona)iterator.next());
        }
    }

    private static void listarHashMap(HashMap<String, Persona> hashMap) {
        System.out.println("**** HashMap ****");
        System.out.println("**** HashMap.values ****");
        Iterator iterator = hashMap.values().iterator();
        while(iterator.hasNext()){
            System.out.println((Persona)iterator.next());
        }
        System.out.println("**** HashMap.keySet ****");
        Set<String> keySet = hashMap.keySet();
        for (String key : keySet) {
            System.out.println(hashMap.get(key));
        }
    }

    private static void listarTreeMap(TreeMap<String, Persona> treeMap) {
        System.out.println("**** TreeMap.values ****");
        Iterator<Persona> iterator = treeMap.values().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("**** TreeMap.keySet ****");
        Set<String> keySet = treeMap.keySet();
        for (String key : keySet) {
            System.out.println(treeMap.get(key));
        }
        System.out.println("**** TreeMap.descendingKeySet ****");
        NavigableSet<String> descendingKeySet = treeMap.descendingKeySet();
        for (String key : descendingKeySet) {
            System.out.println(treeMap.get(key));
        }
    }

   

}
