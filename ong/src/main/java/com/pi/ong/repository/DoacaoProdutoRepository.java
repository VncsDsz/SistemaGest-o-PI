package com.pi.ong.repository;

import com.pi.ong.model.DoacaoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoacaoProdutoRepository extends JpaRepository<DoacaoProduto, Long> {

    List<DoacaoProduto> findByCategoriaProduto(String categoriaProduto);
    List<DoacaoProduto> findByDoacaoCampanhaIdDoacaoCampanha(Long idDoacaoCampanha);
}
