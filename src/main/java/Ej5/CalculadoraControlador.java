package Ej5;

import java.util.HashMap;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import velocity.VelocityTemplateEngine;

class CalculadoraControlador {

    public static Route sumar = (Request request, Response response) -> {
        HashMap model = new HashMap();
        Calculadora c = new Calculadora();
        if (request.queryParams().isEmpty()) {
            model.put("resultado", 0);
        } else {
            int a = Integer.parseInt(request.queryParams("a"));
            int b = Integer.parseInt(request.queryParams("b"));
            int res = c.sumar(a, b);
            model.put("resultado", res);
        }
        model.put("template", "templates/calculadora.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
    public static Route restar = (Request request, Response response) -> {
        HashMap model = new HashMap();
        Calculadora c = new Calculadora();
        if (request.queryParams().isEmpty()) {
            model.put("resultado", 0);
        } else {
            int a = Integer.parseInt(request.queryParams("a"));
            int b = Integer.parseInt(request.queryParams("b"));
            int res = c.restar(a, b);
            model.put("resultado", res);
        }
        model.put("template", "templates/calculadora.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
    public static Route multiplicar = (Request request, Response response) -> {
        HashMap model = new HashMap();
        Calculadora c = new Calculadora();
        if (request.queryParams().isEmpty()) {
            model.put("resultado", 0);
        } else {
            int a = Integer.parseInt(request.queryParams("a"));
            int b = Integer.parseInt(request.queryParams("b"));
            int res = c.multiplicar(a, b);
            model.put("resultado", res);
        }
        model.put("template", "templates/calculadora.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
    public static Route dividir = (Request request, Response response) -> {
        HashMap model = new HashMap();
        Calculadora c = new Calculadora();
        if (request.queryParams().isEmpty()) {
            model.put("resultado", 0);
        } else {
            int a = Integer.parseInt(request.queryParams("a"));
            int b = Integer.parseInt(request.queryParams("b"));
            int res = c.dividir(a, b);
            model.put("resultado", res);
        }
        model.put("template", "templates/calculadora.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
}
