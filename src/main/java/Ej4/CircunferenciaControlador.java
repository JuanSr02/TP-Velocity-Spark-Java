package Ej4;

import java.util.HashMap;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import velocity.VelocityTemplateEngine;

public class CircunferenciaControlador {

    public static Route PerimetroyArea = (Request request, Response response) -> {
        HashMap model = new HashMap();
        double perimetro=0.0,area=0.0;
        if(!request.queryParams().isEmpty()){
           double radio = Double.parseDouble(request.queryParams("radio"));
           perimetro = calcularPerimetro(radio);
           area = calcularArea(radio);
        }
        model.put("perimetro", perimetro);
        model.put("area", area);
        model.put("template", "templates/circunferencia.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static double calcularPerimetro(double radio) {
        return 2 * Math.PI * radio;
    }

    public static double calcularArea(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }
}
