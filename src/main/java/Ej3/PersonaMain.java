package Ej3;

import static spark.Spark.*;

public class PersonaMain {

    public static void main(String[] args) {
        get("/getPersonas", PersonaControlador.getPersonas);
        get("/getHijos", PersonaControlador.getHijos); 
        get("/getNietos", PersonaControlador.getNietos);
        get("/getHermanos", PersonaControlador.getHermanos);
        get("/getPadres", PersonaControlador.getPadres);
        get("/getTios", PersonaControlador.getTios);
        get("/getSobrinos", PersonaControlador.getSobrinos);
    }
}
