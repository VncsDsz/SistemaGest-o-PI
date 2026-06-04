package com.pi.ong.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "doacao_monetaria")
public class DoacaoMonetaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doacao_monetaria")
    private Long idDoacaoMonetaria;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal valor;

    @Column(name = "forma_pagamento", nullable = false, length = 50)
    private String formaPagamento;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "fk_id_doacao_campanha", nullable = false)
    private DoacaoCampanha doacaoCampanha;

    public DoacaoMonetaria() {}

    public DoacaoMonetaria(Long idDoacaoMonetaria, BigDecimal valor,
                           String formaPagamento, String descricao, DoacaoCampanha doacaoCampanha) {
        this.idDoacaoMonetaria = idDoacaoMonetaria;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.descricao = descricao;
        this.doacaoCampanha = doacaoCampanha;
    }

    public Long getIdDoacaoMonetaria() { return idDoacaoMonetaria; }
    public void setIdDoacaoMonetaria(Long idDoacaoMonetaria) { this.idDoacaoMonetaria = idDoacaoMonetaria; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public DoacaoCampanha getDoacaoCampanha() { return doacaoCampanha; }
    public void setDoacaoCampanha(DoacaoCampanha doacaoCampanha) { this.doacaoCampanha = doacaoCampanha; }
}
