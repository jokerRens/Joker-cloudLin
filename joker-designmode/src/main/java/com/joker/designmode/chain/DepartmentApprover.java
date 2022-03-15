package com.joker.designmode.chain;

/**
 * DepartmentApprover
 *
 * @author joker
 * @version 1.0
 * 2022/3/15 14:55
 **/

public class DepartmentApprover extends Approver{

    public DepartmentApprover(String name) {
        super(name + " DepartmentLeader");
    }

    @Override
    public void ProcessRequest(PurchaseRequest request) {
        if ((5000 <= request.GetSum()) && (request.GetSum() < 10000)) {
            System.out.println("**This request " + request.GetID()
                    + " will be handled by " + this.Name + " **");
        } else {
            successor.ProcessRequest(request);
        }

    }
}
