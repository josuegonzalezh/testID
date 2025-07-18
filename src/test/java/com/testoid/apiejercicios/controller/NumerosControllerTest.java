package com.testoid.apiejercicios.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testoid.apiejercicios.dto.NumerosRequest;
import com.testoid.apiejercicios.service.EjerciciosService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(NumerosController.class)

class NumerosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EjerciciosService ejerciciosService;

    @Autowired
    private ObjectMapper mapper;

    // ========================= SEGUNDO EJERCICIO =============================

    //acciones verdaderas
    @Test
    void testEncontrarMayor1() throws Exception {
        NumerosRequest numerosRequest = new NumerosRequest();
        numerosRequest.setNumeros(Arrays.asList(10, 5, 20, 8));

        mockMvc.perform(post("/api/numeros/mayor")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(numerosRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensaje")
                        .value("El número mayor del arreglo [10, 5, 20, 8] es: 20"));
    }

    @Test
    void testEncontrarMayor2() throws Exception {
        NumerosRequest numerosRequest = new NumerosRequest();
        numerosRequest.setNumeros(Arrays.asList(-1, -5, -2));

        mockMvc.perform(post("/api/numeros/mayor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(numerosRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensaje")
                        .value("El número mayor del arreglo [-1, -5, -2] es: -1"));
    }

    //acciones falsas
    @Test
    void testEncontrarMayorNull() throws Exception {
        NumerosRequest numerosRequest = new NumerosRequest();
        numerosRequest.setNumeros(null);

        mockMvc.perform(post("/api/numeros/mayor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(numerosRequest)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testEncontrarMayorEmpty() throws Exception {
        NumerosRequest numerosRequest = new NumerosRequest();
        numerosRequest.setNumeros(List.of());

        mockMvc.perform(post("/api/numeros/mayor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(numerosRequest)))
                .andExpect(status().isBadRequest());
    }


    // ========================= TERCER EJERCICIO =============================

    //acciones verdaderas
    @Test
    void testFiltrarNumerosPares1 () throws Exception {
        NumerosRequest numerosRequest = new NumerosRequest();
        numerosRequest.setNumeros(List.of(1, 2, 3, 4, 5));

        mockMvc.perform(post("/api/numeros/pares")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(numerosRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensaje")
                        .value("Los números pares encontrados son: [2, 4]"));
    }

    @Test
    void testFiltrarNumerosPares2 () throws Exception {
        NumerosRequest numerosRequest = new NumerosRequest();
        numerosRequest.setNumeros(List.of(7, 9, 11));

        mockMvc.perform(post("/api/numeros/pares")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(numerosRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensaje")
                        .value("Los números pares encontrados son: []"));
    }


    //acciones falsas
    @Test
    void testFiltrarNumerosParesNull  () throws Exception {
        NumerosRequest numerosRequest = new NumerosRequest();
        numerosRequest.setNumeros(null);

        mockMvc.perform(post("/api/numeros/pares")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(numerosRequest)))
                .andExpect(status().isBadRequest());
    }

}