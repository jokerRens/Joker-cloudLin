package com.rabbitmq.rabbitmq.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
public class ConnectionUtils {

    /***
     * 获取MQ的链接
     */
    public static Connection getConnection()throws Exception{

        //定义一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务器地址
        factory.setHost("127.0.0.1");
        //AMQP
        factory.setPort(5672);
        //vhost
        factory.setVirtualHost("/vhost_joker");
        //用户名
        factory.setUsername("joker");
        //密码
        factory.setPassword("123456");
        // 通过工程获取连接
        return factory.newConnection();
    }

}
