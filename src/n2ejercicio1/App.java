package n2ejercicio1;
import java.util.Arrays;
import java.util.Properties;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;


public class App {

    public static void main(String[]args) throws IOException {

        Properties prop = new Properties(); 

        try {
            prop.load(new FileInputStream(new File("C:\\Users\\HP\\Desktop\\prueba_java\\configuracion.properties")));
            String ruta = prop.getProperty("directorio");
            File file = new File(ruta);
            File[] directorio = file.listFiles();
            Arrays.sort(directorio);

            String fl = prop.getProperty("archivo");
            File nuevoArchivo = new File(fl);

            FileWriter fw = new FileWriter(nuevoArchivo);
            BufferedWriter bw = new BufferedWriter(fw);
            registraDirectorios(directorio, nuevoArchivo, bw);
            bw.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());

        } 
    }

    public static void registraDirectorios(File[] directorio, File nuevoArchivo, BufferedWriter bw) {
        try {
            for(int i=0; i<directorio.length;i++) {
                if(directorio[i].isDirectory()) {
                    bw.write("D: "+directorio[i]);
                    bw.newLine();
                }else if(directorio[i].isFile()) {
                    Date lastmodif = new Date(directorio[i].lastModified());
                    bw.write("F - "+directorio[i]+" \tÚltima modificació "+lastmodif); 
                    bw.newLine();
                }
            }
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

}