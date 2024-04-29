package Ej3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonaDAO {

    private List<Persona> personas;

   public void init() { // FUNCION PARA AGREGAR PERSONAS DE PRUEBA
    personas = new ArrayList<>();
    Persona pJuan = new Persona("JUAN", "SANCHEZ");
    personas.add(pJuan);
    Persona pIvan = new Persona("IVAN", "BROCAS");
    personas.add(pIvan);
    pJuan.addHijo(pIvan);
    pIvan.addPadre(pJuan); // Asignar padre a Ivan
    Persona pCelso = new Persona("CELSO", "FERNANDEZ");
    personas.add(pCelso);
    pJuan.addHijo(pCelso);
    pCelso.addPadre(pJuan); // Asignar padre a Celso
    Persona pLautaro = new Persona("LAUTARO", "SORIA");
    personas.add(pLautaro);
    pIvan.addHijo(pLautaro);
    pLautaro.addPadre(pIvan); // Asignar padre a Lautaro
    Persona pNicolas = new Persona("NICOLAS", "VILURON");
    personas.add(pNicolas);
    pIvan.addHijo(pNicolas);
    pNicolas.addPadre(pIvan); // Asignar padre a Nicolas
    Persona pLuciana = new Persona("LUCIANA", "LOYOLA");
    personas.add(pLuciana);
    pCelso.addHijo(pLuciana);
    pLuciana.addPadre(pCelso); // Asignar padre a Luciana
    
    // Agregar más personas y asignar padres según sea necesario
}


    public List<Persona> getPersonas() {
        init();
        return personas;
    }

    public List<Persona> getNietos(String nombre) {
        init();
        List<Persona> nietos;
        nietos = new ArrayList<Persona>();
        if (nombre == null) {
            return nietos;
        }
        Persona pEncontrada = buscarPersona(nombre);
        if (pEncontrada != null) {
            pEncontrada.getHijos().forEach(persona -> {
                nietos.addAll(persona.getHijos());
            });
        }
        return nietos;
    }

    public List<Persona> getHijos(String nombre) {
        init();
        List<Persona> hijos;
        hijos = new ArrayList<Persona>();
        if (nombre == null) {
            return hijos;
        }
        Persona pEncontrada = buscarPersona(nombre);
        if (pEncontrada != null) {
            hijos = pEncontrada.getHijos();
        }
        return hijos;
    }

    public List<Persona> getHermanos(String nombre) {
        init();
        List<Persona> hermanos = new ArrayList<>();
        if (nombre == null) {
            return hermanos;
        }
        Persona persona = buscarPersona(nombre);
        if (persona != null && persona.getPadres() != null) {
            for (Persona p1 : persona.getPadres()) {
                hermanos.addAll(p1.getHijos());
                hermanos.remove(persona);
            }
            eliminarRepetidos(hermanos);
        }
        return hermanos;
    }

    public List<Persona> getPadres(String nombre) {
        init();
        List<Persona> padres = new ArrayList<>();
        if (nombre == null) {
            return padres;
        }
        Persona persona = buscarPersona(nombre);
        if (persona != null && persona.getPadres() != null) {
            padres.addAll(persona.getPadres());
        }
        return padres;
    }

    public List<Persona> getTios(String nombre) {
        init();
        List<Persona> tios = new ArrayList<>();
        if (nombre == null) {
            return tios;
        }
        Persona persona = buscarPersona(nombre);
        if (persona != null && persona.getPadres() != null) {
            for (Persona p1 : persona.getPadres()) {
                tios.addAll(getHermanos(p1.getNombre()));
            }
        }
        return tios;
    }

    public List<Persona> getSobrinos(String nombre) {
        init();
        List<Persona> sobrinos = new ArrayList<>();
        List<Persona> hermanos = new ArrayList<>();
        if (nombre == null) {
            return sobrinos;
        }
        Persona persona = buscarPersona(nombre);
        if (persona != null && persona.getPadres() != null) {
            for (Persona p1 : persona.getPadres()) {
                hermanos.addAll(p1.getHijos());
            }
            hermanos.remove(persona);
            for (Persona tio : hermanos){
                sobrinos.addAll(tio.getHijos());
            }
        }
        return sobrinos;
    }

    // Métodos auxiliares aquí...
    private Persona buscarPersona(String nombre) {
        return personas.stream()
                .filter(p -> nombre.equals(p.getNombre()))
                .findAny()
                .orElse(null);
    }

    public static void eliminarRepetidos(List<Persona> lista) {
        Set<Persona> set = new HashSet<>(lista);
        lista.clear();
        lista.addAll(set);
    }
}
