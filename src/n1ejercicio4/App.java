package n1ejercicio4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class App {

    public static void main(String[] args) throws IOException {

        File fl = new File("Test_1.txt");  //---> se crea el obj de la clase File y se le pasa por parametro el nombre del archivo txt que queremos abrir
        FileReader fr = new FileReader(fl);  //---> se crea el obj de la clase FileReader, busca el archivo donde se le indica
        BufferedReader br = new BufferedReader(fr);   //---> se crea el obj de la clase BufferedReader que sirve para leer la entrada de un archivo
        String linea = br.readLine();   //---> a traves del buffer se usa la funcion .readLine() que sirva para leer una sola linea de texto desde la consola
        System.out.println();

        while(linea != null) {           //----> si la linea no es null entra en el while
            System.out.println(linea);   //---> imprime cada linea del conenido del archivo 
            linea = br.readLine();      //---> .readLine() que sirva para leer una sola linea de texto desde la consola
        }

        br.close();     //---> es para cerrar el buffer. 


    }
}