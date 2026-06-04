package com.pi.ong.controller;

import com.pi.ong.model.ItemEntrega;
import com.pi.ong.service.ItemEntregaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itens-entrega")
public class ItemEntregaController {

    private ItemEntregaService service;

    public ItemEntregaController(ItemEntregaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ItemEntrega>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ItemEntrega>> buscar(@PathVariable Long id) {
        Optional<ItemEntrega> aux = service.buscar(id);
        if (aux.isPresent()) {
            return ResponseEntity.ok(aux);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ItemEntrega> salvar(@RequestBody ItemEntrega itemEntrega) {
        ItemEntrega novo = service.salvar(itemEntrega);
        URI uri = URI.create("/itens-entrega/" + novo.getIdItemEntrega());
        return ResponseEntity.created(uri).body(novo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (service.remove(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemEntrega> atualizar(@PathVariable Long id,
                                               @RequestBody ItemEntrega itemEntrega) {
        ItemEntrega atualizado = service.atualiza(id, itemEntrega);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        }
        return ResponseEntity.notFound().build();
    }
}
