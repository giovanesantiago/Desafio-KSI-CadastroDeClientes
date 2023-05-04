package br.com.ksi.DesafioKSICadastroDeClientes.model;

import java.util.Date;

public class Cliente {

    private Long id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private Boolean termosPoliticas;

    public Cliente(Long id, String nome, String cpf, Date dataNascimento, Boolean termosPoliticas) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.termosPoliticas = termosPoliticas;
    }

    public Cliente() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getTermosPoliticas() {
        return termosPoliticas;
    }

    public void setTermosPoliticas(Boolean termosPoliticas) {
        this.termosPoliticas = termosPoliticas;
    }
}
