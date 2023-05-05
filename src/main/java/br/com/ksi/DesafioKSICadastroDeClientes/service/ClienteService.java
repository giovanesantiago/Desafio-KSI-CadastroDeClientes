package br.com.ksi.DesafioKSICadastroDeClientes.service;

import br.com.ksi.DesafioKSICadastroDeClientes.model.Cliente;
import br.com.ksi.DesafioKSICadastroDeClientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    // Cadastrar Cliente
    public String create(Cliente cliente) {
        clienteRepository.save(cliente);
        return "ok";
    }

}
