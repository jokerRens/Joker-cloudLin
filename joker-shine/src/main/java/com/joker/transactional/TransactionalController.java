package com.joker.transactional;

import com.joker.common.JokerMapper;
import com.joker.common.JokerTransactional;
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
     * 编程时事务管理  【代码侵入性高】
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

    @Autowired
    JokerMapper jokerMapper;


    /**
     *  动态增强代码功能 -- AOP 面向切面编程
     *
     *  1.创建注解:public @interface JokerTransactional{}
     *  2.元描述(描述注解的一种方式)
     *    @Retention 定义注解的生命周期:[ source -> class -> runtime ]
     *    @Documented 文档注解,会被javadoc工具文档化
     *    @Inherited 是否让子类继承该注解
     *    @Targer 描述了注解的应用范围
     *
     *    TYPE : 表示可以用来修饰类、接口、注解类型、或枚举类型
     *    PACKAGE : 可以用来修饰包
     *    PARAMETER : 可以用来修饰参数
     *    ANNOTATION_TYPE : 可以用来修饰注解类型
     *    METHOD : 可以用来修饰方法
     *    FIELD : 可以用来修饰属性(包括枚举常量)
     *    CONSTRUCTOR : 可以用来修饰构造器
     *    LOCAL_VARIABLE : 可用来修饰局部变量
     */

    /**
     * 自定义实现 类似spring事务功能
     *
     */
    @JokerTransactional  // 声明 -- 告诉其他代码、这个方法需要进行事务控制
    public void demo2() throws SQLException {
        //业务代码-------------
        jokerMapper.execute("sql1");
        jokerMapper.execute("sql2");
        int i = 10/0; //人造异常
        //业务代码 ----------
    }

}
