package com.joker.seata1.controller;

import com.joker.seata1.bean.domain.AccountInfo;
import com.joker.seata1.bean.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
