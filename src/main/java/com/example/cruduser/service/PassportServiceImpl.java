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
    public PassportDTO getAllPassports(){
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

    public PassportDTO getUserById( long id){
        Optional<Passport> passportData = passportRepo.findById(id);

        if(passportData.isPresent()){
            return new PassportDTO();
        }
        else{
            return new PassportDTO();
        }
    }


    public ResponseEntity<User> addUser( User user){
        User userObj = userRepo.save(user);

        return new ResponseEntity<>(userObj,HttpStatus.OK);
    }


    public ResponseEntity<User> updateUserById( long id, User newUserData ){
        Optional<User> oldUserData = userRepo.findById(id);

        if(oldUserData.isPresent()){
            User updatedUserData = oldUserData.get();
            updatedUserData.setName(newUserData.getName());
            updatedUserData.setAge(newUserData.getAge());

            User userObj = userRepo.save(updatedUserData);
            return new ResponseEntity<>(userObj, HttpStatus.OK );

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<HttpStatus> deleteUserById( long id){
        userRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}