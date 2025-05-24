package com.xxc.learnboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/configvalue")
public class ValueReadConfigController {
    @Value("${test.msg}")
    private String msg;

    @GetMapping("value")
    public String value() {
        return msg;
    }
}
