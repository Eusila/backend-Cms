package com.example.cms_backend.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class RegisterDTO
{
    private UUID id;
    private String registrationId;
    private LocalDate dateAdded;
    private UserDTO user;
    private CattleDTO cattle;
    private PaymentDTO payment;
}
