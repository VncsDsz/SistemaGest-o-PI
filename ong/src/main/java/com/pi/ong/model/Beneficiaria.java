package com.pi.ong.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="beneficiarias")
public class Beneficiaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_beneficiaria")
    private Long idBeneficiaria;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 11)
    private String telefone;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false, length = 150)
    private String endereco;

    @Column(nullable = false)
    private Boolean status;

    public Beneficiaria() {
    }

    public Beneficiaria(Long idBeneficiaria,
                        String nome,
                        String telefone,
                        LocalDate dataNascimento,
                        String cpf,
                        String endereco,
                        Boolean status) {

        this.idBeneficiaria = idBeneficiaria;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.endereco = endereco;
        this.status = status;
    }

    //gets e sets
    public Long getIdBeneficiaria() {
        return idBeneficiaria;
    }

    public void setIdBeneficiaria(Long idBeneficiaria) {
        this.idBeneficiaria = idBeneficiaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}