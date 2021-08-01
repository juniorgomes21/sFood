package com.sfood.dto;

import com.sfood.models.Restaurantes;
import com.sfood.models.StatusRestaurantes;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class RequisicaoNovoRestaurante {
    @NotNull
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("24.0")
    private int horarioDeInicio;
    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("24.0")
    private int horarioDeEncerramento;
    private StatusRestaurantes statusRestaurantes;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public Restaurantes toRestaurante() {
        Restaurantes restaurantes = new Restaurantes();
        restaurantes.setNome(this.nome);
        restaurantes.setDescricao(this.descricao);
        restaurantes.setHorarioDeInicio(this.horarioDeInicio);
        restaurantes.setHorarioDeEncerramento(this.horarioDeEncerramento);
        restaurantes.setStatusRestaurantes(this.statusRestaurantes);

        return restaurantes;
    }

    public Restaurantes toRestaurante(Restaurantes restaurantes) {
        restaurantes.setNome(this.nome);
        restaurantes.setDescricao(this.descricao);
        restaurantes.setHorarioDeInicio(this.horarioDeInicio);
        restaurantes.setHorarioDeEncerramento(this.horarioDeEncerramento);

        return restaurantes;
    }

    public void fromRestaaurante(Restaurantes restaurantes) {
        this.nome = restaurantes.getNome();
        this.descricao = restaurantes.getDescricao();
        this.horarioDeInicio = restaurantes.getHorarioDeInicio();
        this.horarioDeEncerramento = restaurantes.getHorarioDeEncerramento();
    }

    @Override
    public String toString() {
        return "RequisicaoNovoRestaurante{" +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", horarioDeInicio=" + horarioDeInicio +
                ", horarioDeEncerramento=" + horarioDeEncerramento +
                ", statusRestaurantes=" + statusRestaurantes +
                '}';
    }
}
