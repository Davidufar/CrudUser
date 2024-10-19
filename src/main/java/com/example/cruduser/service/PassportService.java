package com.example.cruduser.service;

import com.example.cruduser.model.Passport;
import com.example.cruduser.model.PassportDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface PassportService {
    public PassportDTO getAllPassports();

    public PassportDTO getPassportById(long id);


    public PassportDTO addPassportToUserById( Passport passport);


    public PassportDTO updateCarById( long id, Passport newPassportData );

    public ResponseEntity<HttpStatus> deletePassportById( long id);
}
