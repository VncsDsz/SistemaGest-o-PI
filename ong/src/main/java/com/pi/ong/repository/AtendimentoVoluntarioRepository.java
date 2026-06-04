package com.pi.ong.repository;

import com.pi.ong.model.AtendimentoVoluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AtendimentoVoluntarioRepository extends JpaRepository<AtendimentoVoluntario, Long> {

    List<AtendimentoVoluntario> findByBeneficiariaIdBeneficiaria(Long idBeneficiaria);
    List<AtendimentoVoluntario> findByVoluntariaIdVoluntaria(Long idVoluntaria);
    List<AtendimentoVoluntario> findByTipoAtendimento(String tipoAtendimento);
    List<AtendimentoVoluntario> findByDataBetween(LocalDateTime inicio, LocalDateTime fim);
}
