package com.vaibhav.anonymousforum.controllers;

import com.vaibhav.anonymousforum.dtos.UserDTO;
import com.vaibhav.anonymousforum.dtos.UserRequestDTO;
import com.vaibhav.anonymousforum.entities.User;
import com.vaibhav.anonymousforum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*") // Allow CORS for this method
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        UserDTO createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody UserRequestDTO userRequest) {
        return new User(userRequest.getUsername(), userRequest.getPassword());
    }
}
