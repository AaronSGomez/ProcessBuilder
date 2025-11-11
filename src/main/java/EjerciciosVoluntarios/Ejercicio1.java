package EjerciciosVoluntarios;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Ejercicio 1 – Mostrar directorio actual
Crea un programa que ejecute el comando del sistema operativo que muestra el contenido
del directorio actual (dir en Windows o ls en Linux) y muestre la salida por pantalla.
*/

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd","/c","dir");
            Process proceso = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            String linea;

            while((linea = reader.readLine()) != null){
                System.out.println(linea);
            }

            int exitCode = proceso.waitFor();
            System.out.println("El proceso terminó con código: "+exitCode);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
