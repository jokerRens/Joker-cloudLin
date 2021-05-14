package com.joker.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-05-10 14:55
 **/

//极简化的ORM框架  --执行sql
//ORM 框架 -- 绑定参数生成sql、执行sql、pojo对象、结果映射
@Component
public class JokerMapper {

    @Autowired
    DataSource dataSource;

    @Autowired
    JokerTransactionalManager jokerTransactionalManager;

    public void  execute(String sql) throws SQLException {
        //TODO 从事务管理器中拿连接、以保证sql执行在同一个连接上
        Connection connection = jokerTransactionalManager.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(sql);
    }



}
