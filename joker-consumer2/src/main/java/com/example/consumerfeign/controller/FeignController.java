package com.example.consumerfeign.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FeignController
 */
@RestController
public class FeignController {

        @GetMapping(value = "/consumer/feign")
        public String Feigns(){
                return "哈哈";
        }



}
