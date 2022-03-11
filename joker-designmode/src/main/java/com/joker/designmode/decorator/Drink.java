package com.joker.designmode.decorator;

/**
 * Drink超类
 *
 *  被装饰的对象和装饰者都继承自同一个超类
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 11:12
 **/

public abstract class Drink {

    public String description = "";

    private float price = 0f;

    public abstract float cost();

    public String getDescription() {
        return description+"-"+this.getPrice();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
