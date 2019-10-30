package com.rabbitmq.rabbitmq.exchangeDirect;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.rabbitmq.util.ConnectionUtils;

public class Recv2 {

    private static final String QUEUE_NAME="test_queue2";
    private static final String EXCHANGE_NAME="test_exchangeDirects";
    public static void main(String []args) throws Exception {
        //获取连接及MQ
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        //声明
        channel.queueDeclare(QUEUE_NAME, false, false, false,null);
        //绑定队列到交换机
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"insert");
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"delete");
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"update");
        //同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);
        //定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //监听队列
        channel.basicConsume(QUEUE_NAME,false,consumer);

        //获取消息
        while (true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("消费者2号"+message);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
        }

    }
}
