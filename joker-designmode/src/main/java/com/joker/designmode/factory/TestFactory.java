package com.joker.designmode.factory;

/**
 * TestFactory
 *
 * @author joker
 * @version 1.0
 * 2022/3/14 9:57
 **/

public class TestFactory {

    /**
     * 工厂模式:
     *    1.简单工厂模式:
     *       定义: 定义了一个创建对象的类，由这个类来封装实例化对象的行为
     *    2.工厂方法模式:
     *       定义: 定义了一个创建对象的抽象方法，由子类决定要实例化的类。工厂方法模式将对象的实例化推迟到子类。
     *
     * @param args
     */
    public static void main(String[] args) {
        // 1.简单工厂模式
        SimplePizzaFactory pizzaFactory = new SimplePizzaFactory();
        pizzaFactory.createPizza("cheese");

        // 2.工厂方法模式

    }
}
