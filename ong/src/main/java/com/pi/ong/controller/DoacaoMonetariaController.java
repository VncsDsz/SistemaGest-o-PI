package com.pi.ong.controller;

import com.pi.ong.model.DoacaoMonetaria;
import com.pi.ong.service.DoacaoMonetariaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doacoes-monetarias")
public class DoacaoMonetariaController {

    private DoacaoMonetariaService service;

    public DoacaoMonetariaController(DoacaoMonetariaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DoacaoMonetaria>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DoacaoMonetaria>> buscar(@PathVariable Long id) {
        Optional<DoacaoMonetaria> aux = service.buscar(id);
        if (aux.isPresent()) {
            return ResponseEntity.ok(aux);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DoacaoMonetaria> salvar(@RequestBody DoacaoMonetaria doacaoMonetaria) {
        DoacaoMonetaria novo = service.salvar(doacaoMonetaria);
        URI uri = URI.create("/doacoes-monetarias/" + novo.getIdDoacaoMonetaria());
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
    public ResponseEntity<DoacaoMonetaria> atualizar(@PathVariable Long id,
                                               @RequestBody DoacaoMonetaria doacaoMonetaria) {
        DoacaoMonetaria atualizado = service.atualiza(id, doacaoMonetaria);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        }
        return ResponseEntity.notFound().build();
    }
}
