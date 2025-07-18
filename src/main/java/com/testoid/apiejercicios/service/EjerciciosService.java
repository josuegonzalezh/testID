package com.testoid.apiejercicios.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EjerciciosService {

    // --------- PRIMER EJERCICIO ---------
    public static int contarVocales (String palabra) {

        if (palabra == null || palabra.trim().isEmpty()) {
            throw new IllegalArgumentException("La palabra no puede estar vacía");
        }

        int contador = 0;
        palabra = palabra.trim().toUpperCase();

        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            switch (letra) {
                case 'A','E','I','O','U' :
                    contador++;
                    break;
            }
        }

        return contador;
    }


    // --------- SEGUNDO EJERCICIO ---------
    public static int encontrarMayor (int[] numeros) {

        if (numeros == null || numeros.length == 0) {
            throw new IllegalArgumentException("¡¡El arreglo no puede estar vacío!!");
        }

        int mayor = numeros[0];

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }
        }

        return mayor;
    }

    // --------- TERCER EJERCICIO ---------
    public static List<Integer> filtrarNumerosPares(List<Integer> numeros){

        if (numeros == null || numeros.isEmpty()) {
            throw new IllegalArgumentException("¡¡La lista no puede estar vacía!!");
        }

        List<Integer> pares = new ArrayList<>();

        for (int i = 0; i < numeros.size(); i++) {
            if(numeros.get(i) % 2 == 0 ) {
                pares.add(numeros.get(i));
            }
        }

        /* if(pares.isEmpty()){
            throw new IllegalArgumentException("Ningún número par encontrado en la lista " + numeros);
        } */

        return pares;
    }
}
