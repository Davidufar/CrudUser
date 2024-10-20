package com.example.cruduser.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Passports")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Passport {

    @Valid
    @NotNull(message = " id should not be null")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "name should not be null")
    private String name;
    @NotNull(message = "surname should not be null")
    private String surName;

    @NotNull(message = "Date Of Making should not be null")
    private int dateOfMaking;
    @NotNull(message = "Expiration Date should not be null")
    private int expirationDate;

    @NotNull(message = "Serial Number should not be null")
    private long serialNumber;



}
