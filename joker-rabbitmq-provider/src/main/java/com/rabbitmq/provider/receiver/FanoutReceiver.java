package com.rabbitmq.provider.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FanoutReceiver {

    @RabbitHandler
    @RabbitListener(queues = "fanout.A")
    public void prosess1(Map msg){
        System.out.println("FanoutReceiver消费者fanout.A收到消息:"+msg.toString());
    }

    @RabbitHandler
    @RabbitListener(queues = "fanout.B")
    public void prosess2(Map msg){
        System.out.println("FanoutReceiver消费者fanout.B收到消息:"+msg.toString());
    }

    @RabbitHandler
    @RabbitListener(queues = "fanout.C")
    public void prosess3(Map msg){
        System.out.println("FanoutReceiver消费者fanout.C收到消息:"+msg.toString());
    }
}
