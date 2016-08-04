package com.me.truco.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.me.truco.util.Utileria.ingresoEnteroTeclado;

/**
 *
 * Created by FacundoTaramasco on 2/8/2016.
 */
public class Truco {

    private List<Carta> mazoCartas                    = new ArrayList<Carta>();
    private final Map<Carta, Integer> jerarquiaCartas = new HashMap<Carta, Integer>();

    private Jugador jugadorUno;
    private Jugador jugadorDos;

    private Jugador jugadorTurnoActual;

    private boolean estadoJuego;

    private boolean envidoProcesado = false;
    private boolean envidoEnvidoProcesado = false;

    // Constructor
    public Truco() {
        init();
    }

    /**
     * Metodo que inicializa el juego
     */
    private void init() {

        jugadorUno = new Jugador("Facu");
        jugadorDos = new Jugador("IA");

        jugadorTurnoActual = jugadorUno;

        menu();
        /*
        System.out.println("%%% INICIANDO JUEGO %%%");
        System.out.println("Generando mazo...");
        this.generarMazo();

        System.out.println("Mazo generado : ");
        this.mostrarMazoCustom();
        System.out.println("*******************************************************\n");

        System.out.println("Estableciendo jerarquia de cartas...");
        this.establecerJerarquiaCartas();
        System.out.println("Jerarquia de cartas : ");
        this.mostrarJerarquiaCartas();
        System.out.println("*******************************************************\n");

        System.out.println("Abarajando mazo...");
        this.abarajarMazo();
        System.out.println("Mazo abarajado : ");
        this.mostrarMazoCustom();
        System.out.println("*******************************************************\n");



        System.out.println("Jugadores : ");
        System.out.println(jugadorUno);
        System.out.println(jugadorDos);
        System.out.println("*******************************************************\n");
        */
    }


    private void menuInicialPrimeraRonda() {
        boolean e = true;
        Integer opcion;
        System.out.println("Comienza jugando : " + jugadorTurnoActual);
        String menuStr = "1. Cantar envido. \n" +
                         "2. Jugar carta.   \n" +
                         "3. Salir.         \n";
        do {
        while ((opcion = ingresoEnteroTeclado(menuStr)) == null);
            switch (opcion) {
                case 1 :
                    System.out.println("cantaron envido");
                    jugadorTurnoActual.setEnvido(true);
                    jugadorTurnoActual = (jugadorTurnoActual == jugadorUno ? jugadorDos : jugadorUno);
                    menuPrimeraRonda();
                    break;
                case 2:
                    System.out.println("Juga una carta");
                    jugadorTurnoActual = (jugadorTurnoActual == jugadorUno ? jugadorDos : jugadorUno);
                    break;
                case 3:
                    System.out.println("jaja cagon");
                    e = false;
            }
        } while(e);
    }


    private void menuPrimeraRonda() {
        boolean estTurno = true;
        boolean primeraRoda = true;
        Integer opcion;


        while (primeraRoda) {

            estTurno = true;

            if (jugadorTurnoActual == jugadorUno) {
                System.out.println("LE TOCA A JUGADOR UNO");
                if (!envidoProcesado && jugadorDos.getEnvido()) { // jugador dos canto envido
                    String menuStr = "\n1. Aceptar envido. \n" +
                            "2. Cantar envido envido.  \n" +
                            "3. Cantar real envido.  \n" +
                            "4. Cantar falta envido.  \n" +
                            "5. NO ACEPTAR envido.  \n" +
                            "6. Salir.         \n";

                    do {
                        while ((opcion = ingresoEnteroTeclado( menuStr)) == null);
                        switch (opcion) {
                            case 1 :
                                System.out.println("jugador uno acepto envido");
                                //jugadorTurnoActual.setEnvido(true);
                                jugadorTurnoActual = jugadorDos;
                                envidoProcesado = true;
                                estTurno = false;
                                break;
                            /*
                            case 2:
                                System.out.println("envido envido");
                                jugadorTurnoActual.setEnvidoEnvido(true);
                                jugadorTurnoActual = jugadorDos;
                                break;
                            case 3:
                                System.out.println("real envido");
                                jugadorTurnoActual.setRealEnvido(true);
                                jugadorTurnoActual = jugadorDos;
                                break;
                            case 4:
                                System.out.println("falta envido");
                                jugadorTurnoActual.setFaltaEnvido(true);
                                jugadorTurnoActual = jugadorDos;
                                break;
                            case 5:
                                System.out.println("jugador uno rechazo envido");
                                jugadorTurnoActual = jugadorDos;
                                break;
                            case 6:
                                System.out.println("jugador uni se fue al mazo");
                            */
                        }
                    } while(estTurno);
                }


            }


            if (jugadorTurnoActual == jugadorDos) {
                System.out.println("LE TOCA A JUGADOR DOS");
                if (!envidoProcesado && jugadorUno.getEnvido()) { // jugador uno canto envido

                    String menuStr = "\n1. Aceptar envido. \n" +
                            "2. Cantar envido envido.  \n" +
                            "3. Cantar real envido.  \n" +
                            "4. Cantar falta envido.  \n" +
                            "5. NO ACEPTAR envido.  \n" +
                            "6. Salir.         \n";

                    do {
                        while ((opcion = ingresoEnteroTeclado( menuStr)) == null);
                        switch (opcion) {
                            case 1 :
                                System.out.println("jugador dos acepto envido");
                                jugadorTurnoActual.setEnvido(true);
                                envidoProcesado = true;
                                jugadorTurnoActual = jugadorUno;
                                estTurno = false;
                                break;
                            /*
                            case 2:
                                System.out.println("envido envido");
                                jugadorDos.setEnvidoEnvido(true);
                                jugadorTurnoActual = jugadorUno;
                                envidoEnvidoProcesado = true;
                                estTurno = false;
                                break;
                            case 3:
                                System.out.println("real envido");
                                jugadorTurnoActual.setRealEnvido(true);
                                jugadorTurnoActual = jugadorUno;
                                break;
                            case 4:
                                System.out.println("falta envido");
                                jugadorTurnoActual.setFaltaEnvido(true);
                                jugadorTurnoActual = jugadorUno;
                                break;
                            case 5:
                                System.out.println("jugador dos rechazo envido");
                                jugadorTurnoActual = jugadorUno;
                                break;
                            case 6:
                                System.out.println("jugador dos se fue al mazo");
                            */
                        }
                    } while(estTurno);
                }
            }
        }


    }

