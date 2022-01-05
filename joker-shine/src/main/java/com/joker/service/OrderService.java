package com.joker.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.joker.bean.Order;
import com.joker.bean.User;
import com.joker.conf.DBConstants;
import com.joker.mapper.OrderMapper;
import com.joker.mapper.UserMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * OrderService
 *
 * @author joker
 * @version 1.0
 * 2022/1/5 16:07
 **/
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;


    //获取到aop的代理对象（如果用this调用此时拿到的不是aop的代理对象）
    private OrderService self() {
        return (OrderService) AopContext.currentProxy();
    }


    //-------------------------场景1----------------------------
    //未开启事务，则可以自己使用自己的数据源，并不会报异常
    public void method01() {
        // 查询订单
        Order order = orderMapper.selectById(1);
        System.out.println(order);
        // 查询用户
        User user = userMapper.selectById(order.getUserId());
        System.out.println(user);
    }


    //-------------------------场景2----------------------------

    //此时开启事务（经过aop代理），会抛出找不到表的情况，因为此时事务开启就会默认拿到默认的数据源user，
    // 而第一次查询是要使用order数据源的，此时因为spring事务则无法从默认的user切换到order数据源上
    //这里就是结合spring事务出现的数据源切换不成功的情况（具体原因后面分析）
    @Transactional
    public void method02() {
        // 查询订单
        Order order = orderMapper.selectById(1);
        System.out.println(order);
        // 查询用户
        User user = userMapper.selectById(1);
        System.out.println(user);
    }




//-------------------------场景3----------------------------

    public void method03() {
        // 查询订单
        self().method031();
        // 查询用户
        self().method032();
    }

    @Transactional // 报错，因为此时获取的是 primary 对应的 DataSource ，即 users 。
    public void method031() {
        Order order = orderMapper.selectById(1);
        System.out.println(order);
    }

    @Transactional
    public void method032() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }




    //-------------------------场景4----------------------------

    //未报异常，正常结束（两个方法各自执行各自的事务，并且根据@DS获取到各自的数据源）
    public void method04() {
        // 查询订单
        self().method041();
        // 查询用户
        self().method042();
    }

    @Transactional
    @DS(DBConstants.DATASOURCE_ORDERS)
    public void method041() {
        Order order = orderMapper.selectById(1);
        System.out.println(order);
    }

    @Transactional
    @DS(DBConstants.DATASOURCE_USERS)
    public void method042() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }



    //-------------------------场景5----------------------------
    //正常执行，05方法中调用052方法，在一个事务中调用另一个事务方法，
    // 另一个事务方法采用，重新建立一个事务的方法并使用自己的数据源
    // 此时在05方法中则会出现两个事务，这时就涉及到分布式事务

    @Transactional
    @DS(DBConstants.DATASOURCE_ORDERS)//声明自己要用到的数据源，这样就不会去拿默认数据源了
    public void method05() {
        // 查询订单
        Order order = orderMapper.selectById(1);
        System.out.println(order);
        // 查询用户
        self().method052();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @DS(DBConstants.DATASOURCE_USERS)
    public void method052() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }



}
