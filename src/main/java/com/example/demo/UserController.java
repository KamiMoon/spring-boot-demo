package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.User;
import com.example.demo.services.UserService;

@RestController
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/users")
    public List<User> users() {
        return this.userService.getUsers();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        return this.userService.getUser(id);
    }
}