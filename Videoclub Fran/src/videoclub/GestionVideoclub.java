package videoclub;

import java.io.IOException;


public class GestionVideoclub {

   
    public static void main(String[] args) throws IOException {
        Videoclub videoclub = new Videoclub("src/datos/clientes.txt", "src/datos/peliculas.txt");
        videoclub.gestionarMenuPrincipal();
        
    }
    
}
