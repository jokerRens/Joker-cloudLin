package com.joker.seata1.controller;

import lombok.Data;

/**
 * Book
 *
 * @author joker
 * @version 1.0
 * 2022/4/25 13:32
 **/

@Data
public class Book {

    private String name;

    private Double price;

    private String authot;

    public Book(String name, Double price, String authot) {
        this.name = name;
        this.price = price;
        this.authot = authot;
    }

    public Book() {

    }
}
