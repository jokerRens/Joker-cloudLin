package com.joker.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Order
 *
 * @author joker
 * @version 1.0
 * 2022/1/5 15:46
 **/


@Data
public class Order implements Serializable {

    private int id;
    private int userId;

}
