package com.joker.designmode.decorator;

/**
 * Milk
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 11:20
 **/

public class Milk extends Decroter{

    public Milk(Drink obj) {
        super(obj);
        // TODO Auto-generated constructor stub
        super.setDescription("加牛奶");
        super.setPrice(2.0f);
    }
}
