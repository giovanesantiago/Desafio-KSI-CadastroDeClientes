package br.com.ksi.DesafioKSICadastroDeClientes.service;

public class Validar {

    public Boolean nome(String info) {

        if(info.equals("")) return false;
        if(info.length() < 3) return false;
        if(info.matches("[0-9]")) return false;
        if(info.matches("[.!@#$%^~&*()+]")) return false;

        return true;

    }

}
