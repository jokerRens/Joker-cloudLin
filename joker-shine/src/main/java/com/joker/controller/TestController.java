package com.joker.controller;

import com.joker.bean.Order;
import com.joker.bean.User;
import com.joker.mapper.OrderMapper;
import com.joker.mapper.UserMapper;
import com.joker.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TestController
 *
 * @author joker
 * @version 1.0
 * 2022/1/5 16:08
 **/

@RestController
public class TestController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;



    //场景1
    @GetMapping("/method1")
    public void getMethod1(){

        orderService.method01();
    }

    //场景2
    @GetMapping("/method2")
    public void getMethod2(){

        orderService.method02();
    }
    //场景3
    @GetMapping("/method3")
    public void getMethod3(){

        orderService.method03();
    }
    //场景4
    @GetMapping("/method4")
    public void getMethod4(){

        orderService.method04();
    }
    //场景5
    @GetMapping("/method5")
    public void getMethod5(){

        orderService.method05();
    }

    //场景6
    @GetMapping("/method6")
    public void getMethod6(){
        orderService.method06();
    }

    @GetMapping("/method7")
    public void getMethod7(){
//        List<Order> orders = orderMapper.selectList(null);
//        System.out.println(orders.toString());
        Order order = new Order();
        order.setId(5);
        order.setUserId(5);
        int insert = orderMapper.insert(order);
        System.out.println(insert);
        List<User> users = userMapper.selectList(null);
        System.out.println(users.toString());
    }


}
