package com.xxc.learnboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller中的属性是bean的名称，与请求地址无关，requestMapping设置请求地址
@RestController("/configenv")
public class EnvReadConfigController {
    @Autowired
    private Environment env;
    @GetMapping("/EnvReadConfig")
    public String envReadConfig() {
        String envProperty = env.getProperty("test.msg");
        return envProperty;
    }
}
