package com.joker.designmode.adapter;

/**
 * AdapterUSB3VGA
 *
 *   接口适配器模式:
 *   抽象类
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 10:18
 **/

public abstract class AdapterUSB4VGA implements VGA{

    USB usb = new USBImpl();

    @Override
    public void projection() {
        usb.showPPT();
    }
}
