package com.rabbitmq.provider.conf;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;


@Configuration
public class DelayedRabbitConfig {


    public static final String DELAYED_QUEUE = "delayed.queue";

    public static final String DELAYED_EXCHANGE = "delayed.exchange";

    public static final String DELAYED_ROUTING = "delayed.routingkey";


    public static final String DEAD_LETTER_QUEUE = "dead.letter.queue2";

    public static final String DEAD_LETTER_EXCHANGE = "dead.letter.exchange2";

    public static final String DEAD_LETTER_ROUTING_KEY = "dead.letter.routingKey2";


    /**
     * 死信队列
     * @return
     */
    @Bean
    public Queue deadLetterQueue2(){
        return new Queue(DEAD_LETTER_QUEUE);
    }

    /**
     * 死信交换机
     * @return
     */
    @Bean
    public DirectExchange deadLetterExchange2(){
        return new DirectExchange(DEAD_LETTER_EXCHANGE);
    }

    /**
     * 死信队列绑定
     * @return
     */
    @Bean
    public Binding deadLetterBinding2(){
        return BindingBuilder.bind(deadLetterQueue2()).to(deadLetterExchange2()).with(DEAD_LETTER_ROUTING_KEY);
    }


    /**
     * 延迟队列绑定死信队列
     * @return
     */
    @Bean
    public Queue delayedQueue(){
        HashMap<String, Object> hashMap = new HashMap<>(2);
        //这里声明当前队列绑定的死信交换机
        hashMap.put("x-dead-letter-exchange",DEAD_LETTER_EXCHANGE);
        //这里声明当前队列的死信路由key
        hashMap.put("x-dead-letter-routing-key", DEAD_LETTER_ROUTING_KEY);
        // x-message-ttl  声明队列的TTL
        hashMap.put("x-message-ttl",6000);
        return QueueBuilder.durable(DELAYED_QUEUE).withArguments(hashMap).build();
    }

    /**
     * 延迟交换机
     * @return
     */
    @Bean
    public DirectExchange delayedExchange(){
        return new DirectExchange(DELAYED_EXCHANGE);
    }

    /**
     * 延迟队列绑定
     * @return
     */
    @Bean
    public Binding delayedBinding(){
        return BindingBuilder.bind(delayedQueue()).to(delayedExchange()).with(DELAYED_ROUTING);
    }

}
