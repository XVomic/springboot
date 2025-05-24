package com.xxc.learnboot.controller;

import com.xxc.learnboot.common.Result;
import com.xxc.learnboot.config.JwtConfig;
import com.xxc.learnboot.entity.User;
import com.xxc.learnboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
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
    public Result<?> login(@RequestBody User loginUser) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword())
            );

            String jwt = jwtConfig.generateToken(loginUser.getUsername());

            Map<String, String> tokenMap = new HashMap<>();
            tokenMap.put("token", jwt);
            return Result.success(tokenMap);
        } catch (BadCredentialsException e) {
            return Result.error("用户名或密码错误");
        } catch (Exception e) {
            return Result.error("登录失败: " + e.getMessage());
        }
    }

    @PostMapping("/register")
    public Result<?> register(@RequestBody User newUser, @RequestParam(required = false) boolean isAdmin) {
        try {
            if (userService.findByUsername(newUser.getUsername()) != null) {
                return Result.error("用户已存在");
            }

            newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
            if (isAdmin) {
                newUser.setRole("ROLE_ADMIN");
            } else {
                newUser.setRole("ROLE_USER");
            }

            User savedUser = userService.insert(newUser);

            return Result.success("注册成功");
        }catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}