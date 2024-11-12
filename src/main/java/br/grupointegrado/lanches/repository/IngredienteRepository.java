package br.grupointegrado.lanches.repository;

import br.grupointegrado.lanches.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
}
