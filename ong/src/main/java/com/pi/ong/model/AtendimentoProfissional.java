package com.pi.ong.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "atendimento_profissional")
public class AtendimentoProfissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atendimento")
    private Long idAtendimento;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(name = "tipo_atendimento",
            nullable = false,
            length = 50)
    private String tipoAtendimento;

    @Column(nullable = false)
    private Boolean status;

    @ManyToOne
    @JoinColumn(
            name = "fk_id_beneficiaria",
            nullable = false)
    private Beneficiaria beneficiaria;

    @ManyToOne
    @JoinColumn(
            name = "fk_id_profissional",
            nullable = false)
    private Profissional profissional;

    public AtendimentoProfissional() {
    }

    public AtendimentoProfissional(
            Long idAtendimento,
            LocalDateTime data,
            String tipoAtendimento,
            Boolean status,
            Beneficiaria beneficiaria,
            Profissional profissional) {

        this.idAtendimento = idAtendimento;
        this.data = data;
        this.tipoAtendimento = tipoAtendimento;
        this.status = status;
        this.beneficiaria = beneficiaria;
        this.profissional = profissional;
    }

    //gets e sets
    public Long getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(
            Long idAtendimento) {

        this.idAtendimento = idAtendimento;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(
            LocalDateTime data) {

        this.data = data;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(
            String tipoAtendimento) {

        this.tipoAtendimento =
                tipoAtendimento;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(
            Boolean status) {

        this.status = status;
    }

    public Beneficiaria
    getBeneficiaria() {

        return beneficiaria;
    }

    public void setBeneficiaria(
            Beneficiaria beneficiaria) {

        this.beneficiaria =
                beneficiaria;
    }

    public Profissional
    getProfissional() {

        return profissional;
    }

    public void setProfissional(
            Profissional profissional) {

        this.profissional =
                profissional;
    }
}