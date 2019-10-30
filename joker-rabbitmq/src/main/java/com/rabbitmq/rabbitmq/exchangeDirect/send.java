package com.rabbitmq.rabbitmq.exchangeDirect;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.rabbitmq.util.ConnectionUtils;

public class send {

    private static final String EXCHANGE_NAME="test_exchangeDirects";
        public static void main(String []args) throws Exception {
        //获取连接及MQ
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        //声明
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");   //交换机类型
        //消息内容
        String message = "路由模式";
        channel.basicPublish(EXCHANGE_NAME, "delete", null, message.getBytes());
        System.out.println("路由模式生产者:"+message);
        channel.close();
        connection.close();
    }


}
