package com.pi.ong.controller;

import com.pi.ong.model.Beneficiaria;
import com.pi.ong.service.BeneficiariaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/beneficiarias")
public class BeneficiariaController {

    private BeneficiariaService service;

    public BeneficiariaController(
            BeneficiariaService service) {

        this.service = service;
    }

    //listar todas
    @GetMapping
    public ResponseEntity<List<Beneficiaria>>
    listar() {

        return ResponseEntity
                .ok(service.listar());
    }

    //busca por id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Beneficiaria>>
    buscar(@PathVariable Long id) {

        Optional<Beneficiaria> aux =
                service.buscar(id);

        if (aux.isPresent()) {
            return ResponseEntity.ok(aux);
        }

        return ResponseEntity
                .notFound()
                .build();
    }

    //cadastrar beneficiaria
    @PostMapping
    public ResponseEntity<Beneficiaria>
    salvar(
            @RequestBody
            Beneficiaria beneficiaria) {

        Beneficiaria nova =
                service.salvar(beneficiaria);

        URI uri = URI.create(
                "/beneficiarias/" +
                        nova.getIdBeneficiaria());

        return ResponseEntity
                .created(uri)
                .body(nova);
    }

    //deletar beneficiaria
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>
    remover(@PathVariable Long id) {

        if (service.remove(id)) {
            return ResponseEntity
                    .noContent()
                    .build();
        }

        return ResponseEntity
                .notFound()
                .build();
    }

    //atualizar cadastro
    @PutMapping("/{id}")
    public ResponseEntity<Beneficiaria>
    atualizar(
            @PathVariable Long id,
            @RequestBody
            Beneficiaria beneficiaria) {

        Beneficiaria atualizada =
                service.atualiza(
                        id,
                        beneficiaria);

        if (atualizada != null) {
            return ResponseEntity
                    .ok(atualizada);
        }

        return ResponseEntity
                .notFound()
                .build();
    }
}