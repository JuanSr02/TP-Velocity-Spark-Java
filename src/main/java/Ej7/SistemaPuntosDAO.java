package Ej7;

import java.util.ArrayList;
import java.util.List;

public class SistemaPuntosDAO {

    // Lista de canjes disponibles
    private List<Canje> listaCanjes;

    public SistemaPuntosDAO() {
        this.listaCanjes = new ArrayList<>();
        // Agregar canjes disponibles (puedes agregar más según necesites)
        listaCanjes.add(new Canje("Helado Gratis", 5000));
        listaCanjes.add(new Canje("Descuento del 20%", 3000));
        listaCanjes.add(new Canje("1 kg de helado", 200000));
    }

    // Método para obtener la lista de canjes disponibles
    public List<Canje> obtenerListaCanjes() {
        return listaCanjes;
    }

    // Método para verificar los canjes disponibles según la cantidad de puntos del usuario
    public List<Canje> obtenerCanjesDisponibles(int puntosDisponibles) {
        List<Canje> canjesDisponibles = new ArrayList<>();
        for (Canje canje : listaCanjes) {
            if (canje.getPuntosRequeridos() <= puntosDisponibles) {
                canjesDisponibles.add(canje);
            }
        }
        return canjesDisponibles;
    }
}

