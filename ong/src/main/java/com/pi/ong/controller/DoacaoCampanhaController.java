package com.pi.ong.controller;

import com.pi.ong.model.DoacaoCampanha;
import com.pi.ong.service.DoacaoCampanhaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doacoes-campanha")
public class DoacaoCampanhaController {

    private DoacaoCampanhaService service;

    public DoacaoCampanhaController(DoacaoCampanhaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DoacaoCampanha>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DoacaoCampanha>> buscar(@PathVariable Long id) {
        Optional<DoacaoCampanha> aux = service.buscar(id);
        if (aux.isPresent()) {
            return ResponseEntity.ok(aux);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DoacaoCampanha> salvar(@RequestBody DoacaoCampanha doacaoCampanha) {
        DoacaoCampanha novo = service.salvar(doacaoCampanha);
        URI uri = URI.create("/doacoes-campanha/" + novo.getIdDoacaoCampanha());
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
    public ResponseEntity<DoacaoCampanha> atualizar(@PathVariable Long id,
                                               @RequestBody DoacaoCampanha doacaoCampanha) {
        DoacaoCampanha atualizado = service.atualiza(id, doacaoCampanha);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        }
        return ResponseEntity.notFound().build();
    }
}
