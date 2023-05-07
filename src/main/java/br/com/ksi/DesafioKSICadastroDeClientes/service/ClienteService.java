package br.com.ksi.DesafioKSICadastroDeClientes.service;

import br.com.ksi.DesafioKSICadastroDeClientes.dto.ClienteDTO;
import br.com.ksi.DesafioKSICadastroDeClientes.model.Cliente;
import br.com.ksi.DesafioKSICadastroDeClientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;


    Validar validar = new Validar();

    // Cadastrar Cliente
    public ModelAndView create(ClienteDTO clienteDTO) {
        ModelAndView mv = new ModelAndView();
        List<String> mensagens = new ArrayList<>();


        if(!validar.nome(clienteDTO.getNome())) mensagens.add("Nome invalido");
        if (!validar.cpf(clienteDTO.getCpf())) mensagens.add("CPF invalido");
        if (!validar.nascimento(clienteDTO.getDataNascimento())) mensagens.add("Data de Nascimento invalida");
        if (!validar.termos(clienteDTO.getTermosPoliticas())) mensagens.add("É necessario ler e aceitar os termos");

        if(mensagens.size() >= 1) {
            mv.setViewName("create");
            mv.addObject("msg", mensagens);
            mv.addObject("cliente", clienteDTO);
        }else {
            Cliente cliente = new Cliente(clienteDTO.getNome(), clienteDTO.getCpf(),
                    clienteDTO.getDataNascimento(), clienteDTO.getTermosPoliticas());
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
            clienteRepository.save(clienteNovo);
        }
        return "ok";
    }

    public String delete(Long id) {
        clienteRepository.deleteById(id);
        return "ok";
    }





}
