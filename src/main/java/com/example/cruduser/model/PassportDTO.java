package com.example.cruduser.model;




public record PassportDTO(
        long id,
        String name,
        String surName,
        int dateOfMaking,
        int expirationDate


) {


}
