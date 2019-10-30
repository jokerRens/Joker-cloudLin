package com.example.zuul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/provider/zuul")
    public String demo(){
        return "这里是路由8009";
    }
}
