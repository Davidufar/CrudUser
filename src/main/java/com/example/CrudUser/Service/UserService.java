package com.example.CrudUser.Service;

import com.example.CrudUser.Model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public interface UserService {

    public ResponseEntity<List<User>> getAllUsers();
    public ResponseEntity<User> getUserById(@PathVariable long id);
    public ResponseEntity<User> addUser(@RequestBody User user);
    public ResponseEntity<User> updateUserById(@PathVariable long id,@RequestBody User newUserData );
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable long id);

}
