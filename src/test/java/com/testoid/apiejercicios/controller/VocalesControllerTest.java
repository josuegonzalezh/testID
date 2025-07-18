package com.testoid.apiejercicios.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testoid.apiejercicios.dto.TextRequest;
import com.testoid.apiejercicios.service.EjerciciosService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VocalesController.class)
class VocalesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EjerciciosService ejerciciosService;

    @Autowired
    private ObjectMapper mapper;

    // ========================= PRIMER EJERCICIO =============================

    //acciones verdaderas
    @Test
    void testContarVocales1() throws Exception {
        TextRequest textRequest = new TextRequest();
        textRequest.setTexto("Hola Mundo");
        mockMvc.perform(post("/api/vocales/contar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(textRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensaje")
                        .value("La cadena 'Hola Mundo' tiene 4 vocales"));
    }

    @Test
    void testContarVocales2() throws Exception {
        TextRequest textRequest = new TextRequest();
        textRequest.setTexto("Hola Mundo");
        mockMvc.perform(post("/api/vocales/contar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(textRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensaje")
                        .value("La cadena 'Hola Mundo' tiene 4 vocales"));
    }

    //acciones falsas
    @Test
    void testContarVocalesNull() throws Exception {
        TextRequest textRequest = new TextRequest();
        textRequest.setTexto(null);

        mockMvc.perform(post("/api/vocales/contar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(textRequest)))
                .andExpect(status().isBadRequest());
    }

    //acciones falsas
    @Test
    void testContarVocalesEmpty() throws Exception {
        TextRequest textRequest = new TextRequest();
        textRequest.setTexto("");

        mockMvc.perform(post("/api/vocales/contar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(textRequest)))
                .andExpect(status().isBadRequest());
    }
}