package EjerciciosVoluntarios;
import java.io.BufferedReader;
import java.io.InputStreamReader;


    /*Ejercicio 6 – Comprobar conexión
    Haz un programa que ejecute el comando ping a una dirección (por ejemplo, ping
            google.com) y muestre si la conexión fue exitosa o no en base al código de salida del
    proceso.*/

public class Ejercicio6 {

    public static void main(String[] args) {
        try {
            //ProcessBuilder pb = new ProcessBuilder("cmd","/c","ping 8.8.8.8");
            ProcessBuilder pb = new ProcessBuilder("cmd","/c","ping 192.168.2.1");
            Process proceso = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            String linea;

            while((linea = reader.readLine()) != null){
                System.out.println(linea);
            }

            int exitCode = proceso.waitFor();
            String salida= exitCode == 0 ? "\nPing ejecutado con exito" : "\nFallo en solicitud";
            System.err.println(salida);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
