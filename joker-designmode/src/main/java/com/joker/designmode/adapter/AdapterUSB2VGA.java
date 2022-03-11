package com.joker.designmode.adapter;

/**
 * AdapterUSB2VGA
 *
 *   类适配器模式:通过多重继承目标接口和被适配者类方式来实现适配
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 10:02
 **/

public class AdapterUSB2VGA extends USBImpl implements VGA{

    @Override
    public void projection() {
        //调用父类方法
        super.showPPT();
    }
}
