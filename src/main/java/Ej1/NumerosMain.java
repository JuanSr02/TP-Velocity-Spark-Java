package Ej1;

import static spark.Spark.*;

public class NumerosMain {

    public static void main(String[] args) {
        get("/numeros", NumerosControlador.getNumeros);
        get("/ordenar", NumerosControlador.ordenar);
        get("/desordenar", NumerosControlador.desordenar);
    }
}
