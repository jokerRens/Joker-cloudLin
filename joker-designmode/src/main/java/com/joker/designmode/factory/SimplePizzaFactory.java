package com.joker.designmode.factory;

/**
 * SimplePizzaFactory
 *
 * @author joker
 * @version 1.0
 * 2022/3/14 11:26
 **/

public class SimplePizzaFactory {

    public Pizza createPizza(String orderType){
        Pizza pizza = null;
        if("cheese".equals(orderType)){
//            pizza = new CheesePizza();
        }else if("greek".equals(orderType)){
//            pizza = new GreekPizza();
        }else if("pepper".equals(orderType)){
//            pizza = new PepperPizza();
        }
        return pizza;
    }
}
