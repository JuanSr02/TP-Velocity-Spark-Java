package Ej2;

import java.util.HashMap;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import velocity.VelocityTemplateEngine;

public class IMCControlador {

    public static Route calcularIMC = (Request req, Response res) -> {
        HashMap model = new HashMap();
        try {
            double peso = Double.parseDouble(req.queryParams("peso"));
            double altura = Double.parseDouble(req.queryParams("altura"));
            double imcd = calcularIMCf(peso, altura);
            int imc =(int) imcd;
            String valoracion = obtenerValoracionIMC(imcd);
            model.put("imc", imc);
            model.put("valoracion", valoracion);
        } catch (Exception e) {
            model.put("imc", 0);
            model.put("valoracion", "");
        }
        model.put("template", "templates/imcP.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    private static double calcularIMCf(double peso, double altura) {
        double alturaM=altura/100;
        return peso / (alturaM * alturaM);
    }

    private static String obtenerValoracionIMC(double imc) {
        if (imc < 18.5) {
            return "Bajo peso";
        } else if (imc >= 18.5 && imc < 25) {
            return "Peso normal";
        } else if (imc >= 25 && imc < 30) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }
}
