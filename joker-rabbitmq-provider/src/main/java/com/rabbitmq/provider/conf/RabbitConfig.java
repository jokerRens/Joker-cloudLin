package com.rabbitmq.provider.conf;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 生产者推送消息的消息确认调用回调函数
 * ConfirmCallback:消息发送到 Broker 后触发回调，确认消息是否到达 Broker 服务器，也就是只确认是否正确到达 Exchange 中
 * ReturnCallback:启动消息失败返回，比如路由不到队列时触发回调
 *
 * 推送消息存在四种情况：
 * ①消息推送到server，但是在server里找不到交换机
 * ②消息推送到server，找到交换机了，但是没找到队列
 * ③消息推送到sever，交换机和队列啥都没找到
 * ④消息推送成功
 */

@Configuration
public class RabbitConfig {


    /**
     * 生产者推送消息的消息确认调用回调函数
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);

        //消息发送到 Broker 后触发回调，确认消息是否到达 Broker 服务器，也就是只确认是否正确到达 Exchange 中
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println("ConfirmCallback--相关数据:"+correlationData);
                System.out.println("ConfirmCallback--确认情况:"+ack);
                System.out.println("ConfirmCallback--原因:"+cause);
            }
        });
        //启动消息失败返回，比如路由不到队列时触发回调
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("ReturnCallback--消息:"+message);
                System.out.println("ReturnCallback--回应码:"+replyCode);
                System.out.println("ReturnCallback--回应信息:"+replyText);
                System.out.println("ReturnCallback--交换机:"+exchange);
                System.out.println("ReturnCallback--路由键:"+routingKey);
            }
        });
        return rabbitTemplate;
    }

}
