package com.example.CrudUser.Service;

import com.example.CrudUser.DAO.UserRepo;
import com.example.CrudUser.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements  UserService{
    @Autowired
    private UserRepo userRepo;
    public ResponseEntity<List<User>> getAllUsers(){
        try{
            List<User> userList = new ArrayList<>();
            userRepo.findAll().forEach(userList::add);


            if(userList.isEmpty()){
                return new ResponseEntity<>(userList, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(userList,HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<User> getUserById(@PathVariable long id){
        Optional<User> userData = userRepo.findById(id);

        if(userData.isPresent()){
            return new ResponseEntity<>(userData.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<User> addUser(@RequestBody User user){
        User userObj = userRepo.save(user);

        return new ResponseEntity<>(userObj,HttpStatus.OK);
    }


    public ResponseEntity<User> updateUserById(@PathVariable long id,@RequestBody User newUserData ){
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

    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable long id){
        userRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
