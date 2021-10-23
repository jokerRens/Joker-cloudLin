package com.joker.aops;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AppTest {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aopdemo.xml");

        Boy boy = context.getBean("boy", Boy.class);
        Girl girl = context.getBean("girl", Girl.class);
        String buy = boy.buy(35);
        String buy1 = girl.buy(69);
        System.out.println(buy);
        System.out.println(buy1);
    }
}
