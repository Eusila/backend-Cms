package com.example.cms_backend.repository;

import com.example.cms_backend.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegisterRepository extends JpaRepository<Register, UUID> {
}
