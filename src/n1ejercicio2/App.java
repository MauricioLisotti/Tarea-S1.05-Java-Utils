package n1ejercicio2;

import java.io.File;
import java.util.Date;
import java.util.Arrays;


public class App {

    public static void main(String[] args) {


         buscarEnDirectorio(new File("C:\\Users\\HP\\Downloads"));  //----> llamada al metodo y como parametro recibe la instancia del obj File con la ruta

    }

    public static void buscarEnDirectorio(File directorio) {
        System.out.println("D: " + directorio);   //-----> se imprime el nombre del directorio
        File[] listado = directorio.listFiles();  //-----> se crea la lista de array de la clase File
        Arrays.sort(listado);                    //------> se ordena el array
        if (listado!=null) {
            for(File file:listado) {     //----> se recorre el listado
                if (file.isDirectory())   //----> si es directorio (carpeta), entra a buscar en el directorio las carpetas y archivos que contiene
                    buscarEnDirectorio(file);  //-----> recursividad = llamarse a si mismo
                else {
                    System.out.println("F: "+file+"**"+new Date(file.lastModified()));  //------> se imprimen todos los archivos con la ultima fecha de modificacion
                }
            }
        }else {
           System.out.println("F: "+directorio);
        }
    }

}