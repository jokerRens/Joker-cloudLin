package com.joker.designmode.chain;

/**
 * GroupApprover
 *
 * @author joker
 * @version 1.0
 * 2022/3/15 14:54
 **/

public class GroupApprover extends Approver{

    public GroupApprover(String name) {
        super(name+ " GroupLeader");
    }

    @Override
    public void ProcessRequest(PurchaseRequest request) {
        if (request.GetSum() < 5000) {
            System.out.println("**This request " + request.GetID() + " will be handled by " + this.Name + " **");
        } else {
            successor.ProcessRequest(request);
        }
    }
}
