package com.joker.ticketthread;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-06-02 14:51
 **/
public class TicketTest {

    public static void main(String[] args) {
        TicketRunnable ticket = new TicketRunnable();
        TicketThread thread = new TicketThread();
        TicketLock lock = new TicketLock();

        Thread t1 = new Thread(lock);
        Thread t2 = new Thread(lock);
        Thread t3 = new Thread(lock);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

//        t1.start();
//        t2.start();
//        t3.start();


        TicketDemo demo = new TicketDemo();
        Thread t4 = new Thread(demo);
        Thread t5 = new Thread(demo);
        t4.setName("四号储户");
        t5.setName("五号储户");

        t4.start();
        t5.start();
    }

}
