package com.pi.ong.repository;

import com.pi.ong.model.Doador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoadorRepository extends JpaRepository<Doador, Long> {

    Doador findByCpfCnpj(String cpfCnpj);
    List<Doador> findByNomeRazaoSocialContaining(String nome);
    List<Doador> findByStatus(Boolean status);
    List<Doador> findByTipoPfPj(String tipoPfPj);
}