    private void menu() {

        menuInicialPrimeraRonda();
    }

    /**
     * A jugar!
     */
    public void jugar() {
        estadoJuego = true;

        System.out.println("Entregando cartas a los jugadores...");
        this.darCartasJugador(jugadorUno);
        this.darCartasJugador(jugadorDos);

        System.out.println("Recibiendo cartas de todos los jugadores...");

        this.recibirCartasJugadores();
        this.mostrarMazoCustom();

        /*
        while (estadoJuego) {


        // si son dos jugadores :


        cantar : envido, real envido, falta envido

        responder : aceptar alguno de los anteriores, envido envido, real envido, falta envido




        1 ronda

            primer jugador puede :
                - cantar envido
                    - si el segundo jugador acepto :
                    - aceptar el envido, cantar envido envido, cantar real envido, aceptar falta envido, rechazar

                - jugar la primera ronda



            segundo jugador puede :

                - cantar envido si el primer jugador no lo dijo
                    - aceptar real envido, cantar falta envido

                - aceptar el envido, cantar envido envido, cantar real envido, aceptar falta envido

                - jugar la primera ronda

        2 ronda

            primer jugador puede :
                - cantar truco
                - jugar la segunda ronda (debe ganarla si perdio la primera)

            segundo jugador puede :
                - cantar truco
                - jugar la segunda ronda (debe ganarla si perdio la primera)




        }
        */
    }

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

        jerarquiaCartas.put( mazoCartas.get(30), 1 ); // 1 espada
        jerarquiaCartas.put( mazoCartas.get(20), 2 ); // 1 basto
        jerarquiaCartas.put( mazoCartas.get(36), 3 ); // 7 espada
        jerarquiaCartas.put( mazoCartas.get(16), 4 ); // 7 oro

        // todos los 3
        for (Carta c : mazoCartas)
            if ( c.getValor().getValor() == 3)  jerarquiaCartas.put(c, 5);
        // todos los 2
        for (Carta c : mazoCartas)
            if ( c.getValor().getValor() == 2) jerarquiaCartas.put(c, 6);
        // todos los 1 (menos el de espada y basto)
        for (Carta c : mazoCartas)
            if ( c.getValor().getValor() == 1 && c.getPalo() != Palos.BASTO && c.getPalo() != Palos.ESPADA) jerarquiaCartas.put(c, 7);
        // todos los 12
        for (Carta c : mazoCartas)
            if ( c.getValor().getValor() == 12) jerarquiaCartas.put(c, 8);
        // todos los 11
        for (Carta c : mazoCartas)
            if ( c.getValor().getValor() == 11) jerarquiaCartas.put(c, 9);
        // todos los 10
        for (Carta c : mazoCartas)
            if ( c.getValor().getValor() == 10) jerarquiaCartas.put(c, 10);
        // todos los 7 (menos el de espada y oro)
        for (Carta c : mazoCartas)
            if ( c.getValor().getValor() == 7 && c.getPalo() != Palos.ESPADA && c.getPalo() != Palos.ORO) jerarquiaCartas.put(c, 11);
        // todos los 6
        for (Carta c : mazoCartas)
            if ( c.getValor().getValor() == 6) jerarquiaCartas.put(c, 12);
        // todos los 5
        for (Carta c : mazoCartas)
            if ( c.getValor().getValor() == 5) jerarquiaCartas.put(c, 13);
        // todos los 4
        for (Carta c : mazoCartas)
            if ( c.getValor().getValor() == 4) jerarquiaCartas.put(c,14);
    }

    /**
     * Metodo que abaraja el mazo (lo desordena)
     */
    public void abarajarMazo() {
        Collections.shuffle(mazoCartas);
    }

    /**
     * Metodo que le entrega ITruco.CARTASXJUGADOR cartas random del mazo al jugador especificado.
     * @param j Jugador que recibe las cartas.
     */
    private void darCartasJugador(Jugador j) {
        Random r = new Random();
        Carta carta;
        int indice;
        for (int i = 0; i < ITruco.CARTASXJUGADOR; i++) {
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

    private void mostrarJerarquiaCartas() {
        Iterator it = jerarquiaCartas.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
