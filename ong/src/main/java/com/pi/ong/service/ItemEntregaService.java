package com.pi.ong.service;

import com.pi.ong.model.ItemEntrega;
import com.pi.ong.repository.ItemEntregaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemEntregaService {

    private ItemEntregaRepository repo;

    public ItemEntregaService(ItemEntregaRepository repo) {
        this.repo = repo;
    }

    public List<ItemEntrega> listar() {
        return repo.findAll();
    }

    public Optional<ItemEntrega> buscar(Long id) {
        return repo.findById(id);
    }

    public ItemEntrega salvar(ItemEntrega itemEntrega) {
        return repo.save(itemEntrega);
    }

    public boolean remove(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public ItemEntrega atualiza(Long id, ItemEntrega itemEntrega) {
        if (repo.existsById(id)) {
            itemEntrega.setIdItemEntrega(id);
            return repo.save(itemEntrega);
        }
        return null;
    }
}
