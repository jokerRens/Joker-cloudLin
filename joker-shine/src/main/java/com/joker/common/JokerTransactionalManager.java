package com.joker.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-05-10 15:14
 **/
//事务管理器

@Component
public class JokerTransactionalManager {

    Connection connection;

    @Autowired
    DataSource dataSource;


    public Connection getConnection() throws SQLException {
        if(connection == null){
            connection = dataSource.getConnection();
        }

        return  connection;
    }

}
