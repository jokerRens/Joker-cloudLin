package com.joker.designmode.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * TestPrototype
 *
 * @author joker
 * @version 1.0
 * 2022/3/10 16:32
 **/

public class TestPrototype {


    /**
     * 原型模式:
     *  定义：通过复制现有实例来创建新的实例，无需知道相应类的信息。
     *
     * 深拷贝和浅拷贝：
     *  浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
     *  深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。
     *
     *  深复制进行了完全彻底的复制，而浅复制不彻底。
     *
     *  原型模式的clone出来的对象是是不能去影响原型对象的，属于深复制
     *
     *
     *  总结：
     *     1.原型模式的本质就是clone
     *     2.可以解决构建复杂对象的资源消耗问题，能再某些场景中提升构建对象的效率
     *     3.还有一个重要的用途就是保护性拷贝，可以通过返回一个拷贝对象的形式，实现只读的限制
     *
     * @param args
     */

    public static void main(String[] args) {
        //1.非clone情况下发送十次     耗时10104
        int i = 0;
        EventTemplate eventTemplate = new EventTemplate("标题", "内容");
        long start = System.currentTimeMillis();
        while (i<10){
            Mail mail = new Mail(eventTemplate);
            System.out.println(mail.toString());
            //
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        //2.使用clone情况发送十次   耗时1011
//        int i = 0;
//        EventTemplate eventTemplate = new EventTemplate("标题", "内容");
//        long start = System.currentTimeMillis();
//        Mail mail = new Mail(eventTemplate);
//        while (i<10){
//            try {
//                Mail cloneMail = mail.clone();
//                System.out.println(mail.toString());
//            } catch (CloneNotSupportedException e) {
//                e.printStackTrace();
//            }
//            //
//            i++;
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(end-start);
    }

}
