package com.joker.designmode.chain;

/**
 * Client
 *
 * @author joker
 * @version 1.0
 * 2022/3/15 14:53
 **/

public class Client {

    public Client() {
    }

    public PurchaseRequest sendRequst(int Type, int Number, float Price) {
        return new PurchaseRequest(Type, Number, Price);
    }
}
