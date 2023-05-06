package br.com.ksi.DesafioKSICadastroDeClientes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String nome;

    private String cpf;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;

    private Boolean termosPoliticas;

    public Cliente(Long id, String nome, String cpf, Date dataNascimento, Boolean termosPoliticas) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.termosPoliticas = termosPoliticas;
    }

    public Cliente(String nome, String cpf, Date dataNascimento, Boolean termosPoliticas) {
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
