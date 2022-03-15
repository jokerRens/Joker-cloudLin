package com.joker.designmode.iterator;

import java.util.ArrayList;

/**
 * Waitress
 *
 * @author joker
 * @version 1.0
 * 2022/3/15 14:03
 **/

public class Waitress {

    private ArrayList<Iterator> iterators = new ArrayList<Iterator>();

    public Waitress() {

    }

    public void addIterator(Iterator iterator) {
        iterators.add(iterator);
    }


    public void printMenu() {
        Iterator iterator;
        MenuItem menuItem;
        for (int i = 0, len = iterators.size(); i < len; i++) {
            iterator = iterators.get(i);
            while (iterator.hasNext()) {
                menuItem = (MenuItem) iterator.next();
                System.out.println(menuItem.getName() + "***" + menuItem.getPrice() + "***" + menuItem.getDescription());
            }

        }

    }

    public void printBreakfastMenu() {

    }

    public void printLunchMenu() {

    }

    public void printVegetableMenu() {

    }
}
