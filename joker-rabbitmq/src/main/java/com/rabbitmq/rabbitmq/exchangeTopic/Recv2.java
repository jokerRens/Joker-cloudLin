package com.rabbitmq.rabbitmq.exchangeTopic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.rabbitmq.util.ConnectionUtils;

public class Recv2 {

    private static final String QUEUE_NAME="test_topic1";
    private static final String EXCHANGE_NAME="test_exchangeDirects";
    public static void main(String []args) throws Exception {

        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"*");
        channel.basicQos(1);
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME,false,consumer);
        while(true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("消费者2号"+message);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
        }

    }

}
