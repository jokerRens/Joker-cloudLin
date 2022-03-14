package com.joker.designmode.strategy;

/**
 * AddStrategy
 *
 * @author joker
 * @version 1.0
 * 2022/3/14 16:10
 **/

public class AddStrategy implements Strategy {

    @Override
    public int calc(int num1, int num2) {
        return num1+num2;
    }
}
