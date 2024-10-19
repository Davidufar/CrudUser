package com.example.cruduser.service;

import com.example.cruduser.model.Passport;
import com.example.cruduser.model.PassportDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface PassportService {
    public List<PassportDTO> getAllPassports();

    public PassportDTO getPassportById(long id);


    public ResponseEntity<HttpStatus> addPassport( Passport passport);


    public ResponseEntity<HttpStatus> updatePassportById( long id, Passport newPassportData );

    public ResponseEntity<HttpStatus> deletePassportById( long id);
}
