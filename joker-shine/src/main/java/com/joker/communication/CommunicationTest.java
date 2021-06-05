package com.joker.communication;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-06-05 11:13
 **/
public class CommunicationTest {

    public static void main(String[] args) {

        Number number = new Number();

        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();

    }

}
