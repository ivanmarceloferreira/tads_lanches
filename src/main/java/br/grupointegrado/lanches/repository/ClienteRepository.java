package br.grupointegrado.lanches.repository;

import br.grupointegrado.lanches.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
