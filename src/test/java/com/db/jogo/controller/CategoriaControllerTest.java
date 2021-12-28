package com.db.jogo.controller;


import com.db.jogo.model.Categoria;
import com.db.jogo.service.CategoriaServicelmpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@WebMvcTest(BaralhoController.class)
@DisplayName("Categoria Controller Teste")
public class CategoriaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CategoriaServicelmpl categoriaService;

    @Test
    @DisplayName("teste do Post do ontroller da Categoria")
    public void testCriacaoCategoria() throws Exception {
        Categoria newCategoria = Categoria.builder().nome("Fisica")
                .build();
        ObjectMapper mapper = new ObjectMapper();

        String newCategoriaAsJSON = mapper.writeValueAsString(newCategoria);
        this.mockMvc.perform(post("/baralho").content(newCategoriaAsJSON).accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isCreated());
    }

}
