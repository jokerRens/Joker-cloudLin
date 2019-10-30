package com.rabbitmq.rabbitmq.RabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class HelloSend {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//24小时制
        //消息
        String message = "这里是消息message";
        System.out.println("send:"+message);
        this.amqpTemplate.convertAndSend("q_joker", message);
    }

}
