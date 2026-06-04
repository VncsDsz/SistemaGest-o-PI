package com.pi.ong.controller;

import com.pi.ong.model.ItensEstoque;
import com.pi.ong.service.ItensEstoqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itens-estoque")
public class ItensEstoqueController {

    private ItensEstoqueService service;

    public ItensEstoqueController(ItensEstoqueService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ItensEstoque>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ItensEstoque>> buscar(@PathVariable Long id) {
        Optional<ItensEstoque> aux = service.buscar(id);
        if (aux.isPresent()) {
            return ResponseEntity.ok(aux);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ItensEstoque> salvar(@RequestBody ItensEstoque itensEstoque) {
        ItensEstoque novo = service.salvar(itensEstoque);
        URI uri = URI.create("/itens-estoque/" + novo.getIdItensEstoque());
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
    public ResponseEntity<ItensEstoque> atualizar(@PathVariable Long id,
                                               @RequestBody ItensEstoque itensEstoque) {
        ItensEstoque atualizado = service.atualiza(id, itensEstoque);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        }
        return ResponseEntity.notFound().build();
    }
}
