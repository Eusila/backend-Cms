package com.example.cms_backend.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class PaymentDTO
{
    private UUID id;
    private LocalDate paymentDate;
    private String transactionNumber;
    private String status;
}
