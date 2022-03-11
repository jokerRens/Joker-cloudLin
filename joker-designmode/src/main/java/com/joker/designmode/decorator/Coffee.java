package com.joker.designmode.decorator;

/**
 * Coffee
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 11:15
 **/

public class Coffee extends Drink{

    @Override
    public float cost() {
        // TODO Auto-generated method stub
        return super.getPrice();
    }
}
