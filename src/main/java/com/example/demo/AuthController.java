package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import com.example.models.AuthResponse;
import com.example.models.Role;
import com.example.models.User;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public AuthResponse login(@RequestBody User user) {
        // TODO: real service

        AuthResponse response = new AuthResponse();
        response.setToken("abcd");

        Role role = new Role();
        role.setName("Admin");
        role.setIsActive(true);
        response.getRoles().add(role);

        return response;
    }
}