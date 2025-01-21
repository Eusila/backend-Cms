package com.example.cms_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Data


@Table(name ="CattleMaster")
public class Cattle
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cattle_seq")
    @SequenceGenerator(name = "cattle_seq", sequenceName = "cattle_sequence", allocationSize = 1)
    private UUID id;

    @Column(nullable = false)
    private String categoryName;

    @Column(nullable = false)
    private String breed;

    @Column(nullable = false)
    private Double weight;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;

    @Column(nullable = false)
    private boolean approved = false;
}
