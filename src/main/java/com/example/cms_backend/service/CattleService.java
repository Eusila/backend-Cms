package com.example.cms_backend.service;



import com.example.cms_backend.model.Cattle;
import com.example.cms_backend.repository.CattleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CattleService {

    private final CattleRepository cattleRepository;

    public CattleService(CattleRepository cattleRepository) {
        this.cattleRepository = cattleRepository;
    }

    public Cattle addCattle(Cattle cattle) {
        return cattleRepository.save(cattle);
    }

    public List<Cattle> getAllCattle() {
        return cattleRepository.findAll();
    }

    public Cattle getCattleById(UUID id) {
        return cattleRepository.findById(id).orElseThrow(() -> new RuntimeException("Cattle not found"));
    }

    public Cattle updateCattle(UUID id, Cattle cattle) {
        Cattle existingCattle = getCattleById(id);
        existingCattle.setCategoryName(cattle.getCategoryName());
        existingCattle.setBreed(cattle.getBreed());
        existingCattle.setWeight(cattle.getWeight());
        existingCattle.setImageUrl(cattle.getImageUrl());
        existingCattle.setPrice(cattle.getPrice());
        return cattleRepository.save(existingCattle);
    }

    public void deleteCattle(UUID id) {
        cattleRepository.deleteById(id);
    }
}

