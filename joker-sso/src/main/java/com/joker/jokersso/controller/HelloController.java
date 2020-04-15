package com.joker.jokersso.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {

    @GetMapping("/oauth/user")
    public Principal user(Principal principal){
        return principal;
    }

}
