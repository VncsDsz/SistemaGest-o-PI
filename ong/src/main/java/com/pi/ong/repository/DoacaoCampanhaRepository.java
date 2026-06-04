package com.pi.ong.repository;

import com.pi.ong.model.DoacaoCampanha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DoacaoCampanhaRepository extends JpaRepository<DoacaoCampanha, Long> {

    List<DoacaoCampanha> findByDoadorIdDoador(Long idDoador);
    List<DoacaoCampanha> findByCampanhaIdCampanha(Long idCampanha);
    List<DoacaoCampanha> findByTipoDoacao(String tipoDoacao);
    List<DoacaoCampanha> findByDataBetween(LocalDateTime inicio, LocalDateTime fim);
}
