package com.example.cms_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


@Table(name ="RegisterMaster")

public class Register
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registration_seq")
    @SequenceGenerator(name = "registration_seq", sequenceName = "registration_sequence", allocationSize = 1)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String registrationId;

    @Column(nullable = false)
    private LocalDate dateAdded;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "cattle_id")
    private Cattle cattle;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;

}
