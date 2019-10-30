package com.example.jokerprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class JokerProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(JokerProviderApplication.class, args);
    }

}
