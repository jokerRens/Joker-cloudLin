package com.joker.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-06-05 16:49
 **/
public class ThreadPool {

    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor)service;


        //设置线程池的属性
        System.out.println(service.getClass());
//        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();

        //2.执行指定的线程的操作、需要提供实现Runnable接口或Callable接口实现类的对象
        NumberThread thread = new NumberThread();
        service.execute(thread);//适用于Runnable
//        service.submit();//适用于Callable

        //3.关闭连接池
        service.shutdown();
    }


}
