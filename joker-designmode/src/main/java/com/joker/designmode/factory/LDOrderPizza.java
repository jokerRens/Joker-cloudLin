package com.joker.designmode.factory;

/**
 * LDOrderPizza
 *
 * @author joker
 * @version 1.0
 * 2022/3/14 14:10
 **/

public class LDOrderPizza extends OrderPizza{

    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if("cheese".equals(orderType)){
//            pizza = new LDCheesePizza();
        }else if("pepper".equals(orderType)){
//            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
