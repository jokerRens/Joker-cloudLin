package com.joker;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-05-06 16:17
 **/
@SpringBootApplication
@EnableScheduling
//@EnableAspectJAutoProxy  //开启AOP
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan(basePackages = "com.joker.mapper")//扫描mapper接口
public class JokerShineApplicaton {

    public static void main(String[] args) {
        SpringApplication.run(JokerShineApplicaton.class, args);
    }

//    @Bean
//    public TaskScheduler taskScheduler() {
//        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
//        taskScheduler.setPoolSize(50);
//        return taskScheduler;
//    }
}
