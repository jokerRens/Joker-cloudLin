package com.joker.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * User
 *
 * @author joker
 * @version 1.0
 * 2022/1/5 15:47
 **/

@Data
public class User implements Serializable {

    private int id;
    private String username;
    private String password;
    private Date createTime;

}
