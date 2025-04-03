package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.JwtUtil;
import com.example.demo.entity.User;
import com.example.demo.service.AuthService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody User user) {
        return ResponseEntity.ok(authService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        return authService.findUserByEmail(user.getEmail())
                .filter(u -> authService.verifyPassword(user.getPassword(), u.getPassword()))
                .map(u -> ResponseEntity.ok(jwtUtil.generateToken(u.getEmail())))
                .orElse(ResponseEntity.status(401).body("Invalid Credentials"));
    }
    
    
}
