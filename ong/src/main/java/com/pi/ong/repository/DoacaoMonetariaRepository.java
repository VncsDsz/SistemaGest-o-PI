package com.pi.ong.repository;

import com.pi.ong.model.DoacaoMonetaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoacaoMonetariaRepository extends JpaRepository<DoacaoMonetaria, Long> {

    List<DoacaoMonetaria> findByFormaPagamento(String formaPagamento);
    List<DoacaoMonetaria> findByDoacaoCampanhaIdDoacaoCampanha(Long idDoacaoCampanha);
}
