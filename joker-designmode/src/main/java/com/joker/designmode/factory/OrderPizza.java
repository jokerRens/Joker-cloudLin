package com.joker.designmode.factory;

/**
 * OrderPizza
 *
 * @author joker
 * @version 1.0
 * 2022/3/14 14:09
 **/

public abstract class OrderPizza {

    abstract Pizza createPizza(String ordertype);
}
