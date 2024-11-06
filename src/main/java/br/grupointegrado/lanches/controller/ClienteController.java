package br.grupointegrado.lanches.controller;

import br.grupointegrado.lanches.dto.ClienteRequestDTO;
import br.grupointegrado.lanches.model.Cliente;
import br.grupointegrado.lanches.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public List<Cliente> findAll() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
    }

    @PostMapping
    public Cliente save(@RequestBody ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        cliente.setTelefone(dto.telefone());

        return this.repository.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable Integer id,
                          @RequestBody ClienteRequestDTO dto) {
        Cliente cliente = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        cliente.setTelefone(dto.telefone());

        return this.repository.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        Cliente cliente = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        this.repository.delete(cliente);
    }

}
