package Ej6;

public class ConvertidorUnidades {

    public double convertirPeso(double valor, String unidadOrigen, String unidadDestino) {
        if (unidadOrigen.equals("kgs") && unidadDestino.equals("lbs")) {
            return valor * 2.2046;
        } else {
            return valor / 2.2046;
        }
    }

    public double convertirTemperatura(double valor, String unidadOrigen, String unidadDestino) {
        if (unidadOrigen.equals("C°") && unidadDestino.equals("F°")) {
            return valor * (9 / 5) + 32;
        } else {
            return (valor - 32) * (5 / 9);
        }
    }

    public double convertirLongitud(double valor, String unidadOrigen, String unidadDestino) {
        if (unidadOrigen.equals("m") && unidadDestino.equals("cm")) {
            return valor*100;
        } else {
            return valor/100;
        }
    }
}
