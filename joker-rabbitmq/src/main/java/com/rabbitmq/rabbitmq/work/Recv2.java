package com.rabbitmq.rabbitmq.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.rabbitmq.util.ConnectionUtils;

/**
 * 消费者2号
 */
public class Recv2 {

    private static final String QUEUE_NAME="test_works";
    public static void main(String []args) throws Exception {
        //获取一个连接
        Connection connection = ConnectionUtils.getConnection();
        //获取通道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //监听队列
        channel.basicConsume(QUEUE_NAME, true, consumer);
        //获取消息
        while(true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("消费者2号"+message);
            Thread.sleep(10);   //休眠
        }
    }
}
