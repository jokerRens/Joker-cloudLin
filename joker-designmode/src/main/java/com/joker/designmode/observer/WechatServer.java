package com.joker.designmode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * WechatServer
 *
 * @author joker
 * @version 1.0
 * 2022/3/15 11:29
 **/

public class WechatServer implements Subject{

    private List<Observer> list;

    private String message;

    public WechatServer() {
        list = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if(!list.isEmpty()){
            list.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : list) {
            observer.update(message);
        }
    }


    public void setInformation(String s){
        this.message = s;
        System.out.println("服务更新消息 "+s);
        notifyObserver();
    }

}
