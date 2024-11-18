package br.grupointegrado.lanches.controller;

import br.grupointegrado.lanches.dto.PedidoRequestDTO;
import br.grupointegrado.lanches.model.*;
import br.grupointegrado.lanches.repository.ClienteRepository;
import br.grupointegrado.lanches.repository.PedidoRepository;
import br.grupointegrado.lanches.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository repository;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody PedidoRequestDTO dto) {

        Cliente cliente = this.clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataPedido(dto.dataPedido());
        pedido.setValorTotal(dto.valorTotal());

        // produtos
        dto.produtos().forEach(p -> {
            Produto produto = this.produtoRepository.findById(p.produtoId())
                    .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

            PedidoProdutoPK pk = new PedidoProdutoPK();
            pk.setPedidoId(pedido.getId());
            pk.setProdutoId(produto.getId());

            PedidoProduto pedidoProduto = new PedidoProduto();
            pedidoProduto.setId(pk);
            pedidoProduto.setQuantidade(p.quantidade());
            pedidoProduto.setValorUnitario(p.valorUnitario());

            pedidoProduto.setPedido(pedido);
            pedidoProduto.setProduto(produto);

            pedido.addPedidoProduto(pedidoProduto);
        });

        this.repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }

}
