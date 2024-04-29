package Ej3;
import java.util.ArrayList;
import java.util.List;

public class Persona {

    private String nombre;
    private String apellido;
    private List<Persona> hijos;
    private List<Persona> padres; // Lista de padres (máximo 2)

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.hijos = new ArrayList<>();
        this.padres = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public List<Persona> getHijos() {
        return hijos;
    }
    
    public void addHijo(Persona hijo) {
        hijos.add(hijo);
    }

    public List<Persona> getPadres() {
        return padres;
    }

    public void addPadre(Persona padre) {
        if (padres.size() < 2) {
            padres.add(padre);
        }
    }

}

