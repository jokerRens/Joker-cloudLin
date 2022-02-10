package com.joker;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-05-06 16:17
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.joker.bean.mapper")
public class JokerMybatisPlusApplicaton {

    public static void main(String[] args) {
        SpringApplication.run(JokerMybatisPlusApplicaton.class, args);
    }


}
