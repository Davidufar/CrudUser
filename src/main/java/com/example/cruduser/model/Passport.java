package com.example.cruduser.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Passports")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long serialNumber;

    private String name;
    private String surName;

    private int dateOfMaking;
    private int expirationDate;



}
