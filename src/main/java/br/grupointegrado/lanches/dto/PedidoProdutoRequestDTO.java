package br.grupointegrado.lanches.dto;

import java.math.BigDecimal;

public record PedidoProdutoRequestDTO(
        Integer produtoId,
        BigDecimal quantidade,
        BigDecimal valorUnitario
) {
}
