package com.joker.designmode.bridge;

/**
 * AppStore
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 15:25
 **/

public class AppStore implements Software{
    @Override
    public void run() {
        System.out.println("run app store");
    }
}
