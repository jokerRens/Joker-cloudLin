package com.joker.jokerlog.controller;

import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-07-10 16:39
 **/
@Slf4j
@RestController
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test")
    public String test(){
        LOGGER.debug("debug");
        LOGGER.info("info");
        LOGGER.error("error异常");
        LOGGER.warn("warning");
        return "test";
    }


}
