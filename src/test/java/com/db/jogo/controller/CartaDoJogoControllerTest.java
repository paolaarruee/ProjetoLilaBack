package com.db.jogo.controller;

import com.db.jogo.model.Baralho;
import com.db.jogo.model.CartaDoJogo;
import com.db.jogo.service.BaralhoServiceImpl;
import com.db.jogo.service.CartaDoJogoServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CartaDoJogoControllerTest {

    @WebAppConfiguration
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @WebMvcTest(CartaDoJogoController.class)
    @DisplayName("Carta Do Jogo Controller Teste")
    class BaralhoControllerTest {

        @Autowired
        MockMvc mockMvc;

        @MockBean
        CartaDoJogoServiceImpl cartaDoJogoService;

        @Test
        @DisplayName("Teste do POST do Controller do Baralho")
        public void testCriacaoCartaDoJogo() throws Exception {
            CartaDoJogo newCartaDoJogo = CartaDoJogo.builder().bonus(true)
                    .valorCorGrande(1)
                    .valorCorPequeno(0)
                    .categoria("Fisica")
                    .fonte("Google")
                    .tipo("Informação")
                    .pontos(3)
                    .texto("Teste")
                    .build();

            ObjectMapper mapper = new ObjectMapper();

            String newCartaDoJogoAsJSON = mapper.writeValueAsString(newCartaDoJogo);
            this.mockMvc.perform(post("/baralho").content(newCartaDoJogoAsJSON).accept(MediaType.APPLICATION_JSON_VALUE)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isCreated());
        }


    }
}
