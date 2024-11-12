package br.grupointegrado.lanches.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 250)
    private String nome;

    @Column(precision = 2)
    private BigDecimal valor;

    @Column
    private String descricao;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("produto")
    private List<Ingrediente> ingredientes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        if (this.ingredientes == null) {
            this.ingredientes = new ArrayList<>();
        }
        this.ingredientes = ingredientes;
    }
}
