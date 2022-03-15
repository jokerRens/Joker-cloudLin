package com.joker.designmode.observer;


/**
 * Subject  抽象被观察者接口
 *
 * @author joker
 * @version 1.0
 * 2022/3/15 11:13
 **/

public interface Subject {

    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObserver();

}
