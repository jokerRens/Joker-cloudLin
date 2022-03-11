package com.joker.designmode.adapter;

/**
 * AdapterUSB3VGA
 *
 *   对象适配器模式:对象适配器和类适配器使用了不同的方法实现适配，对象适配器使用组合，类适配器使用继承
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 10:18
 **/

public class AdapterUSB3VGA implements VGA{

    USB usb = new USBImpl();

    @Override
    public void projection() {
        usb.showPPT();
    }
}
