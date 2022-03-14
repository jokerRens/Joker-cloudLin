package com.joker.designmode.strategy;

/**
 * TestStrategy
 *
 * @author joker
 * @version 1.0
 * 2022/3/14 15:26
 **/

public class TestStrategy {

    /**
     * 策略模式:
     *     定义:策略模式定义了一系列算法，并将每个算法封装起来，使他们可以相互替换，且算法的变化不会影响到使用算法的客户。
     *     意图：定义一系列的算法,把它们一个个封装起来, 并且使它们可相互替换。
     *     主要解决：在有多种算法相似的情况下，使用 if...else 所带来的复杂和难以维护。
     *     何时使用：一个系统有许多许多类，而区分它们的只是他们直接的行为。
     *     如何解决：将这些算法封装成一个一个的类，任意地替换.
     *     关键代码：实现同一个接口.
     *     优点： 1、算法可以自由切换。 2、避免使用多重条件判断。 3、扩展性良好。
     *     缺点： 1、策略类会增多。 2、所有策略类都需要对外暴露
     *
     * @param args
     */
    public static void main(String[] args) {
        Environment environment = new Environment(new AddStrategy());
        int calculate = environment.calculate(10, 5);
        System.out.println(calculate);

        Environment environment1 = new Environment(new SubstractStrategy());
        int calculate1 = environment1.calculate(10, 5);
        System.out.println(calculate1);
    }
}
