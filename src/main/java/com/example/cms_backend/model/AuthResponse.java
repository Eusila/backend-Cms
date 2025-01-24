package com.example.cms_backend.model;

import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private String message;
    private String status;


    public AuthResponse(String token, String message, String status) {
        this.token = token;
        this.message = message;
        this.status = status;
    }


}
