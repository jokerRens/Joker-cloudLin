package com.joker.designmode.factory;

/**
 * NYOrderPizza
 *
 * @author joker
 * @version 1.0
 * 2022/3/14 14:14
 **/

public class NYOrderPizza extends OrderPizza{

    @Override
    Pizza createPizza(String ordertype) {
        Pizza pizza = null;
        if (ordertype.equals("cheese")) {
//            pizza = new NYCheesePizza();
        } else if (ordertype.equals("pepper")) {
//            pizza = new NYPepperPizza();
        }
        return pizza;
    }
}
