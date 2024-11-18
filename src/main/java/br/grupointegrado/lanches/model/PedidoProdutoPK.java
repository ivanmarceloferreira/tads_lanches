package br.grupointegrado.lanches.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PedidoProdutoPK {

    @Column(name = "pedido_id")
    private Integer pedidoId;

    @Column(name = "produto_id")
    private Integer produtoId;

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }
}
