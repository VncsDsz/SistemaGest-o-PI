package com.pi.ong.controller;

import com.pi.ong.model.Doador;
import com.pi.ong.service.DoadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doadores")
public class DoadorController {

    private DoadorService service;

    public DoadorController(DoadorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Doador>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Doador>> buscar(@PathVariable Long id) {
        Optional<Doador> aux = service.buscar(id);
        if (aux.isPresent()) {
            return ResponseEntity.ok(aux);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Doador> salvar(@RequestBody Doador doador) {
        Doador novo = service.salvar(doador);
        URI uri = URI.create("/doadores/" + novo.getIdDoador());
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
    public ResponseEntity<Doador> atualizar(@PathVariable Long id,
                                               @RequestBody Doador doador) {
        Doador atualizado = service.atualiza(id, doador);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        }
        return ResponseEntity.notFound().build();
    }
}
