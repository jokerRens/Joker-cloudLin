package com.rabbitmq.provider.conf;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Topic主题交换机
 * 主题交换机，这个交换机其实跟直连交换机流程差不多，但是它的特点就是在它的路由键和绑定键之间是有规则的.
 * *  (星号) 用来表示一个单词 (必须出现的)
 * #  (井号) 用来表示任意数量（零个或多个）单词
 *
 */

@Configuration
public class TopicRabbitConfig {

    /**
     * 绑定键
     */
    public final static String man = "topic.man";
    public final static String woman = "topic.woman";

    /**
     * 队列
     * @return
     */
    @Bean
    public Queue manQueue(){
        return new Queue(man);
    }

    @Bean
    public Queue womanQueue(){
        return new Queue(woman);
    }

    /**
     * topic 交换机
     * @return
     */
    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    /**
     * 将manQueue和topicExchange绑定,而且绑定的键值为topic.man
     * 这样只要是消息携带的路由键是topic.man,才会分发到该队列
     * @return
     */
    @Bean
    Binding topicBindingExchangeMessage(){
        return BindingBuilder.bind(manQueue()).to(topicExchange()).with(man);
    }

    /**
     * 将womanQueue和topicExchange绑定,而且绑定的键值为用上通配路由键规则topic.#
     * 这样只要是消息携带的路由键是以topic.开头,都会分发到该队列
     * @return
     */
    @Bean
    Binding topicBindingExchangeMessage2(){
        return BindingBuilder.bind(womanQueue()).to(topicExchange()).with("topic.#");
    }






}
