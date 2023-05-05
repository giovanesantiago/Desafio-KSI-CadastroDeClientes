package br.com.ksi.DesafioKSICadastroDeClientes.service;

import br.com.ksi.DesafioKSICadastroDeClientes.model.Cliente;
import br.com.ksi.DesafioKSICadastroDeClientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    // Cadastrar Cliente
    public String create(Cliente cliente) {
        clienteRepository.save(cliente);
        return "ok";
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
