package com.testoid.apiejercicios.controller;

import com.testoid.apiejercicios.dto.TextRequest;
import com.testoid.apiejercicios.dto.VocalesResponse;
import com.testoid.apiejercicios.service.EjerciciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vocales")
public class VocalesController {

    //@Autowired
    private EjerciciosService ejerciciosService;

    @PostMapping("/contar")
    public VocalesResponse contarVocales(@RequestBody TextRequest request) {
        String texto = request.getTexto();
        int total = ejerciciosService.contarVocales(texto);
        String mensaje = "La cadena '" + texto + "' tiene " + total + " vocales";
        return new VocalesResponse(mensaje);
    }
}
