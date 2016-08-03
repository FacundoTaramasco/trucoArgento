package com.me.truco.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FacundoTaramasco on 2/8/2016.
 */
public class Truco {


    private List<Carta> mazoCartas;

    private static final List<Carta> jerarquiaCartas = new ArrayList<Carta>();

    public Truco() {
        mazoCartas = new ArrayList<Carta>();

        this.generarMazo();

        this.establecerJerarquiaCartas();

        System.out.println( jerarquiaCartas );
    }


    // Customs
    private void generarMazo() {
        for (Palos p : Palos.values()) { // COPA, ORO, BASTO, ESPADA
            for (NumeroCarta n : NumeroCarta.values()) { // UNO, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, DIEZ, ONCE, DOCE
                mazoCartas.add(new Carta(p, n));
            }
        }
    }

    private void establecerJerarquiaCartas() {
        jerarquiaCartas.add( mazoCartas.get(30) ); // 1 espada
        jerarquiaCartas.add( mazoCartas.get(20) ); // 1 basto
        jerarquiaCartas.add( mazoCartas.get(36) ); // 7 espada
        jerarquiaCartas.add( mazoCartas.get(16) ); // 7 oro

        for (Carta c : mazoCartas)
            if ( c.getValor().getValor() == 3)  jerarquiaCartas.add(c);

        for (Carta c : mazoCartas)
            if ( c.getValor().getValor() == 2) jerarquiaCartas.add(c);

        for (Carta c : mazoCartas)
            if ( c.getValor().getValor() == 1 && c.getPalo() != Palos.BASTO && c.getPalo() != Palos.ESPADA) jerarquiaCartas.add(c);

        for (Carta c : mazoCartas)
            if ( c.getValor().getValor() == 12) jerarquiaCartas.add(c);

        for (Carta c : mazoCartas)
            if ( c.getValor().getValor() == 11) jerarquiaCartas.add(c);

        for (Carta c : mazoCartas)
            if ( c.getValor().getValor() == 10) jerarquiaCartas.add(c);

        for (Carta c : mazoCartas)
            if ( c.getValor().getValor() == 7 && c.getPalo() != Palos.ESPADA && c.getPalo() != Palos.ORO) jerarquiaCartas.add(c);

        for (Carta c : mazoCartas)
            if ( c.getValor().getValor() == 6) jerarquiaCartas.add(c);

        for (Carta c : mazoCartas)
            if ( c.getValor().getValor() == 5) jerarquiaCartas.add(c);

        for (Carta c : mazoCartas)
            if ( c.getValor().getValor() == 4) jerarquiaCartas.add(c);
    }
}
