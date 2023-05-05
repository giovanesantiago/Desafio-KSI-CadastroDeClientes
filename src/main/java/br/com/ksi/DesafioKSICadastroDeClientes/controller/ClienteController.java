package br.com.ksi.DesafioKSICadastroDeClientes.controller;

import br.com.ksi.DesafioKSICadastroDeClientes.model.Cliente;
import br.com.ksi.DesafioKSICadastroDeClientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    // Rota para Abrir tela de cadastro
    @GetMapping("/create")
    public String homeHTML(){
        return "create";
    }

    // Rota para Abrir painel de clientes
    @GetMapping("/painel")
    public ModelAndView painelHTML() {
        // ModelAndView para mapear e retornar atributos para o HTML
        ModelAndView mv = new ModelAndView("painel");
        List<Cliente> clienteList = clienteService.findAll();
        mv.addObject("clienteList", clienteList);
        return mv;
    }

    // Rota para Abrir edição de clientes
    @GetMapping("/edit/{id}")
    public ModelAndView editHTML(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("edit");
        // Procurando cliente
        Cliente clienteFind = clienteService.findById(id);
        mv.addObject("cliente", clienteFind);
        return mv;
    }

    // Metodo para cadastro de cliente
    @PostMapping("/create")
    public String create(Cliente cliente) {

        clienteService.create(cliente);

        return "confirmacaoCadastro"; // Abrir tela de confirmação de cadastro
    }

    // Metodo para editar cliente
    @PostMapping("/edit")
    public String edit(Cliente clienteNovo) {

        clienteService.edit(clienteNovo);

        return "redirect:/painel";
    }

    // Metodo para Excluir cliente
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){


        return "redirect:/painel";
    }

}
