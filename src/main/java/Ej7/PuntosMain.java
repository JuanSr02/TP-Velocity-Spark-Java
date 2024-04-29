package Ej7;

import static spark.Spark.get;

public class PuntosMain {

    public static void main(String[] args) {
        /* Rutas, Controladores */
        get("/mostrarCanjes", PuntosControlador.mostrarCanjes);
        get("/canjesDisponibles", PuntosControlador.canjesDisponibles);
    }
}
