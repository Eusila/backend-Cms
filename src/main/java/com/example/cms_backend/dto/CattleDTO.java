package com.example.cms_backend.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CattleDTO
{
    private UUID id;
    private String categoryName;
    private String breed;
    private Double weight;
    private Double price;
    private String image;
}
