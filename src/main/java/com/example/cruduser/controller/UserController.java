package com.example.cruduser.controller;

import com.example.cruduser.model.User;
import com.example.cruduser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody @Valid User user){
        return userService.addUser(user);
    }

    @PostMapping("/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable long id,@RequestBody @Valid User newUserData ){
        return userService.updateUserById(id,newUserData);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable long id){
       return userService.deleteUserById(id);
    }
}
