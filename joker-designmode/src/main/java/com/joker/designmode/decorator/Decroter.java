package com.joker.designmode.decorator;

/**
 * Decroter
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 11:17
 **/

public class Decroter extends Drink{
    private Drink Obj;

    public Decroter(Drink obj) {
        this.Obj = obj;
    }

    @Override
    public float cost() {
        return super.getPrice() + Obj.getPrice();
    }

    @Override
    public String getDescription() {
        return super.getDescription()+"-"+super.getPrice()+"&&"+Obj.getDescription();
    }
}
