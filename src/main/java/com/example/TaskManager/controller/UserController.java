package com.example.TaskManager.controller;

import com.example.TaskManager.model.User;
import com.example.TaskManager.service.UserService;
import com.example.TaskManager.service.jwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private jwtService jwtService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        } else {
            return "Login failed!";
        }
    }
}
