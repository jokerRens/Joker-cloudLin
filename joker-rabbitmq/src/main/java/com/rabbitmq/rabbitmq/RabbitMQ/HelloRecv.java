package com.rabbitmq.rabbitmq.RabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 */
@Component
@RabbitListener(queues = "q_joker")     //表示对队列hello进行监听
public class HelloRecv {

    @RabbitHandler  //指定对消息的处理方法；
    public void Recv(String hello){
        System.out.println("HelloRecv:" + hello);
    }

}
