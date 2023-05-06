package br.com.ksi.DesafioKSICadastroDeClientes.service;

import br.com.ksi.DesafioKSICadastroDeClientes.model.Cliente;
import br.com.ksi.DesafioKSICadastroDeClientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;


    Validar validar = new Validar();

    // Cadastrar Cliente
    public ModelAndView create(Cliente cliente) {
        ModelAndView mv = new ModelAndView();
        List<String> mensagens = new ArrayList<>();

        if(!validar.nome(cliente.getNome())) {
            mv.setViewName("create");
            mensagens.add("Nome invalido");
            mv.addObject("cliente", cliente);
            mv.addObject("msg", mensagens);
        }else {
            clienteRepository.save(cliente);
            mv.setViewName("confirmacaoCadastro");
        }


        return mv;
    }

    // Lista todos
    public List<Cliente> findAll() {
        List<Cliente> clienteList = clienteRepository.findAll();
        return clienteList;
    }

    // Lista um cliente
    public Cliente findById(Long id) {
        Cliente clienteFind = clienteRepository.findById(id).get();
        return clienteFind;
    }

    public String edit(Cliente clienteNovo) {
        Cliente clienteFind = findById(clienteNovo.getId());

        if(clienteFind.getId() == clienteNovo.getId()) {
            if(clienteFind.getTermosPoliticas() != null) {
                clienteNovo.setTermosPoliticas(true);
            }
            create(clienteNovo);
        }
        return "ok";
    }

    public String delete(Long id) {
        clienteRepository.deleteById(id);
        return "ok";
    }





}
