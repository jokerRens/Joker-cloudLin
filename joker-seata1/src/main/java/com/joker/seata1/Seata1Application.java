package com.joker.seata1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@EnableAspectJAutoProxy  //开启AOP
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan(basePackages = "com.joker.seata1.bean.mapper")//扫描mapper接口
public class Seata1Application {

    public static void main(String[] args) {
        SpringApplication.run(Seata1Application.class, args);
    }

}
