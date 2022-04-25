package com.joker.seata1.controller;

import com.joker.seata1.bean.domain.AccountInfo;
import com.joker.seata1.bean.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TestController
 *
 * @author joker
 * @version 1.0
 * 2022/4/20 14:55
 **/

@RestController
public class TestController {

    @Autowired
    private AccountInfoService accountInfoService;

    @GetMapping("/test1")
    public String test1(){
        List<AccountInfo> list = accountInfoService.list();
        return list.get(0).toString();
    }

    @GetMapping("/test2")
    public String test2(){
        return "成功 test2";
    }

    @GetMapping("/test3")
    public String test3(String name){
        return "收到值："+name;
    }

    @GetMapping("/test4")
    public String test4(String name, String title){
        return "收到值："+name+"收到title:"+title;
    }

    @GetMapping("/test5")
    public Book test5(){
        return new Book("本草纲目",9.9,"jay");
    }

    @PostMapping("/test6")
    public Book test6(@RequestBody Book book) {
        String name = book.getName();
        System.out.println(name);
        book.setName(name);
        book.setPrice(33.0);
        book.setAuthot("jay");
        return book;
    }
}
