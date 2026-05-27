package com.pi.ong.model;

import jakarta.persistence.*;

@Entity
@Table(name = "voluntarias")
public class Voluntaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voluntaria")
    private Long idVoluntaria;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 11)
    private String telefone;

    @Column(nullable = false,
            unique = true,
            length = 40)
    private String email;

    @Column(name = "profissao_ocupacao",
            nullable = false,
            length = 50)
    private String profissaoOcupacao;

    @Column(name = "habilidades_interesses",
            nullable = false,
            columnDefinition = "TEXT")
    private String habilidadesInteresses;

    @Column(nullable = false, length = 15)
    private String disponibilidade;

    @Column(nullable = false)
    private Boolean status;

    public Voluntaria() {
    }

    public Voluntaria(
            Long idVoluntaria,
            String nome,
            String telefone,
            String email,
            String profissaoOcupacao,
            String habilidadesInteresses,
            String disponibilidade,
            Boolean status) {

        this.idVoluntaria = idVoluntaria;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.profissaoOcupacao =
                profissaoOcupacao;
        this.habilidadesInteresses =
                habilidadesInteresses;
        this.disponibilidade =
                disponibilidade;
        this.status = status;
    }

    //gets e sets
    public Long getIdVoluntaria() {
        return idVoluntaria;
    }

    public void setIdVoluntaria(
            Long idVoluntaria) {

        this.idVoluntaria =
                idVoluntaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(
            String nome) {

        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(
            String telefone) {

        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(
            String email) {

        this.email = email;
    }

    public String getProfissaoOcupacao() {
        return profissaoOcupacao;
    }

    public void setProfissaoOcupacao(
            String profissaoOcupacao) {

        this.profissaoOcupacao =
                profissaoOcupacao;
    }

    public String
    getHabilidadesInteresses() {

        return habilidadesInteresses;
    }

    public void
    setHabilidadesInteresses(
            String habilidadesInteresses) {

        this.habilidadesInteresses =
                habilidadesInteresses;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(
            String disponibilidade) {

        this.disponibilidade =
                disponibilidade;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(
            Boolean status) {

        this.status = status;
    }
}