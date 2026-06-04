package com.pi.ong.controller;

import com.pi.ong.model.DoacaoProduto;
import com.pi.ong.service.DoacaoProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doacoes-produto")
public class DoacaoProdutoController {

    private DoacaoProdutoService service;

    public DoacaoProdutoController(DoacaoProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DoacaoProduto>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DoacaoProduto>> buscar(@PathVariable Long id) {
        Optional<DoacaoProduto> aux = service.buscar(id);
        if (aux.isPresent()) {
            return ResponseEntity.ok(aux);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DoacaoProduto> salvar(@RequestBody DoacaoProduto doacaoProduto) {
        DoacaoProduto novo = service.salvar(doacaoProduto);
        URI uri = URI.create("/doacoes-produto/" + novo.getIdDoacaoProduto());
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
    public ResponseEntity<DoacaoProduto> atualizar(@PathVariable Long id,
                                               @RequestBody DoacaoProduto doacaoProduto) {
        DoacaoProduto atualizado = service.atualiza(id, doacaoProduto);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        }
        return ResponseEntity.notFound().build();
    }
}
