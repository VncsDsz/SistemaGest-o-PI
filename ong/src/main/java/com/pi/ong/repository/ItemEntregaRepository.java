package com.pi.ong.repository;

import com.pi.ong.model.ItemEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemEntregaRepository extends JpaRepository<ItemEntrega, Long> {

    List<ItemEntrega> findByEntregaIdEntrega(Long idEntrega);
    List<ItemEntrega> findByItensEstoqueIdItensEstoque(Long idItensEstoque);
}
