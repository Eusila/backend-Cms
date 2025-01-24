package com.example.cms_backend.mapper;


import com.example.cms_backend.dto.CattleDTO;
import com.example.cms_backend.dto.PaymentDTO;
import com.example.cms_backend.dto.RegisterDTO;
import com.example.cms_backend.dto.UserDTO;
import com.example.cms_backend.model.Cattle;
import com.example.cms_backend.model.Payment;
import com.example.cms_backend.model.Register;
import com.example.cms_backend.model.Users;

public class Mapper
{
    public static UserDTO toUserDTO(Users users) {
        UserDTO dto = new UserDTO();
        dto.setId(users.getId());
        dto.setUsername(users.getUsername());
        dto.setEmail(users.getEmail());
        dto.setContact(users.getContact());
        dto.setAddress(users.getAddress());
        return dto;
    }

    public static CattleDTO toCattleDTO(Cattle cattle) {
        CattleDTO dto = new CattleDTO();
        dto.setId(cattle.getId());
        dto.setCategoryName(cattle.getCategoryName());
        dto.setBreed(cattle.getBreed());
        dto.setWeight(cattle.getWeight());
        dto.setPrice(cattle.getPrice());
        dto.setImage(cattle.getImageUrl());
        return dto;
    }

    public static PaymentDTO toPaymentDTO(Payment payment) {
        PaymentDTO dto = new PaymentDTO();
        dto.setId(payment.getId());
        dto.setPaymentDate(payment.getPaymentDate());
        dto.setTransactionNumber(payment.getTransactionNumber());
        dto.setStatus(payment.getStatus().name());
        return dto;
    }

    public static RegisterDTO toRegisterDTO(Register register) {
        RegisterDTO dto = new RegisterDTO();
        dto.setId(register.getId());
        dto.setRegistrationId(register.getRegistrationId());
        dto.setDateAdded(register.getDateAdded());
        dto.setUser(toUserDTO(register.getUsers()));
        if (register.getCattle() != null) {
            dto.setCattle(toCattleDTO(register.getCattle()));
        }
        if (register.getPayment() != null) {
            dto.setPayment(toPaymentDTO(register.getPayment()));
        }
        return dto;
    }
}

