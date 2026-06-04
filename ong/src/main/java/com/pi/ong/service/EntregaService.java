package com.pi.ong.service;

import com.pi.ong.model.Entrega;
import com.pi.ong.repository.EntregaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregaService {

    private EntregaRepository repo;

    public EntregaService(EntregaRepository repo) {
        this.repo = repo;
    }

    public List<Entrega> listar() {
        return repo.findAll();
    }

    public Optional<Entrega> buscar(Long id) {
        return repo.findById(id);
    }

    public Entrega salvar(Entrega entrega) {
        return repo.save(entrega);
    }

    public boolean remove(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public Entrega atualiza(Long id, Entrega entrega) {
        if (repo.existsById(id)) {
            entrega.setIdEntrega(id);
            return repo.save(entrega);
        }
        return null;
    }
}
