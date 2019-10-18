package com.example.provider2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/provider")
    public String demo(){
        return "这里是provider8006";
    }
}
