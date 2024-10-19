package com.example.cruduser.service;

import com.example.cruduser.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface UserService {

    public ResponseEntity<List<User>> getAllUsers();
    public ResponseEntity<User> getUserById( long id);
    public ResponseEntity<User> addUser( User user);
    public ResponseEntity<User> updateUserById( long id, User newUserData );
    public ResponseEntity<HttpStatus> deleteUserById( long id);

}
