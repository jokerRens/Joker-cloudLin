package com.joker.designmode.template;

/**
 * Dish
 *
 * @author joker
 * @version 1.0
 * 2022/3/14 17:35
 **/

public abstract class Dish {

    protected void dodish(){
        this.preparation();
        this.doing();
        this.carriedDishes();
    }

    public abstract void preparation();

    public abstract void doing();

    public abstract void carriedDishes();

}
