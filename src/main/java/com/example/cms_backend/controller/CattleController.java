package com.example.cms_backend.controller;

import com.example.cms_backend.model.Cattle;
import com.example.cms_backend.service.CattleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cattle")
public class CattleController
{
    private final CattleService cattleService;

    public CattleController(CattleService cattleService) {
        this.cattleService = cattleService;
    }

    @PostMapping
    public ResponseEntity<Cattle> addCattle(@RequestBody Cattle cattle) {
        return ResponseEntity.ok(cattleService.addCattle(cattle));
    }

    @GetMapping
    public ResponseEntity<List<Cattle>> getAllCattle() {
        return ResponseEntity.ok(cattleService.getAllCattle());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cattle> getCattleById(@PathVariable UUID id) {
        return ResponseEntity.ok(cattleService.getCattleById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cattle> updateCattle(@PathVariable UUID id, @RequestBody Cattle cattle) {
        return ResponseEntity.ok(cattleService.updateCattle(id, cattle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCattle(@PathVariable UUID id) {
        cattleService.deleteCattle(id);
        return ResponseEntity.ok("Cattle deleted successfully.");
    }
}

