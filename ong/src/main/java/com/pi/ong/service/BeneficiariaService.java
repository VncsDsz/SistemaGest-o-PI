package com.pi.ong.service;

import com.pi.ong.model.Beneficiaria;
import com.pi.ong.repository.BeneficiariaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiariaService {

    private BeneficiariaRepository repo;

    public BeneficiariaService(
            BeneficiariaRepository repo) {

        this.repo = repo;
    }

    public List<Beneficiaria> listar() {
        return repo.findAll();
    }

    public Optional<Beneficiaria> buscar(Long id) {
        return repo.findById(id);
    }

    public Beneficiaria salvar(
            Beneficiaria beneficiaria) {

        return repo.save(beneficiaria);
    }

    public boolean remove(Long id) {

        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }

        return false;
    }

    public Beneficiaria atualiza(
            Long id,
            Beneficiaria beneficiaria) {

        if (repo.existsById(id)) {

            beneficiaria
                    .setIdBeneficiaria(id);

            return repo.save(beneficiaria);
        }
        return null;
    }
}