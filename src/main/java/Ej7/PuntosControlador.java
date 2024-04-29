package Ej7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import velocity.VelocityTemplateEngine;

public class PuntosControlador {

    public static Route mostrarCanjes = (Request request, Response response) -> {
        HashMap model = new HashMap();
        SistemaPuntosDAO sistemaPuntosDAO = new SistemaPuntosDAO();
        List<Canje> listaCanjes = sistemaPuntosDAO.obtenerListaCanjes();
        model.put("canjes", listaCanjes);
        model.put("template", "templates/canjes.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static Route canjesDisponibles = (Request request, Response response) -> {
        HashMap model = new HashMap();
        SistemaPuntosDAO sistemaPuntosDAO = new SistemaPuntosDAO();
        if (request.queryParams().isEmpty()) {
            model.put("canjesDisponibles", new ArrayList<>());
        } else {
            int puntosDisponibles = Integer.parseInt(request.queryParams("puntos"));
            List<Canje> canjesDisponibles = sistemaPuntosDAO.obtenerCanjesDisponibles(puntosDisponibles);
            model.put("canjesDisponibles", canjesDisponibles);
        }
        model.put("template", "templates/canjes_disponibles.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
}
