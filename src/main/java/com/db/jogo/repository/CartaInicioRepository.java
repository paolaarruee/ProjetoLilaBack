package com.db.jogo.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.db.jogo.model.CartaInicio;
import com.db.jogo.model.CartaObjetivo;

public interface CartaInicioRepository  extends CrudRepository<CartaInicio, UUID>{

}
