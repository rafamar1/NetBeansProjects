package videoclub;


import java.util.ArrayList;
import utilidades67.ES.ES;

public class Menu {

    public Menu() {

    }

    public void pintaMenu(ArrayList<String> listaMenus) {
        int i = 1;
        for (String menu : listaMenus) {
            System.out.println(i + ".- " + menu);
            i++;
        }
    }
}
