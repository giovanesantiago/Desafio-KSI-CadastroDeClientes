package br.com.ksi.DesafioKSICadastroDeClientes.controller;

import br.com.ksi.DesafioKSICadastroDeClientes.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    // Rota para Abrir tela de cadastro
    @GetMapping("/create")
    public String home(){
        return "create";
    }

    @PostMapping("/create")
    public void create(Cliente cliente) {
        System.out.println("O nome da cliente é : " + cliente.getNome()
                + " Ele aceitou os termos : " + cliente.getTermosPoliticas());
    }
}
