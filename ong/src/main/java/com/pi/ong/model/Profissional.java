package com.pi.ong.model;

import jakarta.persistence.*;

@Entity
@Table(name = "profissionais")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profissional")
    private Long idProfissional;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 50)
    private String especialidade;

    public Profissional() {
    }

    public Profissional(
            Long idProfissional,
            String nome,
            String especialidade) {

        this.idProfissional = idProfissional;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    //gets e sets
    public Long getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(Long idProfissional) {
        this.idProfissional = idProfissional;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(
            String especialidade) {

        this.especialidade = especialidade;
    }
}