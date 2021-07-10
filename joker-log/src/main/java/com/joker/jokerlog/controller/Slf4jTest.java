package com.joker.jokerlog.controller;

import groovy.util.logging.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-07-10 11:15
 **/
@Slf4j
@SpringBootTest
public class Slf4jTest {

//    private static final Logger sucLog = LoggerFactory.getLogger("task_suc");
//    private static final Logger failLog = LoggerFactory.getLogger("task_fail");
    private static final Logger LOGGER = LoggerFactory.getLogger(Slf4jTest.class);

    @Test
    public void log4j2() {
//        sucLog.debug("task_suc debug");
//        sucLog.info("task_suc info");
//        sucLog.warn("task_suc warn");
//        sucLog.error("task_suc error");

//        failLog.debug("task_fail debug");
//        failLog.info("task_fail info");
//        failLog.warn("task_fail warn");
//        failLog.error("task_fail error");

//        log.debug("normal debug");
//        log.info("normal info");
//        log.warn("normal warn");
//        log.error("normal error");

// 日志输出
//        for (int i = 0; i < 100; i++) {
//            LOGGER.error("error");
//            LOGGER.warn("warning");
//            LOGGER.info("info");    // 默认的日志级别信息
//            LOGGER.debug("debug");
//            LOGGER.trace("trace");  // 追踪信息
//        }
        // 使用占位符输出日志信息
        String name = "java_log";
        Integer age = 18;
        LOGGER.info("用户：{}，{}", name, age);

        // 将系统的异常信息输出
        try {
            int i = 1 / 0;
        } catch (Exception e){
            // e.printStackTrace();
            LOGGER.error("出现异常：", e);
        }
//        LOGGER.debug("sys debug");
//        LOGGER.info("sys info");
//        LOGGER.warn("sys warn");
//        LOGGER.error("sys error");


    }



}
