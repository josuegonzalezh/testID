package com.testoid.apiejercicios.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EjerciciosServiceTest {

    // ======================= PRIMER EJERCICIO =======================

    // acciones verdaderas
    @Test
    void testContarVocales1() {
        int vocales = EjerciciosService.contarVocales("Hola Mundo");
        assertEquals(4,vocales);
    }

    @Test
    void testContarVocales2() {
        int vocales = EjerciciosService.contarVocales("Java");
        assertEquals(2,vocales);
    }

    //acciones falsas
    @Test
    void testContarVocalesNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            EjerciciosService.contarVocales(null);
        });
    }

    @Test
    void testContarVocalesEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            EjerciciosService.contarVocales("");
        });
    }


    // ======================= SEGUNDO EJERCICIO =======================

    // acciones verdaderas
    @Test
    void testEncontrarMayor1() {
        int[] arreglo = {10, 5, 20, 8};
        int mayor = EjerciciosService.encontrarMayor(arreglo);
        assertEquals(20,mayor);
    }

    @Test
    void testEncontrarMayor2() {
        int[] arreglo = {-1, -5, -2};
        int mayor = EjerciciosService.encontrarMayor(arreglo);
        assertEquals(-1,mayor);
    }

    // acciones falsas
    @Test
    void testEncontrarMayorNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            EjerciciosService.encontrarMayor(null);
        });
    }

    @Test
    void testEncontrarMayorEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            EjerciciosService.encontrarMayor(new int[]{});
        });
    }

    // ======================= TERCER EJERCICIO =======================

    // acciones verdaderas
    @Test
    void testFiltrarNumerosPares1() {
        List<Integer> numeros = List.of(1, 2, 3, 4, 5);
        List<Integer> esperados = List.of(2,4);
        List<Integer> pares = EjerciciosService.filtrarNumerosPares(numeros);
        assertEquals(esperados,pares);
    }

    @Test
    void testFiltrarNumerosPares2() {
        List<Integer> numeros = List.of(1, 3, 5);
        List<Integer> esperados = List.of();
        List<Integer> pares = EjerciciosService.filtrarNumerosPares(numeros);
        assertEquals(esperados,pares);
    }

    // acciones falsas
    @Test
    void testFiltrarNumerosParesNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            EjerciciosService.filtrarNumerosPares(null);
        });
    }

    @Test
    void testFiltrarNumerosParesEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            EjerciciosService.filtrarNumerosPares(List.of());
        });
    }
}