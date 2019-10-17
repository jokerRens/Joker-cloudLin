package com.example.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String Hello(){
        return restTemplate.getForObject("http://127.0.0.1:8005/provider", String.class);
    }


}
