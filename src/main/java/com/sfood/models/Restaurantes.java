package com.sfood.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Restaurantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;
    private String descricao;
    @NotNull
    private int horarioDeInicio;
    @NotNull
    private int horarioDeEncerramento;
    @Enumerated(EnumType.STRING)
    private StatusRestaurantes statusRestaurantes;


    public Restaurantes() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorarioDeInicio() {
        return horarioDeInicio;
    }

    public void setHorarioDeInicio(int horarioDeInicio) {
        this.horarioDeInicio = horarioDeInicio;
    }

    public int getHorarioDeEncerramento() {
        return horarioDeEncerramento;
    }

    public void setHorarioDeEncerramento(int horarioDeEncerramento) {
        this.horarioDeEncerramento = horarioDeEncerramento;
    }

    public StatusRestaurantes getStatusRestaurantes() {
        return statusRestaurantes;
    }

    public void setStatusRestaurantes(StatusRestaurantes statusRestaurantes) {
        this.statusRestaurantes = statusRestaurantes;
    }
}
