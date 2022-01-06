package com.db.jogo.service;


import com.db.jogo.model.CartaDoJogo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Carta Do Jogo Service Teste")
class CartaDoJogoServiceImplTest {

    @Mock
    private CartaDoJogoServiceImpl cartaDoJogoServiceImpl;

    CartaDoJogo cartaDoJogo = CartaDoJogo.builder().bonus(true)
            .valorCorGrande(1).valorCorPequeno(0)
            .categoria("Fisica")
            .fonte("Google")
            .tipo("Informação")
            .pontos(3)
            .texto("Teste")
            .build();

    @DisplayName("Teste do SAVE do Service de uma Carta Do Jogo")
    @Test
    void saveCartaDoJogo() {
        when(cartaDoJogoServiceImpl.saveCartaDoJogo(cartaDoJogo)).thenReturn(cartaDoJogo);
        assertEquals(cartaDoJogo, cartaDoJogoServiceImpl.saveCartaDoJogo(cartaDoJogo));
    }

}