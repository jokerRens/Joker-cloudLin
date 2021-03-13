package com.joker.synchdetail.synchdetail.volatiles;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.atomic.AtomicInteger;

public class Volatiles {

    public static void main(String[] args) {
        Object o = new Object();

//        o.hashCode();

        //class的布局解析0对象、转成打印模式
        System.out.println(ClassLayout.parseInstance(o).toPrintable());



        synchronized(o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }

    }


    /**
     *   CAS  比较并且交换
     *   compare and swap | compare and exchange
     *
     */
    public static void cas(){
        //自旋锁 AtomicInteger
        AtomicInteger integer = new AtomicInteger();
        integer.incrementAndGet();
    }




}
