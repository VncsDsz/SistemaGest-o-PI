package com.pi.ong.repository;

import com.pi.ong.model.Voluntaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoluntariaRepository
        extends JpaRepository<
        Voluntaria,
        Long> {

    List<Voluntaria>
    findByNome(String nome);

    List<Voluntaria>
    findByNomeContaining(
            String termo);

    Voluntaria
    findByEmail(String email);

    List<Voluntaria>
    findByDisponibilidade(
            String disponibilidade);

    List<Voluntaria>
    findByStatus(
            Boolean status);
}