package com.rabbitmq.rabbitmq.RabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置队列
 * 创建一个消息队列q_joker
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue(){
        return  new  Queue("q_joker");
    }

}
