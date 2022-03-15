package com.joker.designmode.observer;

/**
 * User  定义具体观察者，微信公众号的具体观察者为用户User
 *
 * @author joker
 * @version 1.0
 * 2022/3/15 11:26
 **/

public class User implements Observer{

    private String name;

    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read(){
        System.out.println(name+" 收到推送消息 "+message);
    }
}
