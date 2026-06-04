package com.pi.ong.service;

import com.pi.ong.model.AtendimentoVoluntario;
import com.pi.ong.repository.AtendimentoVoluntarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoVoluntarioService {

    private AtendimentoVoluntarioRepository repo;

    public AtendimentoVoluntarioService(AtendimentoVoluntarioRepository repo) {
        this.repo = repo;
    }

    public List<AtendimentoVoluntario> listar() {
        return repo.findAll();
    }

    public Optional<AtendimentoVoluntario> buscar(Long id) {
        return repo.findById(id);
    }

    public AtendimentoVoluntario salvar(AtendimentoVoluntario atendimento) {
        return repo.save(atendimento);
    }

    public boolean remove(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public AtendimentoVoluntario atualiza(Long id, AtendimentoVoluntario atendimento) {
        if (repo.existsById(id)) {
            atendimento.setIdAtendimentoVoluntario(id);
            return repo.save(atendimento);
        }
        return null;
    }
}
