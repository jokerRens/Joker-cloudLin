package com.example.jokerkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.example.jokerkafka.*"
})
public class JokerKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JokerKafkaApplication.class, args);
    }
}
