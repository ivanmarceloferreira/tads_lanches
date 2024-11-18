package br.grupointegrado.lanches.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "pedido_produto")
public class PedidoProduto {

    @EmbeddedId
    private PedidoProdutoPK id;

    @ManyToOne
    @MapsId("pedidoId")
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    private Pedido pedido;

    @ManyToOne
    @MapsId("produtoId")
    @JoinColumn(name = "produto_id", referencedColumnName = "id")
    @JsonIgnoreProperties("ingredientes")
    private Produto produto;

    @Column(name = "valor")
    private BigDecimal valorUnitario;

    @Column
    private BigDecimal quantidade;

    public PedidoProdutoPK getId() {
        return id;
    }

    public void setId(PedidoProdutoPK id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }
}
