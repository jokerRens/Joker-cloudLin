package com.joker.designmode.decorator;

/**
 * Decaf
 *   coffee类的实现
 * @author joker
 * @version 1.0
 * 2022/3/11 11:15
 **/

public class Decaf extends Coffee{

    public Decaf() {
        super.setDescription("Decaf");
        super.setPrice(3.0f);
    }
}
