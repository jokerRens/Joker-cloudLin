package com.joker.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-05-07 15:49
 **/
public class TransactionalController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    TransactionDefinition transactionDefinition;


    /**
     * 事务 ACID --要么全部成功、要么全部失败
     * 1.Atomicity 原子性
     * 2.Consistency 一致性
     * 3.Lsolation 隔离性
     * 4.Durability 耐久性
     */

    /**
     * mybatis 核心思想
     *
     * 1.sqlsession -- 执行入口 -- 升华版connection
     * 2.mapper接口 -- 本质上去调用sqlsession
     */



    /**
     * ORM框架 三大特点
     * 1.绑定参数 生成SQL
     * 2.执行SQL
     * 3.pojo对象结果映射
     *
     * 纯JDBC方式--使用ORM框架有问题--框架集成--统一事务管理机制
     * 统一事务管理机制:保证同一个连接
     */


    /**
     * jdbc方式事务 【声明式】
     *
     * @throws SQLException
     */
//    @Transactional
    public void demo() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false); //开启事务 -- 关闭自动提交
        Statement statement = connection.createStatement();
        try{
            //业务代码-------------
            statement.execute("sql1");
            statement.execute("sql2");
            int i = 10/0; //人造异常
            //业务代码 ----------

            System.out.println("可以提交");
            connection.commit(); //提交
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("出现异常、事务回滚");
            connection.rollback(); //事务回滚
        }
    }

    /**
     * 编程时事务管理
     * @throws SQLException
     */
    public void demo1() throws SQLException {
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try{
            //业务代码-------------
            jdbcTemplate.execute("sql1");
            jdbcTemplate.execute("sql2");
            int i = 10/0; //人造异常
            //业务代码 ----------
            System.out.println("可以提交");
            dataSourceTransactionManager.commit(transaction); //提交
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("出现异常、事务回滚");
            dataSourceTransactionManager.rollback(transaction); //事务回滚
        }
    }
}
