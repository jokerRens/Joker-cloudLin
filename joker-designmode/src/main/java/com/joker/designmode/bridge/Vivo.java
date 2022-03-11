package com.joker.designmode.bridge;

/**
 * Vivo
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 15:30
 **/

public class Vivo extends Phone{

    public Vivo(Software software) {
        super(software);
    }

    @Override
    public void run() {
        software.run();
    }
}
