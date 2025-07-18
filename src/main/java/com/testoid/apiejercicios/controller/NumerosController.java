package com.testoid.apiejercicios.controller;

import com.testoid.apiejercicios.dto.*;
import com.testoid.apiejercicios.service.EjerciciosService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/numeros")
public class NumerosController {

    private final EjerciciosService service;

    public NumerosController(EjerciciosService service) {
        this.service = service;
    }

    @PostMapping("/mayor")
    public NumerosResponse encontrarMayor(@RequestBody NumerosRequest request) {
        if (request.getNumeros() == null || request.getNumeros().isEmpty()) {
            throw new IllegalArgumentException("La lista no puede estar vacía.");
        }

        int[] arreglo = request.getNumeros().stream()
                .mapToInt(Integer::intValue)
                .toArray();

        int mayor = service.encontrarMayor(arreglo);
        return new NumerosResponse("El número mayor del arreglo " + request.getNumeros() + " es: " + mayor);
    }


    @PostMapping("/pares")
    public NumerosResponse filtrarPares(@RequestBody NumerosRequest request) {
        if (request.getNumeros() == null || request.getNumeros().isEmpty()) {
            throw new IllegalArgumentException("¡¡La lista no puede estar vacía!!");
        }

        var pares = service.filtrarNumerosPares(request.getNumeros());
        String mensaje = "Los números pares encontrados son: " + pares;
        return new NumerosResponse(mensaje);
    }
}
