package com.project.Pontes_de_Apoio.domain.entity;

import java.util.List;


public class Doador {
    private Long id;
    private final String nome ;
    private final String email;
    private final String telefone;

    private Doador(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public static Doador create(String nome, String email, String telefone) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        if (telefone != null && telefone.length() > 20) {
            throw new IllegalArgumentException("Telefone muito longo");
        }

        return new Doador(nome, email, telefone);
    }

    public Doador mudarEmail(String novoEmail) {
        if(novoEmail == null || novoEmail.isBlank() || !novoEmail.contains("@")) {
            throw new IllegalArgumentException("Novo Email inválido");
        }
        return new Doador(this.nome, novoEmail, this.telefone);
    }

    public Doador mudarTelefone(String novoTelefone) {
        if(novoTelefone == null || novoTelefone.isBlank()) {
            throw new IllegalArgumentException("Novo telefone inválido");
        }
        return new Doador(this.nome, this.email, novoTelefone);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}
