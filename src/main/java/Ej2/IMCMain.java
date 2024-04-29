package Ej2;

import static spark.Spark.*;

public class IMCMain {

    public static void main(String[] args) {
        get("/IMC", IMCControlador.calcularIMC);
    }
}
