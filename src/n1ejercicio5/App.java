package n1ejercicio5;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {

    public static void main(String[]args) throws IOException {
        String [] nombres = {"Carlos","Juan","Pepe"};
        int [] edad = null;

        try { 
            String archivo = "pruebaSerializable.txt"; //----> se crea un archivo que recogera datos
            FileOutputStream file = new FileOutputStream(archivo); //--->crea un fichero, salvo que exista y sea solo de lectura
            ObjectOutputStream f = new ObjectOutputStream(file);  // ---> Un objeto ObjectOutputStream se crea a partir de un objeto FileOutputStream asociado al fichero.
            f.writeObject(nombres); // ---> 
            f.close();  // --->

            } 
        catch (Exception e) {
            e.getMessage();
        }


        try {
            String archivo = "pruebaSerializable.txt"; // ---> se recoge el archivo en la raiz
            FileInputStream arch = new FileInputStream(archivo) ;
            ObjectInputStream a = new ObjectInputStream(arch) ;

            edad = (int[]) a.readObject(); // ---> se cogen los datos del archivo y se lo añadimos a la nueva variable edad
            System.out.println(edad);
            a.close();
            arch.close();

        }
        catch (Exception e) {
            e.getMessage();
        }
    }
}