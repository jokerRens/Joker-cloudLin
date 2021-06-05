package com.joker.threadpool;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-06-05 17:11
 **/
public class NumberThread  implements Runnable{

    /**
     * 背景:经常创建和销毁、使用量特别大的资源、比如并发情况下的线程对性能影响较大
     * 思路:提前创建好多个线程、放入线程池中、使用时直接获取、使用完放回池中、可以避免频繁创建与销毁、实现重复利用。
     * 好处:
     *  1.提高响应速度、减少了创建新线程的时间
     *  2.降低资源消耗、重复利用线程池中的线程、不需要每次都创建
     *  3.便于线程管理
     *     corePoolSize:核心池的大小
     *     maximumPoolSize:最大线程数
     *     keepAliveTime:线程没有任务时最多保持多长时间后会终止
     *
     */
    @Override
    public void run() {
        for (int i = 0;i<=100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }

}
