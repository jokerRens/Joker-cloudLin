package com.joker.designmode.adapter;

/**
 * Projector
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 10:03
 **/

public class Projector<T> {

    /**
     * Projector将USB映射为VGA，只有VGA接口才可以连接上投影仪进行投影
     *
     * @param t
     */
    public void projection(T t){
        if(t instanceof VGA){
            System.out.println("开始投影");
            VGA vga = new VGAImpl();
            vga = (VGA)t;
            vga.projection();
        }else {
            System.out.println("接口不匹配，无法投影");
        }
    }
}
