package com.pi.ong.repository;

import com.pi.ong.model.ItensEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItensEstoqueRepository extends JpaRepository<ItensEstoque, Long> {

    List<ItensEstoque> findByCategoriaProduto(String categoriaProduto);
    List<ItensEstoque> findByCategoriaProdutoContaining(String termo);
    List<ItensEstoque> findByQuantidadeLessThan(Integer quantidade);
    List<ItensEstoque> findByDoacaoProdutoIdDoacaoProduto(Long idDoacaoProduto);
}
