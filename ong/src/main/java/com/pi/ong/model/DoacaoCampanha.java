package com.pi.ong.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "doacao_campanha")
public class DoacaoCampanha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doacao_campanha")
    private Long idDoacaoCampanha;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(name = "tipo_doacao", nullable = false, length = 20)
    private String tipoDoacao;

    @Column(name = "valor_total", nullable = false, precision = 12, scale = 2)
    private BigDecimal valorTotal;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "fk_id_doador", nullable = false)
    private Doador doador;

    @ManyToOne
    @JoinColumn(name = "fk_id_campanha", nullable = false)
    private Campanha campanha;

    public DoacaoCampanha() {}

    public DoacaoCampanha(Long idDoacaoCampanha, LocalDateTime data, String tipoDoacao,
                          BigDecimal valorTotal, String descricao, Doador doador, Campanha campanha) {
        this.idDoacaoCampanha = idDoacaoCampanha;
        this.data = data;
        this.tipoDoacao = tipoDoacao;
        this.valorTotal = valorTotal;
        this.descricao = descricao;
        this.doador = doador;
        this.campanha = campanha;
    }

    public Long getIdDoacaoCampanha() { return idDoacaoCampanha; }
    public void setIdDoacaoCampanha(Long idDoacaoCampanha) { this.idDoacaoCampanha = idDoacaoCampanha; }

    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }

    public String getTipoDoacao() { return tipoDoacao; }
    public void setTipoDoacao(String tipoDoacao) { this.tipoDoacao = tipoDoacao; }

    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Doador getDoador() { return doador; }
    public void setDoador(Doador doador) { this.doador = doador; }

    public Campanha getCampanha() { return campanha; }
    public void setCampanha(Campanha campanha) { this.campanha = campanha; }
}
