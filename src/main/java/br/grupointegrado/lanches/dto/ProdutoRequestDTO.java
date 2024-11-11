package br.grupointegrado.lanches.dto;

import java.math.BigDecimal;

public record ProdutoRequestDTO(String nome, BigDecimal valor, String descricao) {
}
