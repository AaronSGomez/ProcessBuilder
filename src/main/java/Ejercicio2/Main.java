package Ejercicio2;

public class Main {
    public static void main(String[] args) {
        GestorProcesos g  = new GestorProcesos();
        g.ejecutarComando("dir");
        g.redirigirSalida("ipconfig/all","salida.txt");
        g.mostrarErrores("comandoinexistente");
    }
}
