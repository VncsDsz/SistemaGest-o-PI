package com.pi.ong.service;

import com.pi.ong.model.Campanha;
import com.pi.ong.repository.CampanhaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampanhaService {

    private CampanhaRepository repo;

    public CampanhaService(CampanhaRepository repo) {
        this.repo = repo;
    }

    public List<Campanha> listar() {
        return repo.findAll();
    }

    public Optional<Campanha> buscar(Long id) {
        return repo.findById(id);
    }

    public Campanha salvar(Campanha campanha) {
        return repo.save(campanha);
    }

    public boolean remove(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public Campanha atualiza(Long id, Campanha campanha) {
        if (repo.existsById(id)) {
            campanha.setIdCampanha(id);
            return repo.save(campanha);
        }
        return null;
    }
}
