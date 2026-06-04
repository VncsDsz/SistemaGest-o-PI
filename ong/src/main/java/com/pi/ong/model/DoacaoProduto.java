package com.pi.ong.model;

import jakarta.persistence.*;

@Entity
@Table(name = "doacao_produto")
public class DoacaoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doacao_produto")
    private Long idDoacaoProduto;

    @Column(name = "categoria_produto", nullable = false, length = 100)
    private String categoriaProduto;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "fk_id_doacao_campanha", nullable = false)
    private DoacaoCampanha doacaoCampanha;

    public DoacaoProduto() {}

    public DoacaoProduto(Long idDoacaoProduto, String categoriaProduto,
                         Integer quantidade, String descricao, DoacaoCampanha doacaoCampanha) {
        this.idDoacaoProduto = idDoacaoProduto;
        this.categoriaProduto = categoriaProduto;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.doacaoCampanha = doacaoCampanha;
    }

    public Long getIdDoacaoProduto() { return idDoacaoProduto; }
    public void setIdDoacaoProduto(Long idDoacaoProduto) { this.idDoacaoProduto = idDoacaoProduto; }

    public String getCategoriaProduto() { return categoriaProduto; }
    public void setCategoriaProduto(String categoriaProduto) { this.categoriaProduto = categoriaProduto; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public DoacaoCampanha getDoacaoCampanha() { return doacaoCampanha; }
    public void setDoacaoCampanha(DoacaoCampanha doacaoCampanha) { this.doacaoCampanha = doacaoCampanha; }
}
