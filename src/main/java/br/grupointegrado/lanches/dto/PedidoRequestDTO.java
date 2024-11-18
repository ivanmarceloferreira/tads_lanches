package br.grupointegrado.lanches.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record PedidoRequestDTO(
        Integer clienteId,
        LocalDate dataPedido,
        BigDecimal valorTotal,
        List<PedidoProdutoRequestDTO> produtos
) {
}
