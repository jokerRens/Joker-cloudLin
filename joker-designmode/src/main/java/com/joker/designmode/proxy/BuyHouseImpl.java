package com.joker.designmode.proxy;

/**
 * BuyHouseImpl
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 13:12
 **/

public class BuyHouseImpl implements BuyHouse{
    
    @Override
    public void buyHouse() {
        System.out.println("买房子");
    }
}
