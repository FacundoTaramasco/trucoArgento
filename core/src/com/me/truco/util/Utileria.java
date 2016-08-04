package com.me.truco.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by martin on 3/08/16.
 */
public class Utileria {


    private static Scanner entrada = new Scanner(System.in);

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Integer ingresoEnteroTeclado(String msj) {
        Integer i;
        System.out.println(msj);
        try {
            i = Integer.parseInt(br.readLine());
        } catch (IOException ioe) {
            i = null;
        } catch (NumberFormatException nfe) {
            i = null;
        }
        return i;
    }
}
