package com.pi.ong.repository;

import com.pi.ong.model.AtendimentoProfissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface
AtendimentoProfissionalRepository
        extends JpaRepository<
        AtendimentoProfissional,
        Long> {

    List<AtendimentoProfissional>
    findByStatus(Boolean status);

    List<AtendimentoProfissional>
    findByTipoAtendimento(
            String tipoAtendimento);
}