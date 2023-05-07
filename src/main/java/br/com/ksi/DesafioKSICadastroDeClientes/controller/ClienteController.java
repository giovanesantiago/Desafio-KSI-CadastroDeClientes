package br.com.ksi.DesafioKSICadastroDeClientes.controller;

import br.com.ksi.DesafioKSICadastroDeClientes.dto.ClienteDTO;
import br.com.ksi.DesafioKSICadastroDeClientes.dto.JsonRetorno;
import br.com.ksi.DesafioKSICadastroDeClientes.model.Cliente;
import br.com.ksi.DesafioKSICadastroDeClientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;

@Controller
public class ClienteController {

    // Criei uma classe Service para poder organizar as Validações e regras de negocios
    // de saida e entrada antes do repository
    @Autowired
    ClienteService clienteService;

    // ROTAS

    // Rota para abrir painel como a pagina inicial
    @GetMapping("/")
    public String homeHTML(){
        return "redirect:/painel";
    }

    // Rota para Abrir tela de cadastro
    @GetMapping("/create")
    public ModelAndView createHTML(){
        ModelAndView mv = new ModelAndView("create");
        // retornando um ModelAndView com um Cliente vazio, pois o Thymeleaf espera um objeto no HTML
        mv.addObject("cliente", new Cliente());
        return mv;
    }

    // Rota para Abrir painel de clientes
    @GetMapping("/painel")
    public ModelAndView painelHTML() {
        // ModelAndView para mapear e retornar atributos para o HTML
        ModelAndView mv = new ModelAndView("painel");
        // Lista com todos os clientes encotrados pelo service no banco
        List<Cliente> clienteList = clienteService.findAll();
        // Adicionando Lista no Model e retornando para exibir os clientes no front
        mv.addObject("clienteList", clienteList);
        return mv;
    }

    // Rota para Abrir edição de clientes
    @GetMapping("/edit/{id}")
    public ModelAndView editHTML(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("edit");
        // Cliente encotrado pelo service atraves do id
        Cliente clienteFind = clienteService.findById(id);
        // Mudando o modelo do cliente para edição por conta da formatação da data
        ClienteDTO clienteDTO = new ClienteDTO(clienteFind.getId(), clienteFind.getNome(), clienteFind.getCpf(),
                clienteFind.getDataNascimento(), clienteFind.getTermosPoliticas());
        // Retornando ModelAndView com os dados do cliente para ser editado
        mv.addObject("cliente", clienteDTO);
        return mv;
    }


    // Metodos de manipulação de dados

    // Metodo para cadastro de cliente
    @PostMapping("/create")
    public ModelAndView create(ClienteDTO clienteDTO) {
        // Chamando Service para criar novo cliente
        return clienteService.create(clienteDTO);
    }

    // Metodo para editar cliente
    @PostMapping("/edit")
    public ModelAndView edit(ClienteDTO clienteDTO) {
        // Chamando Service para editar cliente
        return clienteService.edit(clienteDTO);
    }

    // Metodo para Excluir cliente
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        // Chamando service para excluir
        clienteService.delete(id);
        return "redirect:/painel"; // Recaregando painel sem o cliente deletado
    }

    // Metodo para chamada JSON
    @GetMapping("/json")
    public ResponseEntity<JsonRetorno> retornoJson() {
        List<String> accepted = new ArrayList<>();
        List<String> rejected = new ArrayList<>();
        String google = "Google Pixel 2 XL (8.1.0)";
        accepted.add(google);
        JsonRetorno jsonRetorno = new JsonRetorno(accepted, rejected);
        return ResponseEntity.ok(jsonRetorno);
    }

}
