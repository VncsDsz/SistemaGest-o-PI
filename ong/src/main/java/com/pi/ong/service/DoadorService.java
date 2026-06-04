package com.pi.ong.service;

import com.pi.ong.model.Doador;
import com.pi.ong.repository.DoadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoadorService {

    private DoadorRepository repo;

    public DoadorService(DoadorRepository repo) {
        this.repo = repo;
    }

    public List<Doador> listar() {
        return repo.findAll();
    }

    public Optional<Doador> buscar(Long id) {
        return repo.findById(id);
    }

    public Doador salvar(Doador doador) {
        return repo.save(doador);
    }

    public boolean remove(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public Doador atualiza(Long id, Doador doador) {
        if (repo.existsById(id)) {
            doador.setIdDoador(id);
            return repo.save(doador);
        }
        return null;
    }
}
