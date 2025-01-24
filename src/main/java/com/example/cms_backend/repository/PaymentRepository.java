package com.example.cms_backend.repository;

import com.example.cms_backend.model.Payment;
import com.example.cms_backend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    List<Payment> findByUser(Users user);

}
