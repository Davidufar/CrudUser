package com.example.cruduser.service;

import com.example.cruduser.converter.PassportDTOConverter;
import com.example.cruduser.dao.PassportRepo;
import com.example.cruduser.model.Passport;
import com.example.cruduser.model.PassportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PassportServiceImpl implements  PassportService{
    private final PassportDTOConverter passportDTOConverter;

    @Autowired
    private PassportRepo passportRepo;

    public PassportServiceImpl(PassportDTOConverter passportDTOConverter) {
        this.passportDTOConverter = passportDTOConverter;
    }

    public List<PassportDTO> getAllPassports(){
        return passportRepo.findAll()
                .stream()
                .map(passportDTOConverter)
                .collect(Collectors.toList());

    }

    public PassportDTO getPassportById( long id){
        return passportRepo.findById(id)
                .map(passportDTOConverter)
                .orElseThrow();

    }


    public ResponseEntity<HttpStatus> addPassport( Passport passport){
        Passport passportObj = passportRepo.save(passport);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    public ResponseEntity<HttpStatus> updatePassportById( long id, Passport newPassportData ){
        Optional<Passport> oldPassportData = passportRepo.findById(id);

        if(oldPassportData.isPresent()){
            Passport updatedPassportData = oldPassportData.get();
            updatedPassportData.setId(newPassportData.getId());
            updatedPassportData.setName(newPassportData.getName());
            updatedPassportData.setSurName(newPassportData.getSurName());
            updatedPassportData.setSerialNumber(newPassportData.getSerialNumber());
            updatedPassportData.setDateOfMaking(newPassportData.getDateOfMaking());
            updatedPassportData.setExpirationDate(newPassportData.getExpirationDate());

            Passport passportObj = passportRepo.save(updatedPassportData);
            return new ResponseEntity<>(HttpStatus.OK );

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<HttpStatus> deletePassportById( long id){
        passportRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}