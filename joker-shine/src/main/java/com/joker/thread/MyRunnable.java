package com.joker.thread;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-05-15 10:31
 **/
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("我是一个线程:"+Thread.currentThread().getName());
    }
}
