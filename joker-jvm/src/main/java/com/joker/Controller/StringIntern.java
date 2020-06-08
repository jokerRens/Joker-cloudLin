package com.joker.Controller;


/**
 * String intern 方法
 *
 *  如何保证变量就是指向的是字符串常量池中的数据
 *  方式一: String s = "joker";  字面量定义方式
 *  方拾二: String s = new String("joker").intern();  intern()方法
 *          String s = new StringBuilder("joker").toString().intern();
 *
 *   new String("XXX")  会创建两个对象、
 *        一个是new关键字在堆空间创建的
 *        一个是在字符串常量池中创建的对象
 *
 *     new String("a") + new String("b") 会创建几个对象?
 *        对象1： new StringBuilder()
 *        对象2:  new String("a")
 *        对象3:  常量池中的"a"
 *        对象4:  new String("b")
 *        对象5:  常量池中的"b"
 *
 *     深入解刨: StringBuilder的toString()
 *        对象6: new String("ab")
 *        但是toString()的调用、没有在字符串常量池中生成 "ab"
 *
 */
public class StringIntern {

    public static void main(String[] args) {

        String s1 = new String("1");
        s1.intern();
        String s2 = "1";
        System.out.println(s1 == s2);//  JDK6 :false    JDK7/JDK8 :false


        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";

        System.out.println(s3 == s4);//  JDK6 :false    JDK7/JDK8 :true
    }
}
