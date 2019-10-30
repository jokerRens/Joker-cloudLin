package com.rabbitmq.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.rabbitmq.util.ConnectionUtils;

public class Recv {

    /**
     * 消费者获取消息
     */

    private static final String QUEUE_NAME="test_simple";

    public static void main(String []args) throws Exception {

        //获取连接
        Connection connection = ConnectionUtils.getConnection();
        //创建频道
        Channel channel = connection.createChannel();
        //定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //监听队列
        channel.basicConsume(QUEUE_NAME, true, consumer);
        //获取消息
        while(true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String msgString = new String(delivery.getBody());
            System.out.println("这里是消费者获取为:"+msgString);
        }
    }

}
