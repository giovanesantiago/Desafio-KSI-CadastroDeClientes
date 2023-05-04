package br.com.ksi.DesafioKSICadastroDeClientes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {

    @GetMapping("/create")
    public String create(){
        return "create";
    }
}
