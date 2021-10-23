package com.rabbitmq.provider.receiver;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TopicReceiver {

    @RabbitHandler
    @RabbitListener(queues = "topic.man")
    public void process(Map map){
        System.out.println("TopicReceiver消费者topic.man收到消息:"+map.toString());
    }

    @RabbitHandler
    @RabbitListener(queues = "topic.woman")
    public void process1(Map map){
        System.out.println("TopicReceiver消费者topic.#收到消息:"+map.toString());
    }


}
