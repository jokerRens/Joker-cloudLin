package com.rabbitmq.rabbitmq.exchangeTopic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.rabbitmq.util.ConnectionUtils;

public class send {

    private static final String EXCHANGE_NAME="test_exchangeTopic";
    public static void main(String []args) throws Exception {

        //获取连接及MQ
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        //声明
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        //消息内容
        String message="生产者Topic";
        channel.basicPublish(EXCHANGE_NAME,"routekey.1",null,message.getBytes());

        System.out.println("这里是生产者:"+message);

    }
}
