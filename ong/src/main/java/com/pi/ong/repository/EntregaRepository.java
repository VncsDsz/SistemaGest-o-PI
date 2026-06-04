package com.pi.ong.repository;

import com.pi.ong.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {

    List<Entrega> findByBeneficiariaIdBeneficiaria(Long idBeneficiaria);
    List<Entrega> findByResponsavelEntrega(String responsavelEntrega);
    List<Entrega> findByDataBetween(LocalDateTime inicio, LocalDateTime fim);
}
