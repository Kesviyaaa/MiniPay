package com.minipay.controller;



import com.minipay.dto.LoginRequest;

import com.minipay.dto.LoginResponse;

import com.minipay.entity.User;

import com.minipay.repository.UserRepository;

import com.minipay.security.JwtUtil;
import java.util.Map;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;



@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        // TODO: Validate credentials and generate token / redirect
        if ("admin@example.com".equals(request.getEmail()) &&
            "admin123".equals(request.getPassword())) {

            return ResponseEntity.ok().body(Map.of("message", "Login successful"));
        } else {
            return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("message", "Invalid email or password"));
        }
    }
}
