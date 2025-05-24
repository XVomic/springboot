package com.xxc.learnboot.controller;

import com.xxc.learnboot.config.JwtConfig;
import com.xxc.learnboot.entity.User;
import com.xxc.learnboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginUser) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword())
        );

        String jwt = jwtConfig.generateToken(loginUser.getUsername());
        
        Map<String, Object> response = new HashMap<>();
        response.put("token", jwt);
        response.put("username", loginUser.getUsername());
        User user = userService.findByUsername(loginUser.getUsername());
        response.put("role", user.getRole());
        
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User newUser, @RequestParam(required = false) boolean isAdmin) {
        if (userService.findByUsername(newUser.getUsername()) != null) {
            return ResponseEntity.badRequest().body("用户名已存在");
        }

        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        if (isAdmin) {
            newUser.setRole("ROLE_ADMIN");
        } else {
            newUser.setRole("ROLE_USER");
        }
        
        User savedUser = userService.insert(newUser);
        
        Map<String, String> response = new HashMap<>();
        response.put("message", "用户注册成功");
        response.put("role", savedUser.getRole());
        return ResponseEntity.ok(response);
    }
}