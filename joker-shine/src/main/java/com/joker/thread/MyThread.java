package com.joker.thread;

public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("我是一个线程:"+Thread.currentThread().getName());
        super.run();
    }
}
