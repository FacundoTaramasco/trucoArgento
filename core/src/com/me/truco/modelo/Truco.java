package com.me.truco.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FacundoTaramasco on 2/8/2016.
 */
public class Truco {


    private List<Carta> mazoCartas;

    public Truco() {
        mazoCartas = new ArrayList<Carta>();

        this.generarMazo();

        System.out.println(mazoCartas);
    }





    // Customs
    private void generarMazo() {
        for (Palos p : Palos.values()) { // COPA, ORO, BASTO, ESPADA
            for (NumeroCarta n : NumeroCarta.values()) {  // UNO DOS TRES CUATRO CINCO SEIS SIETE DIEZ ONCE DOCE
                mazoCartas.add(new Carta(p, n));
            }
        }


    }



}
