package EjerciciosVoluntarios;

/*Ejercicio 5 – Mostrar variables de entorno
Crea un programa que utilice pb.environment() para listar todas las variables de entorno
del sistema.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio5 {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder();
            Map<String ,String> variables = pb.environment();

            System.out.println("Variables de entorno");
            for(Map.Entry<String, String> entry : variables.entrySet()){
                System.out.println(entry.getKey() + "  ->  " + entry.getValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
