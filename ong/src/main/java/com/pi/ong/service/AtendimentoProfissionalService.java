package com.pi.ong.service;

import com.pi.ong.model.AtendimentoProfissional;
import com.pi.ong.repository.
        AtendimentoProfissionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoProfissionalService {

    private
    AtendimentoProfissionalRepository
            repo;

    public
    AtendimentoProfissionalService(
            AtendimentoProfissionalRepository repo) {

        this.repo = repo;
    }

    public List<
            AtendimentoProfissional>
    listar() {

        return repo.findAll();
    }

    public Optional<
            AtendimentoProfissional>
    buscar(Long id) {

        return repo.findById(id);
    }

    public AtendimentoProfissional
    salvar(
            AtendimentoProfissional atendimento) {

        return repo.save(
                atendimento);
    }

    public boolean
    remove(Long id) {

        if (repo.existsById(id)) {

            repo.deleteById(id);
            return true;
        }

        return false;
    }

    public AtendimentoProfissional
    atualiza(
            Long id,
            AtendimentoProfissional atendimento) {

        if (repo.existsById(id)) {

            atendimento
                    .setIdAtendimento(id);

            return repo.save(
                    atendimento);
        }

        return null;
    }
}