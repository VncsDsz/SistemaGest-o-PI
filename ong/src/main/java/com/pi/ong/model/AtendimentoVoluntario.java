package com.pi.ong.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "atendimento_voluntario")
public class AtendimentoVoluntario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atendimento_voluntario")
    private Long idAtendimentoVoluntario;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(name = "tipo_atendimento", nullable = false, length = 50)
    private String tipoAtendimento;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "fk_id_beneficiaria", nullable = false)
    private Beneficiaria beneficiaria;

    @ManyToOne
    @JoinColumn(name = "fk_id_voluntaria", nullable = false)
    private Voluntaria voluntaria;

    public AtendimentoVoluntario() {}

    public AtendimentoVoluntario(Long idAtendimentoVoluntario, LocalDateTime data,
                                  String tipoAtendimento, String descricao,
                                  Beneficiaria beneficiaria, Voluntaria voluntaria) {
        this.idAtendimentoVoluntario = idAtendimentoVoluntario;
        this.data = data;
        this.tipoAtendimento = tipoAtendimento;
        this.descricao = descricao;
        this.beneficiaria = beneficiaria;
        this.voluntaria = voluntaria;
    }

    public Long getIdAtendimentoVoluntario() { return idAtendimentoVoluntario; }
    public void setIdAtendimentoVoluntario(Long idAtendimentoVoluntario) { this.idAtendimentoVoluntario = idAtendimentoVoluntario; }

    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }

    public String getTipoAtendimento() { return tipoAtendimento; }
    public void setTipoAtendimento(String tipoAtendimento) { this.tipoAtendimento = tipoAtendimento; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Beneficiaria getBeneficiaria() { return beneficiaria; }
    public void setBeneficiaria(Beneficiaria beneficiaria) { this.beneficiaria = beneficiaria; }

    public Voluntaria getVoluntaria() { return voluntaria; }
    public void setVoluntaria(Voluntaria voluntaria) { this.voluntaria = voluntaria; }
}
