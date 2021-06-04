package com.joker.ticketthread;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-06-03 11:53
 **/
public class TicketDemo implements Runnable{


    /**
     * 账户余额
     */
    private int balance = 0;

    @Override
    public void run() {
        synchronized (TicketDemo.class) {
            for (int i = 0; i <= 2; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                balance = balance + 1000;
                System.out.println(Thread.currentThread().getName() + "充值成功当前余额:" + balance);
            }
        }
    }
}
