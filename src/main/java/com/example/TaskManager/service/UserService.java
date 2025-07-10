package com.example.TaskManager.service;

import com.example.TaskManager.repository.UserRepo;
import com.example.TaskManager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return (User) repo.save(user);
    }

    public User findByUsername(String username) {
        return repo.findByUsername(username);
    }
}
