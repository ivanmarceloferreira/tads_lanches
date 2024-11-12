package br.grupointegrado.lanches.controller;

import br.grupointegrado.lanches.model.Ingrediente;
import br.grupointegrado.lanches.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteRepository repository;

    @GetMapping
    public ResponseEntity<List<Ingrediente>> findAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Ingrediente> save(@RequestBody String descricao) {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setDescricao(descricao);
        this.repository.save(ingrediente);

        return ResponseEntity.ok(ingrediente);
    }

}
