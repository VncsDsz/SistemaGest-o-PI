package com.pi.ong.model;

import jakarta.persistence.*;

@Entity
@Table(name = "itens_estoque")
public class ItensEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_itens_estoque")
    private Long idItensEstoque;

    @Column(name = "categoria_produto", nullable = false, length = 100)
    private String categoriaProduto;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false)
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "fk_id_doacao_produto", nullable = false)
    private DoacaoProduto doacaoProduto;

    public ItensEstoque() {}

    public ItensEstoque(Long idItensEstoque, String categoriaProduto,
                        String descricao, Integer quantidade, DoacaoProduto doacaoProduto) {
        this.idItensEstoque = idItensEstoque;
        this.categoriaProduto = categoriaProduto;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.doacaoProduto = doacaoProduto;
    }

    public Long getIdItensEstoque() { return idItensEstoque; }
    public void setIdItensEstoque(Long idItensEstoque) { this.idItensEstoque = idItensEstoque; }

    public String getCategoriaProduto() { return categoriaProduto; }
    public void setCategoriaProduto(String categoriaProduto) { this.categoriaProduto = categoriaProduto; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public DoacaoProduto getDoacaoProduto() { return doacaoProduto; }
    public void setDoacaoProduto(DoacaoProduto doacaoProduto) { this.doacaoProduto = doacaoProduto; }
}
