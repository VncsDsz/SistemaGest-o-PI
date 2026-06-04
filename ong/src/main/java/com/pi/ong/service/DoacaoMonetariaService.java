package com.pi.ong.service;

import com.pi.ong.model.DoacaoMonetaria;
import com.pi.ong.repository.DoacaoMonetariaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoacaoMonetariaService {

    private DoacaoMonetariaRepository repo;

    public DoacaoMonetariaService(DoacaoMonetariaRepository repo) {
        this.repo = repo;
    }

    public List<DoacaoMonetaria> listar() {
        return repo.findAll();
    }

    public Optional<DoacaoMonetaria> buscar(Long id) {
        return repo.findById(id);
    }

    public DoacaoMonetaria salvar(DoacaoMonetaria doacaoMonetaria) {
        return repo.save(doacaoMonetaria);
    }

    public boolean remove(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public DoacaoMonetaria atualiza(Long id, DoacaoMonetaria doacaoMonetaria) {
        if (repo.existsById(id)) {
            doacaoMonetaria.setIdDoacaoMonetaria(id);
            return repo.save(doacaoMonetaria);
        }
        return null;
    }
}
