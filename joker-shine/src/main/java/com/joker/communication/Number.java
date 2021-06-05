package com.joker.communication;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-06-05 11:13
 * 两个线程交替打印1-100
 *
 **/
public class Number implements Runnable{

    /**
     *
     * wait():一旦执行此方法、当前线程就进入阻塞状态、并释放同步监视器
     * notify():一旦执行此方法、就会唤醒被wait()的一个线程、如果有多个线程被wait(),就唤醒优先级高的那个
     * notifyAll():一旦执行此方法、就会唤醒所有被wait()的线程.
     *
     * 说明:
     * 1.wait()、notify()、notifyAll()、三个方法只能在同步代码块或者同步方法中
     * 2.wait()、notify()、notifyAll()、三个方法的调用者必须是同步代码块或同步方法中的同步监视器
     * 3.三个方法不是定义在Thread中，而是定义在java.lang.Object类中
     */

    private int number = 1;

    @Override
    public void run() {

        while (true){

            synchronized (this) {

                this.notify();

                if (number <= 100) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        //使得调用如下wait()方法的线程进入阻塞状态
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }


        }

    }
}
