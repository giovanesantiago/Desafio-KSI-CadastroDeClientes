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
    ClienteRepository clienteRepository; // Classe para conexão e manipulação de dados do banco


    Validar validar = new Validar(); // Classe para validar dados

    // Cadastrar Cliente
    public ModelAndView create(ClienteDTO clienteDTO) {
        ModelAndView mv = new ModelAndView();
        // Lista de mensagem de dados invalidos para exibir no HTML
        List<String> mensagens = new ArrayList<>();

        // Validações
        if(!validar.nome(clienteDTO.getNome())) mensagens.add("Nome invalido"); // caso invalido add mensagem da lista
        if (!validar.cpf(clienteDTO.getCpf())) mensagens.add("CPF invalido");
        if (!validar.nascimento(clienteDTO.getDataNascimento())) mensagens.add("Data de Nascimento invalida");
        if (!validar.termos(clienteDTO.getTermosPoliticas())) mensagens.add("É necessario ler e aceitar os termos");


        if(mensagens.size() >= 1) {// Se a lista não tiver vazia siginifica que algum item não passou na validação
            mv.setViewName("create"); // Seta nome da view para continuar na pag de cadastro
            mv.addObject("msg", mensagens); // add lista de mensagens para sinalizar o que não passou
            mv.addObject("cliente", clienteDTO); // devolve os dados a pagina para corrgir
        }else { // Caso lista vazia todos os dados ok
            // Criando novo cliente para gerar um novo id
            Cliente cliente = new Cliente(clienteDTO.getNome(), clienteDTO.getCpf(),
                    clienteDTO.getDataNascimento(), clienteDTO.getTermosPoliticas());
            // Usando o Modelo ClienteDTO so para mudança de formatado de data
            clienteRepository.save(cliente); // enviado dados para o banco
            mv.setViewName("confirmacaoCadastro"); // ViewName para confirmar cadastro do novo cliente
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

    public ModelAndView edit(ClienteDTO clienteDTO) { // Regra de Validação igual do create
        ModelAndView mv = new ModelAndView();
        List<String> mensagens = new ArrayList<>();

        if(!validar.nome(clienteDTO.getNome())) mensagens.add("Nome invalido");
        if (!validar.cpf(clienteDTO.getCpf())) mensagens.add("CPF invalido");
        if (!validar.nascimento(clienteDTO.getDataNascimento())) mensagens.add("Data de Nascimento invalida");

        Cliente clienteFind = findById(clienteDTO.getId()); // Buscando cliente no Banco de dados

        if(clienteFind.getId() == clienteDTO.getId()) { // confirmando ID para evitar falha
            if(mensagens.size() >= 1) {
                mv.setViewName("edit");
                mv.addObject("msg", mensagens);
                mv.addObject("cliente", clienteDTO);
            }else {
                // Setando valores novos clienteFind para evitar gerar um novo id e criar ao invez de editar
                clienteFind.setNome(clienteDTO.getNome());
                clienteFind.setCpf(clienteDTO.getCpf());
                clienteFind.setDataNascimento(clienteDTO.getDataNascimento());
                clienteRepository.save(clienteFind);
                mv.setViewName("confirmacaoCadastro");
            }

        }
        return mv;
    }

    // Deletando Cliente
    public String delete(Long id) {
        clienteRepository.deleteById(id);
        return "ok";
    }



}
