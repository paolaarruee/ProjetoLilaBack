package com.db.jogo.controller;

import com.db.jogo.model.Categoria;
import com.db.jogo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria categoria, BindingResult bindingResult) {
        if (bindingResult.hasErrors() || categoria.getNome() == null) {
            return new ResponseEntity<Categoria>(categoria, HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity<Categoria>(categoriaService.saveCategoria(categoria), HttpStatus.CREATED);
        }

        @RequestMapping(method = RequestMethod.GET, produces = "application/json")
        public ResponseEntity<Iterable<Categoria>> findCategoria () {
            return new ResponseEntity<Iterable<Categoria>>(categoriaService.findAll(), HttpStatus.OK);
        }
    }
