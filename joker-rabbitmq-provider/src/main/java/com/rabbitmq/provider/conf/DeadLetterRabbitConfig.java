package com.rabbitmq.provider.conf;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;


@Configuration
public class DeadLetterRabbitConfig {

    public static final String DEAD_LETTER_QUEUE = "dead.letter.queue";

    public static final String DEAD_LETTER_EXCHANGE = "dead.letter.exchange";

    public static final String DEAD_LETTER_ROUTING_KEY = "dead.letter.routingKey";


    public static final String EXCHANGE = "exchange";

    public static final String QUEUE = "queue";

    public static final String ROUTING_KEY = "routingKey";



    /**
     * 死信队列
     * @return
     */
    @Bean
    public Queue deadLetterQueue(){
        return new Queue(DEAD_LETTER_QUEUE);
    }

    /**
     * 死信交换机
     * @return
     */
    @Bean
    public DirectExchange deadLetterExchange(){
        return new DirectExchange(DEAD_LETTER_EXCHANGE);
    }

    /**
     * 死信队列绑定
     * @return
     */
    @Bean
    public Binding deadLetterBinding(){
        return BindingBuilder.bind(deadLetterQueue()).to(deadLetterExchange()).with(DEAD_LETTER_ROUTING_KEY);
    }


    /**
     * 业务队列 \ 需绑定死信交换机、需匹配死信队列路由
     * @return
     */
    @Bean
    public Queue businessQueue(){
        HashMap<String, Object> map = new HashMap<>(2);
        // 配置当前队列绑定的死信交换器
        map.put("x-dead-letter-exchange",DEAD_LETTER_EXCHANGE);
        // 配置当前队列的死信队列路由key，如果不设置默认为当前队列的路由key
        map.put("x-dead-letter-routing-key",DEAD_LETTER_ROUTING_KEY);
        return QueueBuilder.durable(QUEUE).withArguments(map).build();
    }

    /**
     * 业务交换机
     * @return
     */
    @Bean
    public DirectExchange businessExchange(){
        return new DirectExchange(EXCHANGE);
    }

    /**
     * 业务绑定队列
     * @return
     */
    @Bean
    public Binding queueBinding(){
        return BindingBuilder.bind(businessQueue()).to(businessExchange()).with(ROUTING_KEY);
    }




}
