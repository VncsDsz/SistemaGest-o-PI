package com.pi.ong.controller;

import com.pi.ong.model.AtendimentoVoluntario;
import com.pi.ong.service.AtendimentoVoluntarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atendimentos-voluntarios")
public class AtendimentoVoluntarioController {

    private AtendimentoVoluntarioService service;

    public AtendimentoVoluntarioController(AtendimentoVoluntarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AtendimentoVoluntario>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AtendimentoVoluntario>> buscar(@PathVariable Long id) {
        Optional<AtendimentoVoluntario> aux = service.buscar(id);
        if (aux.isPresent()) {
            return ResponseEntity.ok(aux);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AtendimentoVoluntario> salvar(@RequestBody AtendimentoVoluntario atendimentoVoluntario) {
        AtendimentoVoluntario novo = service.salvar(atendimentoVoluntario);
        URI uri = URI.create("/atendimentos-voluntarios/" + novo.getIdAtendimentoVoluntario());
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
    public ResponseEntity<AtendimentoVoluntario> atualizar(@PathVariable Long id,
                                               @RequestBody AtendimentoVoluntario atendimentoVoluntario) {
        AtendimentoVoluntario atualizado = service.atualiza(id, atendimentoVoluntario);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        }
        return ResponseEntity.notFound().build();
    }
}
