package com.joker.synchdetail.synchdetail.volatiles;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class HelloVolatile {

    public static void main(String[] args) {
        HelloVolatile helloVolatile = new HelloVolatile();
        new Thread(helloVolatile::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        helloVolatile.running = false;

    }

    /***
     *   volatile 最基本的功能是保证线程之间的可见性、保证CPU之间的可见性
     */

    volatile boolean running = true;

    void m(){
        System.out.println("m,start");
        while (running){

        }
        System.out.println("m,end");
    }


}
