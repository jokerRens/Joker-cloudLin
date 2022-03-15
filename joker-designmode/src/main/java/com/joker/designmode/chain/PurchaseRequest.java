package com.joker.designmode.chain;

/**
 * PurchaseRequest
 *
 * @author joker
 * @version 1.0
 * 2022/3/15 14:52
 **/

public class PurchaseRequest {

    private int Type = 0;
    private int Number = 0;
    private float Price = 0;
    private int ID = 0;

    public PurchaseRequest(int type, int number, float price) {
        Type = type;
        Number = number;
        Price = price;
    }

    public int GetType() {
        return Type;
    }

    public float GetSum() {
        return Number * Price;
    }

    public int GetID() {
        return (int) (Math.random() * 1000);
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
