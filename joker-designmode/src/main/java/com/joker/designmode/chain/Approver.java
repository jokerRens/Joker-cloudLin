package com.joker.designmode.chain;

/**
 * Approver  决策者抽象类，包含对请求处理的函数，同时还包含指定下一个决策者的函数
 *
 * @author joker
 * @version 1.0
 * 2022/3/15 14:48
 **/

public abstract class Approver {
    Approver successor;
    String Name;

    public Approver(String name) {
        Name = name;
    }

    public abstract void ProcessRequest(PurchaseRequest request);

    public void Setsuccessor(Approver successor){
        this.successor = successor;
    }

}
