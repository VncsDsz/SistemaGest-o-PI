package com.pi.ong.service;

import com.pi.ong.model.DoacaoCampanha;
import com.pi.ong.repository.DoacaoCampanhaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoacaoCampanhaService {

    private DoacaoCampanhaRepository repo;

    public DoacaoCampanhaService(DoacaoCampanhaRepository repo) {
        this.repo = repo;
    }

    public List<DoacaoCampanha> listar() {
        return repo.findAll();
    }

    public Optional<DoacaoCampanha> buscar(Long id) {
        return repo.findById(id);
    }

    public DoacaoCampanha salvar(DoacaoCampanha doacaoCampanha) {
        return repo.save(doacaoCampanha);
    }

    public boolean remove(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public DoacaoCampanha atualiza(Long id, DoacaoCampanha doacaoCampanha) {
        if (repo.existsById(id)) {
            doacaoCampanha.setIdDoacaoCampanha(id);
            return repo.save(doacaoCampanha);
        }
        return null;
    }
}
