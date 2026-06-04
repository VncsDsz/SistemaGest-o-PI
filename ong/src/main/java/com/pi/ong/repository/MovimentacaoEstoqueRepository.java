package com.pi.ong.repository;

import com.pi.ong.model.MovimentacaoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovimentacaoEstoqueRepository extends JpaRepository<MovimentacaoEstoque, Long> {

    List<MovimentacaoEstoque> findByItensEstoqueIdItensEstoque(Long idItensEstoque);
    List<MovimentacaoEstoque> findByTipoMovimentacao(String tipoMovimentacao);
    List<MovimentacaoEstoque> findByDataMovimentacaoBetween(LocalDateTime inicio, LocalDateTime fim);
}
