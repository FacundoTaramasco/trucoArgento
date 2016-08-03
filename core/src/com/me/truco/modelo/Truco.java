package com.me.truco.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by FacundoTaramasco on 2/8/2016.
 */
public class Truco {

    private List<Carta> mazoCartas = new ArrayList<Carta>();

    private final List<Carta> jerarquiaCartas = new ArrayList<Carta>();

    private Jugador jugadorUno;
    private Jugador jugadorDos;

    private boolean estadoJuego;

    // Constructor
    public Truco() {
        init();
    }

    /**
     * Metodo que inicializa el juego
     */
    private void init() {
        this.generarMazo();

        this.establecerJerarquiaCartas();

        System.out.println("Mazo generado : ");
        mostrarMazoCustom();
        System.out.println("*******************************************************");

        this.abarajarMazo();

        System.out.println("Mazo abarajado : ");
        mostrarMazoCustom();
        System.out.println("*******************************************************");

        jugadorUno = new Jugador("Facu");
        jugadorDos = new Jugador("IA");

        System.out.println("Jugadores : ");
        System.out.println(jugadorUno);
        System.out.println(jugadorDos);
        System.out.println("*******************************************************");

    }

    /**
     * A jugar!
     */
    public void jugar() {
        estadoJuego = true;

        System.out.println("Entregando cartas a los jugadores...");
        darCartasJugador(jugadorUno);
        darCartasJugador(jugadorDos);


        System.out.println("Recibiendo cartas de todos los jugadores...");

        recibirCartasJugadores();

        mostrarMazoCustom();

        /*
        while (estadoJuego) {


        }
        */

    }

    // Customs

    /**
     * Metodo que genera el mazo de cartas
     */
    private void generarMazo() {
        for (Palos p : Palos.values()) { // COPA, ORO, BASTO, ESPADA
            for (NumeroCarta n : NumeroCarta.values()) { // UNO, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, DIEZ, ONCE, DOCE
                mazoCartas.add(new Carta(p, n));
            }
        }
    }

    /**
     * Metodo que establece el orden jerarquico del mazo
     */
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

    /**
     * Metodo que abaraja el mazo (lo desordena)
     */
    public void abarajarMazo() {
        Collections.shuffle(mazoCartas);
    }

    /**
     * Metodo que le entrega 3 cartas random del mazo al jugador especificado.
     * @param j Jugador que recibe las cartas.
     */
    private void darCartasJugador(Jugador j) {
        Random r = new Random();
        Carta carta;
        int indice;
        for (int i = 0; i < 3; i++) {
            indice = r.nextInt(mazoCartas.size());
            carta = mazoCartas.get(indice);
            j.recibirCarta(carta);

            System.out.println("Se entrego " + carta + " a jugador : " + j);
            mazoCartas.remove(indice);
        }
    }

    /**
     * Metodo que recibe todas las cartas de todos los jugadores y las agrega al mazo nuevamente
     */
    private void recibirCartasJugadores() {
        mazoCartas.addAll(Arrays.asList( jugadorUno.entregarCargas() ));
        mazoCartas.addAll(Arrays.asList( jugadorDos.entregarCargas() ));
    }


    private void mostrarMazoCustom() {
        for (Carta c : mazoCartas) {
            System.out.println(c);
        }
    }
}
