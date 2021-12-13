package n1ejercicio3;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Arrays;


public class App {

    public static void main(String[]args) throws IOException {
        FileWriter fw = new FileWriter("Test_1.txt");   //---> se crea el obj de la clase FileWriter para crear un txt
        PrintWriter pw = new PrintWriter(fw);           //---> se imprime ese txt

        buscarEnDirectorio(new File("C:\\Users\\HP\\Desktop\\prueba java"),pw);  //---> se llama al metodo y como parametro se crea el obj File con la ruta y segundo parametro el PrintWriter
    }

    public static void buscarEnDirectorio(File directorio,PrintWriter pw) throws IOException {
          System.out.println("D: " + directorio);
            File[] listado = directorio.listFiles();
            Arrays.sort(listado);
            if (listado!=null) {
                for(File file:listado) {
                    if (file.isDirectory())
                        buscarEnDirectorio(file,pw);
                    else {
                        pw.println("F: "+file+"**"+new Date(file.lastModified())); //---> se imprimen en el txt los nombres de los archivos de la ruta elegida y la fecha de la ultima modificacion
                        System.out.println("F: "+file+"***"+new Date(file.lastModified()));
                    }
                }
            }else {
                pw.println("F "+directorio);  //-----> se imprime en el txt los nombres de las carpetas de la ruta elegida
                System.out.println("F: "+directorio);
            }
    }

}