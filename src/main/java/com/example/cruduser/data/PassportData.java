package com.example.cruduser.data;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class PassportData {

    @Valid
    @NotNull(message = " id should not be null")


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

    public PassportData(@Valid @NotNull(message = " id should not be null") long id,
                        @NotNull(message = "name should not be null") String name,
                        @NotNull(message = "surname should not be null") String surName,
                        @NotNull(message = "Date Of Making should not be null") int dateOfMaking,
                        @NotNull(message = "Expiration Date should not be null") int expirationDate,
                        @NotNull(message = "Serial Number should not be null") long serialNumber) {
    }
}
