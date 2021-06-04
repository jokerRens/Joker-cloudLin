package com.joker.banktest;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-06-03 11:20
 **/
public class DieLock {

    /**
     * @param args
     *
     *  死锁:
     *      1.不同的线程分别占用对方需要的同步资源不放弃、都在等待对方放弃自己需要的同步资源、形成了死锁。
     *      2.出现死锁后、不会出现异常、不会出现提示、只是所有线程均处于阻塞状态、无法继续
     *
     */

    public static void main(String[] args) {

        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();


        /**
         *  继承Thread
         */
        new Thread(){
            @Override
            public void run() {
                synchronized (s1){
                    s1.append("a");
                    s2.append("1");

                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s2){
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
                super.run();
            }
        }.start();


        /**
         * 实现Runnable
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2){
                    s1.append("c");
                    s2.append("3");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s1){
                        s1.append("d");
                        s2.append("4");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();



    }


}
