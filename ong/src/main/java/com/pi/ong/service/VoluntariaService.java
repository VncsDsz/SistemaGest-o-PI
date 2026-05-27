package com.pi.ong.service;

import com.pi.ong.model.Voluntaria;
import com.pi.ong.repository.
        VoluntariaRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoluntariaService {

    private VoluntariaRepository repo;

    public VoluntariaService(
            VoluntariaRepository repo) {

        this.repo = repo;
    }

    public List<Voluntaria>
    listar() {

        return repo.findAll();
    }

    public Optional<Voluntaria>
    buscar(Long id) {

        return repo.findById(id);
    }

    public Voluntaria
    salvar(
            Voluntaria voluntaria) {

        return repo.save(
                voluntaria);
    }

    public boolean
    remove(Long id) {

        if (repo.existsById(id)) {

            repo.deleteById(id);
            return true;
        }

        return false;
    }

    public Voluntaria
    atualiza(
            Long id,
            Voluntaria voluntaria) {

        if (repo.existsById(id)) {

            voluntaria
                    .setIdVoluntaria(id);

            return repo.save(
                    voluntaria);
        }

        return null;
    }
}