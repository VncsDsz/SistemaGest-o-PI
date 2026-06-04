package com.pi.ong.service;

import com.pi.ong.model.DoacaoProduto;
import com.pi.ong.repository.DoacaoProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoacaoProdutoService {

    private DoacaoProdutoRepository repo;

    public DoacaoProdutoService(DoacaoProdutoRepository repo) {
        this.repo = repo;
    }

    public List<DoacaoProduto> listar() {
        return repo.findAll();
    }

    public Optional<DoacaoProduto> buscar(Long id) {
        return repo.findById(id);
    }

    public DoacaoProduto salvar(DoacaoProduto doacaoProduto) {
        return repo.save(doacaoProduto);
    }

    public boolean remove(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public DoacaoProduto atualiza(Long id, DoacaoProduto doacaoProduto) {
        if (repo.existsById(id)) {
            doacaoProduto.setIdDoacaoProduto(id);
            return repo.save(doacaoProduto);
        }
        return null;
    }
}
