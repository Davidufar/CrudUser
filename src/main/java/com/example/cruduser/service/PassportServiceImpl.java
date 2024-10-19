package com.example.cruduser.service;

import com.example.cruduser.dao.PassportRepo;
import com.example.cruduser.model.Passport;
import com.example.cruduser.model.PassportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PassportServiceImpl implements  PassportService{
    @Autowired
    private PassportRepo passportRepo;
    public List<PassportDTO> getAllPassports(){
        try{
            List<Passport> passportList = new ArrayList<>();
            passportRepo.findAll().forEach(passportList::add);


            if(passportList.isEmpty()){
                return new PassportDTO();
            }

            return new PassportDTO;
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public PassportDTO getPassportById( long id){
        Optional<Passport> passportData = passportRepo.findById(id);

        if(passportData.isPresent()){
            return new PassportDTO();
        }
        else{
            return new PassportDTO();
        }
    }


    public ResponseEntity<HttpStatus> addPassport( Passport passport){
        Passport passportObj = passportRepo.save(passport);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    public ResponseEntity<HttpStatus> updatePassportById( long id, Passport newPassportData ){
        Optional<Passport> oldPassportData = passportRepo.findById(id);

        if(oldPassportData.isPresent()){
            Passport updatedPassportData = oldPassportData.get();
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