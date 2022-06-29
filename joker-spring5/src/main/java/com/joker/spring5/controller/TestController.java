package com.joker.spring5.controller;

import com.joker.spring5.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Test
 *
 * @author joker
 * @version 1.0
 * 2022/5/11 14:28
 **/

public class TestController {

    @Test
    public void testAdd(){
        ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("mapper/bean1.xml");
        User user = xmlApplicationContext.getBean("user", User.class);
        User user1 = xmlApplicationContext.getBean("user", User.class);
        System.out.println(user);
        System.out.println(user1);
        user.add();

    }
}
