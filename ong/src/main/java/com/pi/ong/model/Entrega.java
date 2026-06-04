package com.pi.ong.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "entrega")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrega")
    private Long idEntrega;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "responsavel_entrega", nullable = false, length = 30)
    private String responsavelEntrega;

    @ManyToOne
    @JoinColumn(name = "fk_id_beneficiaria", nullable = false)
    private Beneficiaria beneficiaria;

    public Entrega() {}

    public Entrega(Long idEntrega, LocalDateTime data, String descricao,
                   String responsavelEntrega, Beneficiaria beneficiaria) {
        this.idEntrega = idEntrega;
        this.data = data;
        this.descricao = descricao;
        this.responsavelEntrega = responsavelEntrega;
        this.beneficiaria = beneficiaria;
    }

    public Long getIdEntrega() { return idEntrega; }
    public void setIdEntrega(Long idEntrega) { this.idEntrega = idEntrega; }

    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getResponsavelEntrega() { return responsavelEntrega; }
    public void setResponsavelEntrega(String responsavelEntrega) { this.responsavelEntrega = responsavelEntrega; }

    public Beneficiaria getBeneficiaria() { return beneficiaria; }
    public void setBeneficiaria(Beneficiaria beneficiaria) { this.beneficiaria = beneficiaria; }
}
