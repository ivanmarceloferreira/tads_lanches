package br.grupointegrado.lanches.repository;

import br.grupointegrado.lanches.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
