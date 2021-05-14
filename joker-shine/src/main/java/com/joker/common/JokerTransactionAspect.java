package com.joker.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-05-10 15:33
 **/

@Aspect  //切面编程
@Component //spring组件
public class JokerTransactionAspect {

    @Autowired
    JokerTransactionalManager jokerTransactionalManager;


    //@Before   //插入到前面
    //@After()  //插入到后面
    @Around("@annotation(JokerTransactional)")  //前后
    public Object doTransaction(ProceedingJoinPoint proceedingJoinPoint){

        // TODO 事务控制、 前提、SQL语句基于同一个连接
        Connection connection = null;

        try {
            jokerTransactionalManager.getConnection();
            connection.setAutoCommit(false);

            //业务代码 ==================
            try {
                Object proceed = proceedingJoinPoint.proceed();//调用目标方法、 目标方法:使用该注解的方法
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            //业务代码 ==================

            System.out.println("事务提交");
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("事务回滚");
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    return null;
    }

}
