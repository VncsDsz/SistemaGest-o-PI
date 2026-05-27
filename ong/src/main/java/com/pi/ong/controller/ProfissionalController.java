package com.pi.ong.controller;

import com.pi.ong.model.Profissional;
import com.pi.ong.service.ProfissionalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    private ProfissionalService service;

    public ProfissionalController(
            ProfissionalService service) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity<
            List<Profissional>>
    listar() {

        return ResponseEntity
                .ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<
            Optional<Profissional>>
    buscar(
            @PathVariable Long id) {

        Optional<Profissional>
                aux =
                service.buscar(id);

        if (aux.isPresent()) {

            return ResponseEntity
                    .ok(aux);
        }

        return ResponseEntity
                .notFound()
                .build();
    }

    @PostMapping
    public ResponseEntity<
            Profissional>
    salvar(
            @RequestBody
            Profissional profissional) {

        Profissional novo =
                service.salvar(
                        profissional);

        URI uri = URI.create(
                "/profissionais/"
                        + novo
                        .getIdProfissional());

        return ResponseEntity
                .created(uri)
                .body(novo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>
    remover(
            @PathVariable Long id) {

        if (service.remove(id)) {

            return ResponseEntity
                    .noContent()
                    .build();
        }

        return ResponseEntity
                .notFound()
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<
            Profissional>
    atualizar(
            @PathVariable Long id,
            @RequestBody
            Profissional profissional) {

        Profissional atualizado =
                service.atualiza(
                        id,
                        profissional);

        if (atualizado != null) {

            return ResponseEntity
                    .ok(atualizado);
        }

        return ResponseEntity
                .notFound()
                .build();
    }
}