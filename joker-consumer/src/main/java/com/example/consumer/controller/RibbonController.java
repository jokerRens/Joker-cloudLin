package com.example.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {

    private static final  String REST_URL="http://JOKER-PROVIDER";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getOne")
    public String getOne(){
        return "getOne";
    }


    @GetMapping("/consumer")
    public String Hello(){
        return restTemplate.getForObject(REST_URL+"/provider", String.class);
    }


}
