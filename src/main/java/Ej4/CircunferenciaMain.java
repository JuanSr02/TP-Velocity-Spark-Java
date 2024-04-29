package Ej4;

import static spark.Spark.*;

public class CircunferenciaMain {

    public static void main(String[] args) {
        get("/circunferencia", CircunferenciaControlador.PerimetroyArea);
    }

}
