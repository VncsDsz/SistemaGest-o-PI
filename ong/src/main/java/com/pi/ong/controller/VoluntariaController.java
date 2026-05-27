package com.pi.ong.controller;

import com.pi.ong.model.Voluntaria;
import com.pi.ong.service.
        VoluntariaService;

import org.springframework.http.
        ResponseEntity;

import org.springframework.
        web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/voluntarias")
public class VoluntariaController {

    private
    VoluntariaService service;

    public VoluntariaController(
            VoluntariaService service) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity<
            List<Voluntaria>>
    listar() {

        return ResponseEntity
                .ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<
            Optional<Voluntaria>>
    buscar(
            @PathVariable Long id) {

        Optional<Voluntaria>
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
            Voluntaria>
    salvar(
            @RequestBody
            Voluntaria voluntaria) {

        Voluntaria nova =
                service.salvar(
                        voluntaria);

        URI uri = URI.create(
                "/voluntarias/"
                        + nova
                        .getIdVoluntaria());

        return ResponseEntity
                .created(uri)
                .body(nova);
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
            Voluntaria>
    atualizar(
            @PathVariable Long id,

            @RequestBody
            Voluntaria voluntaria) {

        Voluntaria atualizada =
                service.atualiza(
                        id,
                        voluntaria);

        if (atualizada != null) {

            return ResponseEntity
                    .ok(atualizada);
        }

        return ResponseEntity
                .notFound()
                .build();
    }
}