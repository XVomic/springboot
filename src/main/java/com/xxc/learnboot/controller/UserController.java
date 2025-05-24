package com.xxc.learnboot.controller;

import com.xxc.learnboot.common.Result;
import com.xxc.learnboot.entity.User;
import com.xxc.learnboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
public class UserController {

    public static final Logger logger = Logger.getLogger(String.valueOf(UserController.class));

    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public Result<?> insert(@RequestBody User user) {
        try {
            logger.info("Inserting user: " + user.getUsername());
            User savedUser = userService.insert(user);
            return Result.success(savedUser);
        } catch (Exception e) {
            logger.warning("Failed to insert user: " + e.getMessage());
            return Result.error("添加用户失败: " + e.getMessage());
        }
    }

    @GetMapping("/findByUsername/{username}")
    public Result<?> findByUsername(@PathVariable String username) {
        try {
            User user = userService.findByUsername(username);
            if (user != null) {
                return Result.success(user);
            } else {
                return Result.error("用户不存在");
            }
        } catch (Exception e) {
            logger.warning("Failed to find user: " + e.getMessage());
            return Result.error("查询用户失败: " + e.getMessage());
        }
    }

    @GetMapping("/findById/{id}")
    public Result<?> findById(@PathVariable int id) {
        try {
            return userService.findById(id)
                    .map(Result::success)
                    .orElse(Result.error("用户不存在"));
        } catch (Exception e) {
            logger.warning("Failed to find user: " + e.getMessage());
            return Result.error("查询用户失败: " + e.getMessage());
        }
    }
}
