package com.rabbitmq.provider.conf;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;


/**
 * 消息接收处理类 手动确认消息监听类
 * 手动确认模式需要实现 ChannelAwareMessageListener
 */

@Component
public class MyAckReceiverConfig implements ChannelAwareMessageListener {


    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
                //因为传递消息的时候用的map传递,所以将Map从Message内取出需要做些处理
                String msg = message.toString();
                //可以点进Message里面看源码,单引号直接的数据就是我们的map消息数据
                String[] msgArray = msg.split("'");

                Map<String, String> msgMap  = mapStringToMap(msgArray[1].trim(), 4);
                String messageId=msgMap.get("messageId");
                String messageData=msgMap.get("messageData");
                String createTime=msgMap.get("createTime");
                String type=msgMap.get("type");

                if("TestDirectQueue".equals(message.getMessageProperties().getConsumerQueue())){
                    System.out.println("消费的消息来自的队列名为："+message.getMessageProperties().getConsumerQueue());
                    System.out.println("消息成功消费到  messageId:"+messageId+"  messageData:"+messageData+"  createTime:"+createTime);
                    System.out.println("执行TestDirectQueue中的消息的业务处理流程......");
                }

                if ("fanout.A".equals(message.getMessageProperties().getConsumerQueue())){
                    System.out.println("消费的消息来自的队列名为："+message.getMessageProperties().getConsumerQueue());
                    System.out.println("消息成功消费到  messageId:"+messageId+"  messageData:"+messageData+"  createTime:"+createTime);
                    System.out.println("执行fanout.A中的消息的业务处理流程......");

                }

//                System.out.println("MyAckReceiver  messageId:"+messageId+"  messageData:"+messageData+"  createTime:"+createTime+"   type"+type);
//                System.out.println("消费的主题消息来自："+message.getMessageProperties().getConsumerQueue());

                channel.basicAck(deliveryTag,true);//第二个参数，手动确认可以被批处理，当该参数为 true 时，则可以一次性确认 delivery_tag 小于等于传入值的所有消息
    //          channel.basicReject(deliveryTag, true);//第二个参数，true会重新放回队列，所以需要自己根据业务逻辑判断什么时候使用拒绝
        }catch (Exception e){
            channel.basicReject(deliveryTag,false);
            e.printStackTrace();
        }



    }

    //{key=value,key=value,key=value} 格式转换成map
    public static Map<String, String> mapStringToMap(String str,int entryNum ) {
        str = str.substring(1, str.length() - 1);
        String[] strs = str.split(",",entryNum);
        Map<String, String> map = new HashMap<String, String>();
        for (String string : strs) {
            String key = string.split("=")[0].trim();
            String value = string.split("=")[1];
            map.put(key, value);
        }
        return map;
    }


}
