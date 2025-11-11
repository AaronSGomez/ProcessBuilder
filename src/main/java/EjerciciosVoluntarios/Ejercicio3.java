package EjerciciosVoluntarios;

/*Ejercicio 3 – Redirigir errores
Crea un programa que intente ejecutar un comando inexistente y redirija los mensajes de
error a un archivo llamado errores.txt.*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Ejercicio3 {
        public static void main(String[] args) {
            try {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "comando_inexistente");
                Process p = pb.start();

                BufferedReader err = new BufferedReader(
                        new InputStreamReader(p.getErrorStream())
                );
                BufferedWriter bw = new BufferedWriter(new FileWriter("Ejer3.txt"));

                String linea;
                while ((linea = err.readLine()) != null) {
                    System.out.println("ERROR:" + linea);
                    bw.write(linea);
                    bw.newLine();
                }

                bw.close();
                p.waitFor();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
}
