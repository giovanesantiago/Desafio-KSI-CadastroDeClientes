package br.com.ksi.DesafioKSICadastroDeClientes.service;

public class Validar {

    public Boolean nome(String info) {

        String nome = info.replace(" ", ""); // Removendo espaço para passar na validação

        if(nome.equals("")) return false; // Validado vazio
        if(nome.length() < 3) return false; // valida minimo 3 caracteres
        if(!nome.matches("^[a-zA-Z]*$")) return false; // VErifica se so tem letras

        return true;

    }

    public Boolean cpf(String info) {

    }

}
