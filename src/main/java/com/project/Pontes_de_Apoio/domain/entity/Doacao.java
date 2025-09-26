package com.project.Pontes_de_Apoio.domain.entity;

import java.time.LocalDateTime;

public class Doacao {
    private Long id;
    private final Doador doador ;
    private final double valorDoado;
    private final LocalDateTime data;

    private Doacao(Doador doador, double valorDoado, LocalDateTime data) {
        this.doador = doador;
        this.valorDoado = valorDoado;
        this.data = data;
    }

    public static Doacao create( Doador doador, double valorDoado) {
        if(doador == null) {
            throw new IllegalArgumentException("Doador é obrigatório");
        }
        if(valorDoado <= 0) {
            throw new IllegalArgumentException("Valor da doação deve ser maior que zero");
        }
        return new Doacao(doador,valorDoado, LocalDateTime.now());
    }

    public Long getId() {
        return id;
    }

    public Doador getDoador() {
        return doador;
    }

    public double getValorDoado() {
        return valorDoado;
    }

    public LocalDateTime getData() {
        return data;
    }
}
