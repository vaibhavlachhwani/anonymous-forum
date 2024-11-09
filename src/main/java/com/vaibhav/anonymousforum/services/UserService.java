package com.vaibhav.anonymousforum.services;

import com.vaibhav.anonymousforum.dtos.UserDTO;
import com.vaibhav.anonymousforum.dtos.UserRequestDTO;
import com.vaibhav.anonymousforum.entities.User;
import com.vaibhav.anonymousforum.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(UserDTO::new)
                .orElse(null);
    }

    public User getUserObjById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserDTO getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(UserDTO::new)
                .orElse(null);
    }

    public User getUserObjByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public void registerUser(UserRequestDTO userRequest) {
        User savedUser = new User(userRequest.getUsername(), userRequest.getPassword());
        userRepository.save(savedUser);
    }

    public boolean verifyUser(String username, String plainPassword) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            return false;
        }
        // Check if provided password matches the stored hashed password
        return passwordEncoder.matches(plainPassword, user.getPassword());
    }
}
