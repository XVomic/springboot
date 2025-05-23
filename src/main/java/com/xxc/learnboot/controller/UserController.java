package com.xxc.learnboot.controller;

import com.xxc.learnboot.entity.User;
import com.xxc.learnboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    public static final Logger logger = Logger.getLogger(String.valueOf(UserController.class));

    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public User insert(@RequestBody User user) {
        logger.info(user.toString());
        return this.userService.insert(user);
    }

}
