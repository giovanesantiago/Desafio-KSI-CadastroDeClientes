package br.com.ksi.DesafioKSICadastroDeClientes.controller;

import br.com.ksi.DesafioKSICadastroDeClientes.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClienteController {

    // Lista de clientes temporaria para testes antes de integrar Banco de dados
    List<Cliente> clienteList = new ArrayList<>();

    // Rota para Abrir tela de cadastro
    @GetMapping("/create")
    public String home(){
        return "create";
    }
    // Rota para Abrir painel de clientes
    @GetMapping("/painel")
    public ModelAndView painel() {
        ModelAndView mv = new ModelAndView("painel");
        mv.addObject("clienteList", clienteList);
        return mv;
    }

    // Metodo para cadastro de cliente
    @PostMapping("/create")
    public String create(Cliente cliente) {
        Long id = clienteList.size() + 1L;
        cliente.setId(id);
        clienteList.add(cliente);

        return "confirmacaoCadastro";
    }
}
