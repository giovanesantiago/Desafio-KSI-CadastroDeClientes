package br.com.ksi.DesafioKSICadastroDeClientes.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ClienteDTO {
    private String nome;
    private String cpf;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;
    private Boolean termosPoliticas;

    public ClienteDTO( String nome, String cpf, Date dataNascimento, Boolean termosPoliticas) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.termosPoliticas = termosPoliticas;
    }

    public ClienteDTO() {
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
