package com.joker.designmode.prototype;

/**
 * Prototype
 *
 * @author joker
 * @version 1.0
 * 2022/3/10 16:39
 **/
public class Prototype implements Cloneable{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Prototype prototype = (Prototype)super.clone();
        return prototype;
    }
}
