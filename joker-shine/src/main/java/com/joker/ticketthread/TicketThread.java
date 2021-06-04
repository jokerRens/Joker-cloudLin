package com.joker.ticketthread;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-06-03 09:27
 **/
public class TicketThread extends Thread{

    //票总张数100
    private int ticket = 100;

    @Override
    public void run() {
        while (true){
            synchronized(TicketThread.class){
                if(ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+":卖票、票号为:"+ticket);
                    ticket--;
                }else {
                    break;
                }
            }
        }
        super.run();
    }
}
