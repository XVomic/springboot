package com.xxc.learnboot.controller;

import com.xxc.learnboot.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserInfoController {

    @GetMapping("/info")
    public Map<String, Object> getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("id", user.getId());
        userInfo.put("username", user.getUsername());
        userInfo.put("role", user.getRole());
        
        return userInfo;
    }

    @GetMapping("/test-auth")
    public Map<String, String> testAuth() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "如果你看到这条消息，说明你已经成功登录了！");
        return response;
    }
}