package com.me.truco.modelo;

import java.util.Arrays;

/**
 * Clase que representa un jugador, el cual tiene un nombre y un maximo de ITruco.CARTASXJUGADOR cartas.
 * Created by FacundoTaramasco on 2/08/16.
 */
public class Jugador {

    private String nombre;

    private Carta[] cartas = new Carta[ITruco.CARTASXJUGADOR];

    private int indiceCarta = 0;

    // Constructor

    public Jugador() {
        this("");
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    // Getters
    public String getNombre() { return nombre; }

    public Carta[] getCartas() { return cartas; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }


    // Customs

    public void recibirCarta( Carta cartaDelMazo) {
        if (indiceCarta == ITruco.CARTASXJUGADOR) return;
        cartas[indiceCarta] = cartaDelMazo;
        indiceCarta++;
    }

    public Carta[] entregarCargas() {
        Carta[] tmp = this.getCartas();
        this.cartas = null;
        indiceCarta = 0;
        return tmp;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", cartas=" + Arrays.toString(cartas) +
                '}';
    }
}
