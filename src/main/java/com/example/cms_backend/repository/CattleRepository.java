package com.example.cms_backend.repository;

import com.example.cms_backend.model.Cattle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CattleRepository extends JpaRepository<Cattle,UUID> {
}
