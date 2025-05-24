package com.xxc.learnboot.controller;

import com.xxc.learnboot.entity.StudentProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigPropertiesController {
    @Autowired
    private StudentProperty studentProperty;

    @GetMapping("/configproperties")
    public String configProperties() {
        return studentProperty.toString();
    }
}
