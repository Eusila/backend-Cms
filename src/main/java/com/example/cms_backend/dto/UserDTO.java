package com.example.cms_backend.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDTO
{

        private UUID id;
        private String Username;
        private String email;
        private String contact;
        private String address;
    }


