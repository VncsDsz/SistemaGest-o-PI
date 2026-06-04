package com.pi.ong.service;

import com.pi.ong.model.MovimentacaoEstoque;
import com.pi.ong.repository.MovimentacaoEstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoEstoqueService {

    private MovimentacaoEstoqueRepository repo;

    public MovimentacaoEstoqueService(MovimentacaoEstoqueRepository repo) {
        this.repo = repo;
    }

    public List<MovimentacaoEstoque> listar() {
        return repo.findAll();
    }

    public Optional<MovimentacaoEstoque> buscar(Long id) {
        return repo.findById(id);
    }

    public MovimentacaoEstoque salvar(MovimentacaoEstoque movimentacao) {
        return repo.save(movimentacao);
    }

    public boolean remove(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public MovimentacaoEstoque atualiza(Long id, MovimentacaoEstoque movimentacao) {
        if (repo.existsById(id)) {
            movimentacao.setIdMovimentacaoEstoque(id);
            return repo.save(movimentacao);
        }
        return null;
    }
}
