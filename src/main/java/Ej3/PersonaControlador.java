package Ej3;

import java.util.HashMap;
import java.util.List;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import velocity.VelocityTemplateEngine;

public class PersonaControlador {

    public static Route getPersonas = (Request req, Response res) -> {
        PersonaDAO pDAO = new PersonaDAO();
        List<Persona> personas = pDAO.getPersonas();
        HashMap model = new HashMap();
        model.put("personas", personas);
        model.put("template", "templates/familia.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static Route getHijos = (Request req, Response res) -> {
        PersonaDAO pDAO = new PersonaDAO();
        List<Persona> hijos = pDAO.getHijos(req.queryParams("nombre"));
        HashMap model = new HashMap();
        model.put("personas", hijos);
        model.put("template", "templates/familia.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static Route getNietos = (Request req, Response res) -> {
        PersonaDAO pDAO = new PersonaDAO();
        List<Persona> nietos = pDAO.getNietos(req.queryParams("nombre"));
        HashMap model = new HashMap();
        model.put("personas", nietos);
        model.put("template", "templates/familia.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static Route getHermanos = (Request req, Response res) -> {
        PersonaDAO pDAO = new PersonaDAO();
        List<Persona> hermanos = pDAO.getHermanos(req.queryParams("nombre"));
        HashMap model = new HashMap();
        model.put("personas", hermanos);
        model.put("template", "templates/familia.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static Route getPadres = (Request req, Response res) -> {
        PersonaDAO pDAO = new PersonaDAO();
        List<Persona> padres = pDAO.getPadres(req.queryParams("nombre"));
        HashMap model = new HashMap();
        model.put("personas", padres);
        model.put("template", "templates/familia.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static Route getTios = (Request req, Response res) -> {
        PersonaDAO pDAO = new PersonaDAO();
        List<Persona> tios = pDAO.getTios(req.queryParams("nombre"));
        HashMap model = new HashMap();
        model.put("personas", tios);
        model.put("template", "templates/familia.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static Route getSobrinos = (Request req, Response res) -> {
        PersonaDAO pDAO = new PersonaDAO();
        List<Persona> sobrinos = pDAO.getSobrinos(req.queryParams("nombre"));
        HashMap model = new HashMap();
        model.put("personas", sobrinos);
        model.put("template", "templates/familia.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
}
