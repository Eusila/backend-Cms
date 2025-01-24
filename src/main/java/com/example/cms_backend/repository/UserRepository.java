package com.example.cms_backend.repository;

import com.example.cms_backend.model.Role;
import com.example.cms_backend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.UUID;


public interface UserRepository extends JpaRepository<Users, UUID>{
    List<Users> findByRole(Role role);
    Users findByEmail(String email);
}
