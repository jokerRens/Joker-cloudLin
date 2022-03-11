package com.joker.designmode.bridge;

/**
 * Oppo
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 15:28
 **/

public class Oppo extends Phone{

    public Oppo(Software software) {
        super(software);
    }

    @Override
    public void run() {
        software.run();
    }
}
