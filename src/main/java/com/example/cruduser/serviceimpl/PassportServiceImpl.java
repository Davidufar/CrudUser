package com.example.cruduser.serviceimpl;


import com.example.cruduser.dao.PassportRepo;

import com.example.cruduser.data.PassportData;
import com.example.cruduser.mapper.PassportToPassportDataMapper;
import com.example.cruduser.model.Passport;
import com.example.cruduser.dto.PassportDTO;
import com.example.cruduser.service.PassportService;
import com.example.cruduser.validator.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PassportServiceImpl implements PassportService {
    @Autowired
   PassportToPassportDataMapper passportToPassportDataMapper = new PassportToPassportDataMapper();

    @Autowired
    private PassportRepo passportRepo;




    public List<PassportData> getAllPassports(){
        return passportRepo.findAll()
                .stream()
                .map(passportToPassportDataMapper)
                .collect(Collectors.toList());

    }

    public PassportData getPassportById(long id){
        return passportRepo.findById(id)
                .map(passportToPassportDataMapper)
                .orElseThrow();

    }


    public ResponseEntity<HttpStatus> addPassport( Passport passport){
        if(EmailValidator.validate(passport.getEmail())){
            Passport passportObj = passportRepo.save(passport);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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