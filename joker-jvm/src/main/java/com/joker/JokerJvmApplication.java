package com.joker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan(basePackageClasses = {com.joker.aops.IBuy.class})
@SpringBootApplication

public class JokerJvmApplication {

    public static void main(String[] args) {
        SpringApplication.run(JokerJvmApplication.class, args);
    }

}
