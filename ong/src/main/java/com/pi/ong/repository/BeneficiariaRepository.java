package com.pi.ong.repository;

import com.pi.ong.model.Beneficiaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BeneficiariaRepository
        extends JpaRepository<Beneficiaria, Long> {
    // findAll(), findById(id), save(entity), delete(entity)
    // existsById(), count()

    // Busca pelo nome exato
    List<Beneficiaria> findByNome(String nome);

    // Busca nome contendo termo
    List<Beneficiaria> findByNomeContaining(String termo);

    // Busca pelo CPF
    Beneficiaria findByCpf(String cpf);

    // Busca beneficiárias ativas/inativas
    List<Beneficiaria> findByStatus(Boolean status);

    // Busca por data de nascimento
    List<Beneficiaria> findByDataNascimento(LocalDate dataNascimento);

    // Busca beneficiárias nascidas após uma data
    List<Beneficiaria> findByDataNascimentoAfter(LocalDate data);

    @Query("SELECT b FROM Beneficiaria b WHERE b.nome LIKE %:nome%")
    List<Beneficiaria> buscaPorNome(@Param("nome") String nome);
}
