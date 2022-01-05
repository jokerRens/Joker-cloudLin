package com.joker.controller;

import com.joker.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
