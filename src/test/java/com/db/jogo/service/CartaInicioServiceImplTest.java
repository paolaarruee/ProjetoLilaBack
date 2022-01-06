package com.db.jogo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.db.jogo.controller.BaralhoController;
import com.db.jogo.model.Baralho;
import com.db.jogo.model.CartaInicio;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@DisplayName("Carta Inicio Service Teste")
public class CartaInicioServiceImplTest {
	
	@Mock
    private CartaInicioServiceImpl cartaInicioServiceImpl;

    CartaInicio ci = CartaInicio.builder().nome("Normal").descricao("É uma carta normal").build();

    @DisplayName("Teste do SAVE do Service de uma Carta Ínicio")
    @Test
    void saveBaralho() {
       when(cartaInicioServiceImpl.saveCartaInicio(ci)).thenReturn(ci);
       assertEquals(ci, cartaInicioServiceImpl.saveCartaInicio(ci));
    }

}
