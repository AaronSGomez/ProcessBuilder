package EjerciciosVoluntarios;

/*Ejercicio 4 – Preguntar un comando y guardar su salida
Haz que el programa pida al usuario un comando del sistema, lo ejecute y guarde tanto la
salida como los errores en el archivo resultado.txt.*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el comando que desea: ");
            String comando = sc.nextLine();


            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", comando);
            Process proceso = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            BufferedWriter  bw = new BufferedWriter(new FileWriter("Ejer4.txt", StandardCharsets.UTF_8));
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
