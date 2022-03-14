package com.joker.designmode.strategy;

/**
 * Environment
 *
 * @author joker
 * @version 1.0
 * 2022/3/14 16:12
 **/

public class Environment {

    private Strategy strategy;

    public Environment(Strategy strategy) {
        this.strategy = strategy;
    }

    public int calculate(int a, int b){
        return this.strategy.calc(a,b);
    }
}
