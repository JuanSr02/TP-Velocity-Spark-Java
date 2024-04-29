package Ej6;

import java.util.HashMap;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import velocity.VelocityTemplateEngine;

public class ConvertidorControlador {

    public static Route convertirPeso = (Request request, Response response) -> {
        HashMap model = new HashMap();
        ConvertidorUnidades convertidor = new ConvertidorUnidades();
        // Obtener los parámetros del request
        if (request.queryParams().isEmpty()) {
            model.put("resultado", 0);
            model.put("valor", 0);
            model.put("unidadO", "");
            model.put("unidadN", "");
        } else {
            double valor = Double.parseDouble(request.queryParams("valor"));
            String unidadOrigen = request.queryParams("unidadOrigen");
            String unidadDestino = request.queryParams("unidadDestino");
            // Llamar al método correspondiente en el convertidor de unidades
            double resultado = convertidor.convertirPeso(valor, unidadOrigen, unidadDestino);
            model.put("resultado", resultado);
            model.put("valor", valor);
            model.put("unidadO", unidadOrigen);
            model.put("unidadN", unidadDestino);
        }
        model.put("template", "templates/convertidor.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static Route convertirLongitud = (Request request, Response response) -> {
        HashMap model = new HashMap();
        ConvertidorUnidades convertidor = new ConvertidorUnidades();
        // Obtener los parámetros del request
        if (request.queryParams().isEmpty()) {
            model.put("resultado", 0);
            model.put("valor", 0);
            model.put("unidadO", "");
            model.put("unidadN", "");
        } else {
            double valor = Double.parseDouble(request.queryParams("valor"));
            String unidadOrigen = request.queryParams("unidadOrigen");
            String unidadDestino = request.queryParams("unidadDestino");
            // Llamar al método correspondiente en el convertidor de unidades
            double resultado = convertidor.convertirLongitud(valor, unidadOrigen, unidadDestino);
            model.put("resultado", resultado);
            model.put("valor", valor);
            model.put("unidadO", unidadOrigen);
            model.put("unidadN", unidadDestino);
        }
        model.put("template", "templates/convertidor.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static Route convertirTemperatura = (Request request, Response response) -> {
        HashMap model = new HashMap();
        ConvertidorUnidades convertidor = new ConvertidorUnidades();
        // Obtener los parámetros del request
        if (request.queryParams().isEmpty()) {
            model.put("resultado", 0);
            model.put("valor", 0);
            model.put("unidadO", "");
            model.put("unidadN", "");
        } else {
            double valor = Double.parseDouble(request.queryParams("valor"));
            String unidadOrigen = request.queryParams("unidadOrigen");
            String unidadDestino = request.queryParams("unidadDestino");
            // Llamar al método correspondiente en el convertidor de unidades
            double resultado = convertidor.convertirTemperatura(valor, unidadOrigen, unidadDestino);
            model.put("resultado", resultado);
            model.put("valor", valor);
            model.put("unidadO", unidadOrigen);
            model.put("unidadN", unidadDestino);
        }
        model.put("template", "templates/convertidor.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

}
