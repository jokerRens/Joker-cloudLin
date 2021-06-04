package com.joker.banktest;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-06-03 09:52
 *
 * 将一个单例模式懒汉式改造成线程安全的
 *

 **/
public class Bank {

    /**
     * 构造器
     */
    public Bank(){

    }

    private volatile static Bank instance= null;

    /**
     *  只能创建一个当前类的实例
     * @return
     */
    public static Bank getinstance(){

        /**
         * 方式一、效率稍低  用到了synchronized，会导致很大的性能开销，并且加锁其实只需要在第一次初始化的时候用到，之后的调用都没必要再进行加锁。
         */
        synchronized (Bank.class){
            if(instance == null){
                instance = new Bank();
            }
        }


        /**
         * 方式二、效率稍高  双重检查锁,先判断对象是否已经被初始化，再决定要不要加锁。
         *
         * 隐患:
         *  实例化对象时，实际上可以分解成以下三个步骤：1.分配内存空间  2.初始化对象  3.将对象指向刚分配的内存空间
         *  但是有些编译器为了性能的原因，可能会将第二步和第三步进行重排序，顺序就成了：1.分配内存空间  2.将对象指向刚分配的内存空间  3.初始化对象
         *
         *  考虑重排序后：a线程为instance 1.分配内存空间 2.指向内存空间 后、 3.b线程此时检查instance不为空return instance后访问(此时对象还未完成初始化)  4.a线程初始化instance
         *  这种情况下b线程的访问是一个初始化未完成的对象。
         *
         *  正确的双检索:需要给instance加上 volatile  关键字、使用了volatile关键字后，重排序被禁止，所有的写（write）操作都将发生在读（read）操作之前。
         *
         */
        if(instance == null){
            synchronized (Bank.class){
                if(instance == null){
                    instance = new Bank();
                }
            }
        }

        return instance;
    }

}
