package com.pi.ong.model;

import jakarta.persistence.*;

@Entity
@Table(name = "doador")
public class Doador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doador")
    private Long idDoador;

    @Column(name = "nome_razaosocial", nullable = false, length = 100)
    private String nomeRazaoSocial;

    @Column(name = "cpf_cnpj", nullable = false, length = 11, unique = true)
    private String cpfCnpj;

    @Column(nullable = false, length = 11)
    private String telefone;

    @Column(nullable = false, length = 40)
    private String email;

    @Column(name = "tipo_PF_PJ", nullable = false, length = 2)
    private String tipoPfPj;

    @Column(nullable = false)
    private Boolean status;

    public Doador() {}

    public Doador(Long idDoador, String nomeRazaoSocial, String cpfCnpj,
                  String telefone, String email, String tipoPfPj, Boolean status) {
        this.idDoador = idDoador;
        this.nomeRazaoSocial = nomeRazaoSocial;
        this.cpfCnpj = cpfCnpj;
        this.telefone = telefone;
        this.email = email;
        this.tipoPfPj = tipoPfPj;
        this.status = status;
    }

    public Long getIdDoador() { return idDoador; }
    public void setIdDoador(Long idDoador) { this.idDoador = idDoador; }

    public String getNomeRazaoSocial() { return nomeRazaoSocial; }
    public void setNomeRazaoSocial(String nomeRazaoSocial) { this.nomeRazaoSocial = nomeRazaoSocial; }

    public String getCpfCnpj() { return cpfCnpj; }
    public void setCpfCnpj(String cpfCnpj) { this.cpfCnpj = cpfCnpj; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTipoPfPj() { return tipoPfPj; }
    public void setTipoPfPj(String tipoPfPj) { this.tipoPfPj = tipoPfPj; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
}
