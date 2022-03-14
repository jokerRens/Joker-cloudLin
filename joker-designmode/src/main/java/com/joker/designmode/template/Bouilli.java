package com.joker.designmode.template;

/**
 * Bouilli
 *
 * @author joker
 * @version 1.0
 * 2022/3/14 17:38
 **/

public class Bouilli extends Dish{
    @Override
    public void preparation() {
        System.out.println("切猪肉和土豆。");
    }

    @Override
    public void doing() {
        System.out.println("将切好的猪肉倒入锅中炒一会然后倒入土豆连炒带炖。");
    }

    @Override
    public void carriedDishes() {
        System.out.println("将做好的红烧肉盛进碗里端给客人吃。");
    }
}
