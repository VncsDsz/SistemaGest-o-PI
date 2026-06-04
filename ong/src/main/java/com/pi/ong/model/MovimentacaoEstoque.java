package com.pi.ong.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimentacao_estoque")
public class MovimentacaoEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimentacao_estoque")
    private Long idMovimentacaoEstoque;

    @Column(name = "data_movimentacao", nullable = false)
    private LocalDateTime dataMovimentacao;

    @Column(name = "tipo_movimentacao", nullable = false, length = 20)
    private String tipoMovimentacao;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private Integer saldo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "fk_id_itens_estoque", nullable = false)
    private ItensEstoque itensEstoque;

    public MovimentacaoEstoque() {}

    public MovimentacaoEstoque(Long idMovimentacaoEstoque, LocalDateTime dataMovimentacao,
                               String tipoMovimentacao, Integer quantidade, Integer saldo,
                               String descricao, ItensEstoque itensEstoque) {
        this.idMovimentacaoEstoque = idMovimentacaoEstoque;
        this.dataMovimentacao = dataMovimentacao;
        this.tipoMovimentacao = tipoMovimentacao;
        this.quantidade = quantidade;
        this.saldo = saldo;
        this.descricao = descricao;
        this.itensEstoque = itensEstoque;
    }

    public Long getIdMovimentacaoEstoque() { return idMovimentacaoEstoque; }
    public void setIdMovimentacaoEstoque(Long idMovimentacaoEstoque) { this.idMovimentacaoEstoque = idMovimentacaoEstoque; }

    public LocalDateTime getDataMovimentacao() { return dataMovimentacao; }
    public void setDataMovimentacao(LocalDateTime dataMovimentacao) { this.dataMovimentacao = dataMovimentacao; }

    public String getTipoMovimentacao() { return tipoMovimentacao; }
    public void setTipoMovimentacao(String tipoMovimentacao) { this.tipoMovimentacao = tipoMovimentacao; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public Integer getSaldo() { return saldo; }
    public void setSaldo(Integer saldo) { this.saldo = saldo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public ItensEstoque getItensEstoque() { return itensEstoque; }
    public void setItensEstoque(ItensEstoque itensEstoque) { this.itensEstoque = itensEstoque; }
}
