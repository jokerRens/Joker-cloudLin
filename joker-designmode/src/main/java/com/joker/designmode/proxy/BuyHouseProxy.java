package com.joker.designmode.proxy;

/**
 * BuHouseProxy  代理类
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 13:13
 **/

public class BuyHouseProxy implements BuyHouse{
    private BuyHouse buyHouse;

    public BuyHouseProxy(BuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }

    @Override
    public void buyHouse() {
        System.out.println("买房子前期准备");
        buyHouse.buyHouse();
        System.out.println("买房子后装修");
    }
}
