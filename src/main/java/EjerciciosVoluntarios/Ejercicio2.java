package EjerciciosVoluntarios;

/*Ejercicio 2 – Guardar la fecha del sistema
Crea un programa que ejecute el comando que muestra la fecha (date) y guarde la salida
en un fichero llamado fecha.txt.*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Ejercicio2 {
    public static void main(String[] args) {

        try {
            ProcessBuilder pb = new ProcessBuilder("cmd","/c","date /t");
            Process proceso = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            BufferedWriter  bw = new BufferedWriter(new FileWriter("Ejer2.txt"));
            String linea;

            while((linea = reader.readLine()) != null){
                bw.write(linea);
                System.out.println(linea);
                bw.newLine();
            }

            int exitCode = proceso.waitFor();
            bw.close(); //cerrar el bufered writer o no se guarda la fecha
            System.out.println("El proceso terminó con código: "+exitCode);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
