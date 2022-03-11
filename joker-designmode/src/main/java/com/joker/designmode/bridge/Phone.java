package com.joker.designmode.bridge;

/**
 * Phone
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 15:27
 **/

public abstract class Phone {
    protected Software software;

    public Phone(Software software) {
        this.software = software;
    }

    public abstract void run();
}
