package br.com.ksi.DesafioKSICadastroDeClientes.service;

import java.util.Date;

public class Validar {

    public Boolean nome(String info) {

        String nome = info.replace(" ", ""); // Removendo espaço para passar na validação

        if(nome.equals("")) return false; // Validado vazio
        if(nome.length() < 3) return false; // valida minimo 3 caracteres
        if(!nome.matches("^[a-zA-Z]*$")) return false; // Verifica se so tem letras

        return true;

    }

    public Boolean cpf(String info) {
        String CPF = info.replaceAll("[\\D]", "");

        // Essa parte do codigo eu pesquei na internet =( **
        if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") ||
                CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888") ||
                CPF.equals("99999999999") || (CPF.length() != 11))
            return (false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        sm = 0;
        peso = 10;
        for (i = 0; i < 9; i++) {
            // converte o i-esimo caractere do CPF em um numero:
            // por exemplo, transforma o caractere '0' no inteiro 0
            // (48 eh a posicao de '0' na tabela ASCII)
            num = (int) (CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig10 = '0';
        else
            dig10 = (char) (r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
        sm = 0;
        peso = 11;
        for (i = 0; i < 10; i++) {
            num = (int) (CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig11 = '0';
        else
            dig11 = (char) (r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
        if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
            return (true);
        else
            return (false);


        // Aqui acabou a pesca **

    }

    public Boolean nascimento(Date info) {

        Date dataAtual = new Date();


        if(info == null) return false; // Valida vazio
        if(dataAtual.getYear() - info.getYear() < 10) return false; // Valida menor de 10 anos
        if(dataAtual.getYear() - info.getYear() > 100) return false; // Valida maior que 100 anos

        return true;

    }

    public Boolean termos(Boolean info) {

        if (info == null) return false;
        if (!info) return false;

        return true;
    }

}
