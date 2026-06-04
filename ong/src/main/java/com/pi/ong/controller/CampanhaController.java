package com.pi.ong.controller;

import com.pi.ong.model.Campanha;
import com.pi.ong.service.CampanhaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/campanhas")
public class CampanhaController {

    private CampanhaService service;

    public CampanhaController(CampanhaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Campanha>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Campanha>> buscar(@PathVariable Long id) {
        Optional<Campanha> aux = service.buscar(id);
        if (aux.isPresent()) {
            return ResponseEntity.ok(aux);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Campanha> salvar(@RequestBody Campanha campanha) {
        Campanha novo = service.salvar(campanha);
        URI uri = URI.create("/campanhas/" + novo.getIdCampanha());
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
    public ResponseEntity<Campanha> atualizar(@PathVariable Long id,
                                               @RequestBody Campanha campanha) {
        Campanha atualizado = service.atualiza(id, campanha);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        }
        return ResponseEntity.notFound().build();
    }
}
