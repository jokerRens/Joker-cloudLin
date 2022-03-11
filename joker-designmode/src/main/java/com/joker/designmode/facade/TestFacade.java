package com.joker.designmode.facade;

/**
 * TestFacade
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 14:40
 **/

public class TestFacade {

    /**
     * 外观模式:
     *    定义：
     *      隐藏了系统的复杂性，并向客户端提供了一个可以访问系统的接口
     *    优点：
     *      - 松散耦合 ： 使得客户端和子系统之间解耦，让子系统内部的模块功能更容易扩展和维护
     *      - 简单易用 ： 客户端根本不需要知道子系统内部的实现，或者根本不需要知道子系统内部的构成，它只需要跟Facade类交互即可
     *      - 更好的划分访问层次 ： 有些方法是对系统外的，有些方法是系统内部相互交互的使用的。子系统把那些暴露给外部的功能集中到门面中，这样就可以实现客户端的使用，很好的隐藏了子系统内部的细节。
     *
     * @param args
     */
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.start();
        System.out.println("*************");
        computer.shutDown();
    }
}
