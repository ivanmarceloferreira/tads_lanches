package br.grupointegrado.lanches.controller;

import br.grupointegrado.lanches.dto.ClienteRequestDTO;
import br.grupointegrado.lanches.model.Cliente;
import br.grupointegrado.lanches.model.Endereco;
import br.grupointegrado.lanches.model.Favorito;
import br.grupointegrado.lanches.model.Produto;
import br.grupointegrado.lanches.repository.ClienteRepository;
import br.grupointegrado.lanches.repository.EnderecoRepository;
import br.grupointegrado.lanches.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
//        return this.repository.findAll();
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
//        return this.repository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        Cliente cliente = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        return ResponseEntity.ok(cliente);
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
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Cliente cliente = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        this.repository.delete(cliente);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/add-endereco")
    public ResponseEntity<Cliente> addEndereco(@PathVariable Integer id,
                                               @RequestBody Endereco endereco) {
        Cliente cliente = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        endereco.setCliente(cliente);
        this.enderecoRepository.save(endereco);

        return ResponseEntity.ok(cliente);
    }

    @PostMapping("/{id}/add-favorito")
    public ResponseEntity<Cliente> addProdutoFavorito(@PathVariable Integer id,
                                                      @RequestBody Integer produtoId) {

        Cliente cliente = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        Produto produto = this.produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));


        Favorito favorito = new Favorito();
        favorito.setCliente(cliente);
        favorito.setProduto(produto);

        if (!cliente.getFavoritos().isEmpty() &&
                !cliente.getFavoritos().contains(favorito)) {
            cliente.addFavorito(favorito);
            this.repository.save(cliente);
        }

        return ResponseEntity.ok(cliente);
    }

}
