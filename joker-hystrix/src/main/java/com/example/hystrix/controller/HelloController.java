package com.example.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeoutException;

@RestController
public class HelloController {

    @GetMapping("/provider")
    @HystrixCommand(fallbackMethod = "Fallback")
    public String demo(Long id){
        if (id>5){
            throw new RuntimeException("ID入参异常");
        }
        return "这里是provider8008";
    }


    public  String Fallback(Long id){
        return "这里是Hystrix熔断机制、ID："+id+"数据过载!";
    }

}
