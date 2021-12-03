package com.rabbitmq.provider.receiver;

import com.rabbitmq.client.Channel;
import com.rabbitmq.provider.conf.DelayedMsgRabbitConfig;
import com.rabbitmq.provider.conf.MyAckReceiverConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Component
public class DelayMsgReceiver {

    @RabbitListener(queues = DelayedMsgRabbitConfig.DELAYED_QUEUE_NAME)
    @RabbitHandler
    public void receiveD(Message message, Channel channel) throws IOException {
        String msg = message.toString();
        String[] msgArray = msg.split("'");
        Map<String, String> msgMap  = MyAckReceiverConfig.mapStringToMap(msgArray[1].trim(), 4);
        System.out.println("收到消息:"+new Date()+"--时间："+msgMap.toString());
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

}
