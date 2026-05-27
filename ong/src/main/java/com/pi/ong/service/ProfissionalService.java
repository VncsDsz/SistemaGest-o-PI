package com.pi.ong.service;

import com.pi.ong.model.Profissional;
import com.pi.ong.repository.ProfissionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalService {

    private ProfissionalRepository repo;

    public ProfissionalService(
            ProfissionalRepository repo) {

        this.repo = repo;
    }

    public List<Profissional>
    listar() {

        return repo.findAll();
    }

    public Optional<Profissional>
    buscar(Long id) {

        return repo.findById(id);
    }

    public Profissional
    salvar(
            Profissional profissional) {

        return repo.save(
                profissional);
    }

    public boolean
    remove(Long id) {

        if (repo.existsById(id)) {

            repo.deleteById(id);
            return true;
        }

        return false;
    }

    public Profissional
    atualiza(
            Long id,
            Profissional profissional) {

        if (repo.existsById(id)) {

            profissional
                    .setIdProfissional(id);

            return repo.save(
                    profissional);
        }

        return null;
    }
}