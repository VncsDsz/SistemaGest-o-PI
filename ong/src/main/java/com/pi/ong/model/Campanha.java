package com.pi.ong.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "campanha")
public class Campanha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_campanha")
    private Long idCampanha;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(name = "meta_doacoes", nullable = false, precision = 12, scale = 2)
    private BigDecimal metaDoacoes;

    public Campanha() {}

    public Campanha(Long idCampanha, String titulo, BigDecimal metaDoacoes) {
        this.idCampanha = idCampanha;
        this.titulo = titulo;
        this.metaDoacoes = metaDoacoes;
    }

    public Long getIdCampanha() { return idCampanha; }
    public void setIdCampanha(Long idCampanha) { this.idCampanha = idCampanha; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public BigDecimal getMetaDoacoes() { return metaDoacoes; }
    public void setMetaDoacoes(BigDecimal metaDoacoes) { this.metaDoacoes = metaDoacoes; }
}
