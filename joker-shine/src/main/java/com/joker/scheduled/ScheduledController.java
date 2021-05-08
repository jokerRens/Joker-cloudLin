package com.joker.scheduled;

import io.swagger.annotations.ApiOperation;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-05-06 16:42
 **/
@Component
public class ScheduledController {


    @Scheduled(cron = "0 0/5 * * * ? ")//每个五分钟执行
    @ApiOperation("定时任务一")
    public void demo(){
        String name = Thread.currentThread().getName() ;
        System.out.println("当前时间:"+ LocalDateTime.now()+"  任务execute1对应的线程名: "+name);
        try {
            System.out.println("任务一");
            Thread.sleep(5000);
            System.out.println("任务一结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "0 0/5 * * * ? ")//每个五分钟执行
    @ApiOperation("定时任务二")
    public void demo1(){
        String name = Thread.currentThread().getName() ;
        System.out.println("当前时间:"+ LocalDateTime.now()+"  任务execute1对应的线程名: "+name);
        try {
            System.out.println("任务二");
            Thread.sleep(2000);
            System.out.println("任务二结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
