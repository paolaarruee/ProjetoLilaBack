package com.db.jogo.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class CartaDoJogo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "baralho_id_codigo")
    private Baralho baralho;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "bonus", nullable = false)
    private Boolean bonus;

    @Column(name = "texto", nullable = false)
    private String texto;

    @Column(name = "valorCorPequeno", nullable = true)
    private Integer valorCorPequeno;

    @Column(name = "valorCorGrande", nullable = true)
    private Integer valorCorGrande;

    @Column(name = "fonte", nullable = false)
    private String fonte;

    @Column(name="pontos", nullable= false)
    private  Integer pontos;

}