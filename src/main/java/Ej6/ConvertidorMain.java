package Ej6;

import static spark.Spark.get;

public class ConvertidorMain {

    public static void main(String[] args) {
        /* Ruta , Controlador */
        get("/convertirPeso", ConvertidorControlador.convertirPeso);
        get("/convertirLongitud", ConvertidorControlador.convertirLongitud);
        get("/convertirTemperatura", ConvertidorControlador.convertirTemperatura);
    }
}
