package com.example.JobApp.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public boolean validateToken(UserDetails userDetails, String token) {
        return true;
    }


    public String extractUsername(String token) {
        return " ";
    }
}
