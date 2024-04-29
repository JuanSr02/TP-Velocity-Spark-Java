package Ej1;


import java.util.ArrayList;
import java.util.Arrays;

import spark.Request;
import spark.Response;
import spark.Route;
import java.util.HashMap;
import java.util.Random;
import spark.ModelAndView;
import velocity.VelocityTemplateEngine;

public class NumerosControlador {

    public static Route getNumeros = (Request req, Response res) -> {
        HashMap model = new HashMap();
        model.put("numeros", new ArrayList<>());
        model.put("template", "templates/numeros.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static Route ordenar = (Request req, Response res) -> {
        HashMap model = new HashMap();
        String[] numerosStr = req.queryParamsValues("numero");
        int [] numeros = new int[6];
        try{
        numeros = Arrays.stream(numerosStr).mapToInt(Integer::parseInt).toArray();}
        catch (Exception e){
            model.put("numeros", new ArrayList<>());
            model.put("template", "templates/numeros.vtl");
            return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
        }
        Arrays.sort(numeros);
        model.put("numeros", numeros);
        model.put("template", "templates/numeros.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static Route desordenar = (Request req, Response res) -> {
        HashMap model = new HashMap();
        String[] numerosStr = req.queryParamsValues("numero");
        int [] numeros = new int[6];
        try{
        numeros = Arrays.stream(numerosStr).mapToInt(Integer::parseInt).toArray();}
        catch (Exception e){
            model.put("numeros", new ArrayList<>());
            model.put("template", "templates/numeros.vtl");
            return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
        }
        desordenarArray(numeros);
        model.put("numeros", numeros);
        model.put("template", "templates/numeros.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static void desordenarArray(int[] array) {
        Random rnd = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Intercambiar los elementos
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
