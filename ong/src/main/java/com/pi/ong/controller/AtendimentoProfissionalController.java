package com.pi.ong.controller;

import com.pi.ong.model.
        AtendimentoProfissional;
import com.pi.ong.service.
        AtendimentoProfissionalService;

import org.springframework.http.
        ResponseEntity;

import org.springframework.
        web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(
        "/atendimentos")
public class
AtendimentoProfissionalController {

    private
    AtendimentoProfissionalService
            service;

    public
    AtendimentoProfissionalController(
            AtendimentoProfissionalService service) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity<
            List<
                    AtendimentoProfissional>>
    listar() {

        return ResponseEntity
                .ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<
            Optional<
                    AtendimentoProfissional>>
    buscar(
            @PathVariable Long id) {

        Optional<
                AtendimentoProfissional>
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
            AtendimentoProfissional>
    salvar(
            @RequestBody
            AtendimentoProfissional atendimento) {

        AtendimentoProfissional
                novo =
                service.salvar(
                        atendimento);

        URI uri = URI.create(
                "/atendimentos/"
                        + novo
                        .getIdAtendimento());

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
            AtendimentoProfissional>
    atualizar(
            @PathVariable Long id,

            @RequestBody
            AtendimentoProfissional atendimento) {

        AtendimentoProfissional
                atualizado =
                service.atualiza(
                        id,
                        atendimento);

        if (atualizado != null) {

            return ResponseEntity
                    .ok(atualizado);
        }

        return ResponseEntity
                .notFound()
                .build();
    }
}