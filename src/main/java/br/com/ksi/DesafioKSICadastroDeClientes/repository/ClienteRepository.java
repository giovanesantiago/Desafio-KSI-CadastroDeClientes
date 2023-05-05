package br.com.ksi.DesafioKSICadastroDeClientes.repository;

import br.com.ksi.DesafioKSICadastroDeClientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
