package com.example.jokereureka.jokereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class JokerEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JokerEurekaApplication.class, args);
    }

}
