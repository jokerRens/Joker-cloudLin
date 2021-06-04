package com.joker.ticketthread;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-06-02 14:52
 **/
public class TicketRunnable implements Runnable{

    /**
     * 问题: 多人同时购买车票时、会出现重票、错票、出现线程安全问题
     * 如何出现:当a线程进入购票流程时、验证余票通过后，被沉睡期间、b线程也进入该过程验票通过进行购票
     *          也就是当某个线程操作共享数据时、还未操作完成、其他线程也参与进来则会出现共享数据安全问题
     * 如何解决:当a线程进入购票流程后、不再允许其他线程进入、只能等待a线程操作结束后方可进入、即使a线程出现了阻塞、其他线程也不能进入。
     * java ： 通过同步机制来解决线程安全问题
     *         解决了线程安全问题、但是操作同步代码时、只能有一个线程参与、其他的线程等待、相当于是一个单线程的过程，效率会降低 -- 局限性
     *
     * 方式一:同步代码块
     *   synchronized( 同步监视器 ){
     *        //需要被同步的代码
     *   }
     *   1.操作共享数据的代码、即为需要被同步的代码
     *   2.共享数据:多个线程共同操作的变量、如车票
     *   3.同步监视器: 即为锁、任何一个类的对象、都可以充当锁(多个线程必须共用同一把锁)
     *   4.在实现Runnable接口创建多线程的方式中、我们可以考虑使用this充当同步监视器
     *
     * 方式二:同步方法
     *
     *
     */

    //票总张数100
    private int ticket = 100;

    Object object =  new Object();

    @Override
    public void run() {
        while (true){
//            synchronized(object){
//                if(ticket>0){
//
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    System.out.println(Thread.currentThread().getName()+":卖票、票号为:"+ticket);
//                    ticket--;
//                }else {
//                    break;
//                }
//            }
            show();
        }
    }

    /**
     * 同步方法
     */
    public synchronized void  show(){
            if(ticket>0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":卖票、票号为:"+ticket);
                ticket--;
            }
    }



}
