package com.joker.designmode.bridge;

/**
 * Camera
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 15:26
 **/

public class Camera implements Software{

    @Override
    public void run() {
        System.out.println("run camera");
    }
}
