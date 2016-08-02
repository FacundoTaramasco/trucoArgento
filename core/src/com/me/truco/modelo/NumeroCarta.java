package com.me.truco.modelo;

/**
 * Created by FacundoTaramasco on 2/8/2016.
 */
public enum NumeroCarta {

    UNO    (1),
    DOS    (2),
    TRES   (3),
    CUATRO (4),
    CINCO  (5),
    SEIS   (6),
    SIETE  (7),
    DIEZ   (10),
    ONCE   (11),
    DOCE   (12);

    private final int valor;

    // Constructor
    NumeroCarta(int valor) {
        this.valor = valor;
    }

    // Getter
    public int getValor() {
        return valor;
    }

}
