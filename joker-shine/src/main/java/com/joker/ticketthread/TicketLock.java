package com.joker.ticketthread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-06-03 11:36
 **/
public class TicketLock implements Runnable{


    /**
     * 解决线程安全问题、Lock锁
     *
     *  synchronized 与 lock的异同
     *  相同:二者都可以解决线程安全问题
     *  不同点:1.synchronized机制在执行完相应的同步代码后，会自动释放同步监视器
     *         2.lock需要手动的启动同步lock()，手动结束同步unlock().
     *
     *  1.Lock是显示锁(手动开启和关闭锁)、synchronized是隐式锁、出了作用域自动释放
     *  2.Lock只有代码块锁、synchronized有代码块和方法锁
     *  3.Lock锁、JVM将花费较少的时间来调度线程、性能更好、并且具有更好的扩展性。
     *
     */

    //票总张数100
    private int ticket = 100;

    /**
     * 1.实例化ReentrantLock
     */
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true){

            try {
                /**
                 *  2.调用锁定方法lock()
                 */
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票、票号为:" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }finally {
                /**
                 * 调用解锁方法
                 */
                lock.unlock();
            }

        }
    }
}
