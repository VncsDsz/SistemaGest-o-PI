package com.pi.ong.controller;

import com.pi.ong.model.MovimentacaoEstoque;
import com.pi.ong.service.MovimentacaoEstoqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimentacoes-estoque")
public class MovimentacaoEstoqueController {

    private MovimentacaoEstoqueService service;

    public MovimentacaoEstoqueController(MovimentacaoEstoqueService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MovimentacaoEstoque>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MovimentacaoEstoque>> buscar(@PathVariable Long id) {
        Optional<MovimentacaoEstoque> aux = service.buscar(id);
        if (aux.isPresent()) {
            return ResponseEntity.ok(aux);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<MovimentacaoEstoque> salvar(@RequestBody MovimentacaoEstoque movimentacaoEstoque) {
        MovimentacaoEstoque novo = service.salvar(movimentacaoEstoque);
        URI uri = URI.create("/movimentacoes-estoque/" + novo.getIdMovimentacaoEstoque());
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
    public ResponseEntity<MovimentacaoEstoque> atualizar(@PathVariable Long id,
                                               @RequestBody MovimentacaoEstoque movimentacaoEstoque) {
        MovimentacaoEstoque atualizado = service.atualiza(id, movimentacaoEstoque);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        }
        return ResponseEntity.notFound().build();
    }
}
