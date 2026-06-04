package com.pi.ong.service;

import com.pi.ong.model.ItensEstoque;
import com.pi.ong.repository.ItensEstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItensEstoqueService {

    private ItensEstoqueRepository repo;

    public ItensEstoqueService(ItensEstoqueRepository repo) {
        this.repo = repo;
    }

    public List<ItensEstoque> listar() {
        return repo.findAll();
    }

    public Optional<ItensEstoque> buscar(Long id) {
        return repo.findById(id);
    }

    public ItensEstoque salvar(ItensEstoque itensEstoque) {
        return repo.save(itensEstoque);
    }

    public boolean remove(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public ItensEstoque atualiza(Long id, ItensEstoque itensEstoque) {
        if (repo.existsById(id)) {
            itensEstoque.setIdItensEstoque(id);
            return repo.save(itensEstoque);
        }
        return null;
    }
}
