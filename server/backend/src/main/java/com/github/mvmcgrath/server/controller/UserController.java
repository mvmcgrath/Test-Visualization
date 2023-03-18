package com.github.mvmcgrath.server.controller;

import com.github.mvmcgrath.server.exception.ResourceNotFoundException;
import com.github.mvmcgrath.server.model.UserDAO;
import com.github.mvmcgrath.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<UserDAO> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDAO> getUserById(@PathVariable Long id) {
        UserDAO user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("An image does not exist with id: " + id));

        return ResponseEntity.ok(user);
    }
}
