package com.rabbitmq.provider.conf;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class DelayedMsgRabbitConfig {


    public static final String DELAYED_QUEUE_NAME = "delay.queue.demo";
    public static final String DELAYED_EXCHANGE_NAME = "delay.exchange.demo";
    public static final String DELAYED_ROUTING_KEY = "delay.routingkey.demo";


    @Bean
    public Queue immediateQueue() {
        return new Queue(DELAYED_QUEUE_NAME);
    }

    @Bean
    public CustomExchange  customExchange() {
        //创建一个自定义交换机，可以发送延迟消息
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(DELAYED_EXCHANGE_NAME, "x-delayed-message",true, false,args);
    }



    @Bean
    public Binding bindingNotify(CustomExchange customExchange,Queue immediateQueue){
        return BindingBuilder.bind(immediateQueue).to(customExchange).with(DELAYED_ROUTING_KEY).noargs();
    }

}
