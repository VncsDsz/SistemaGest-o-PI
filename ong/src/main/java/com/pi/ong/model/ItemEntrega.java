package com.pi.ong.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item_entrega")
public class ItemEntrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_entrega")
    private Long idItemEntrega;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "fk_id_entrega", nullable = false)
    private Entrega entrega;

    @ManyToOne
    @JoinColumn(name = "fk_id_itens_estoque", nullable = false)
    private ItensEstoque itensEstoque;

    public ItemEntrega() {}

    public ItemEntrega(Long idItemEntrega, LocalDateTime data, String descricao,
                       Entrega entrega, ItensEstoque itensEstoque) {
        this.idItemEntrega = idItemEntrega;
        this.data = data;
        this.descricao = descricao;
        this.entrega = entrega;
        this.itensEstoque = itensEstoque;
    }

    public Long getIdItemEntrega() { return idItemEntrega; }
    public void setIdItemEntrega(Long idItemEntrega) { this.idItemEntrega = idItemEntrega; }

    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Entrega getEntrega() { return entrega; }
    public void setEntrega(Entrega entrega) { this.entrega = entrega; }

    public ItensEstoque getItensEstoque() { return itensEstoque; }
    public void setItensEstoque(ItensEstoque itensEstoque) { this.itensEstoque = itensEstoque; }
}
