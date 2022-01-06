package com.db.jogo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.db.jogo.model.CartaInicio;
import com.db.jogo.service.BaralhoServiceImpl;
import com.db.jogo.service.CartaInicioServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@WebMvcTest(CartaInicioController.class)
@DisplayName("Carta Inicio Controller Teste")
public class CartaInicioControllerTest {

	
	@Autowired
	MockMvc mockMvc;

	@MockBean
	CartaInicioServiceImpl cartaInicioService;
	
	@Test
	@DisplayName("Teste do POST do Controller de carta inicio")
	public void testaPost() throws Exception
	{
		CartaInicio cartaInicio = CartaInicio.builder().nome("Normal").descricao("É uma carta normal").build();
	
		ObjectMapper mapper = new ObjectMapper();
		
		String newCartaInicioAsJSON = mapper.writeValueAsString(cartaInicio);
		
		this.mockMvc.perform(post("/cartaInicio").content(newCartaInicioAsJSON).accept(MediaType.APPLICATION_JSON_VALUE)
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isCreated());
	
	}
	
	
	
}
