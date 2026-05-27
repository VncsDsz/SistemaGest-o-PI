package com.pi.ong.repository;

import com.pi.ong.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfissionalRepository
        extends JpaRepository<Profissional, Long> {

    // Busca pelo nome exato
    List<Profissional> findByNome(
            String nome);

    // Busca nome contendo termo
    List<Profissional>
    findByNomeContaining(
            String termo);

    // Busca por especialidade
    List<Profissional>
    findByEspecialidade(
            String especialidade);
}