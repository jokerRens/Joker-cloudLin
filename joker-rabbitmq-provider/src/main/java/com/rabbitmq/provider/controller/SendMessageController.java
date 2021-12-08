package com.rabbitmq.provider.controller;

import com.rabbitmq.provider.conf.DeadLetterRabbitConfig;
import com.rabbitmq.provider.conf.DelayedMsgRabbitConfig;
import com.rabbitmq.provider.conf.DelayedRabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@RestController
public class SendMessageController {

    /**
     * 使用RabbitTemplate,这提供了接收/发送等等方法
     */
    @Autowired
    RabbitTemplate rabbitTemplate;


    /**
     * Direct直连方式消息发送
     * @param msg
     * @return
     */
    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage(String msg){
        String messageId = String.valueOf(UUID.randomUUID());
//        String messageData = "七里香 DirectMessage";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        HashMap<String, Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",msg);
        map.put("createTime",createTime);
        map.put("type","1");
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange","TestDirectRouting",map);
        return "发送成功";
    }


    /**
     * Topic订阅方式消息发送
     * @param msg
     * @return
     */
    @GetMapping("/sendTopicMessage1")
    public String sendTopicMessage1(String msg){
        String messageId = String.valueOf(UUID.randomUUID());
//        String messageData = "七里香 DirectMessage";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        HashMap<String, Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",msg);
        map.put("createTime",createTime);
        map.put("type","主题类型");
        //将消息主题：topic.man 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("topicExchange","topic.man",map);
        return "发送成功";
    }

    /**
     * Topic订阅方式消息发送
     * @param msg
     * @return
     */
    @GetMapping("/sendTopicMessage2")
    public String sendTopicMessage2(String msg){
        String messageId = String.valueOf(UUID.randomUUID());
//        String messageData = "七里香 DirectMessage";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        HashMap<String, Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",msg);
        map.put("createTime",createTime);
        map.put("type","主题类型");
        //将消息主题：topic.man 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("topicExchange","topic.woman",map);
        return "发送成功";
    }


    /**
     * Fanout扇形方式消息发送
     * @param msg
     * @return
     */
    @GetMapping("/sendFanoutMessage")
    public String sendFanoutMessage(String msg){
        String messageId = String.valueOf(UUID.randomUUID());
//        String messageData = "七里香 DirectMessage";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        HashMap<String, Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",msg);
        map.put("createTime",createTime);
        map.put("type","扇形");
        //将消息主题：topic.man 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("fanoutExchange",null,map);
        return "发送成功";
    }


    /**
     *  消息推送存在四种情况 ①消息推送到server，但是在server里找不到交换机  （触发：ConfirmCallback 回调函数）
     *  把消息推送到名为‘notAckExchange’的交换机上（这个交换机是没有创建没有配置的）
     * @param msg
     * @return
     */
    @GetMapping("/testMessageACK1")
    public String testMessageACK1(String msg){
        String messageId = String.valueOf(UUID.randomUUID());
//        String messageData = "七里香 DirectMessage";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        HashMap<String, Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",msg);
        map.put("createTime",createTime);
        map.put("type","ACK测试");
        //将消息主题：topic.man 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("notAckExchange",null,map);
        return "发送成功";
    }


    /**
     *  消息推送存在四种情况 ②消息推送到server，找到交换机Exchange了，但是没找到队列  （触发：ConfirmCallback 与 ReturnCallback 回调函数）
     *  这种情况就是需要新增一个交换机，但是不给这个交换机绑定队列
     *  在DirectRabitConfig里面新增一个直连交换机，名叫‘lonelyDirectExchange’，但没给它做任何绑定配置操作
     *  把消息推送到名为‘lonelyDirectExchange’的交换机上（这个交换机是没有任何队列配置的）
     *
     *
     * 两个函数都被调用了:
     * 这种情况下，消息是推送成功到服务器了的，所以ConfirmCallback对消息确认情况是true；
     * 而在RetrunCallback回调函数的打印参数里面可以看到，消息是推送到了交换机成功了，但是在路由分发给队列的时候，找不到队列，所以报了错误 NO_ROUTE 。
     *
     * @param msg
     * @return
     */
    @GetMapping("/testMessageACK2")
    public String testMessageACK2(String msg){
        String messageId = String.valueOf(UUID.randomUUID());
//        String messageData = "七里香 DirectMessage";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        HashMap<String, Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",msg);
        map.put("createTime",createTime);
        map.put("type","ACK测试");
        //将消息主题：topic.man 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("lonelyDirectExchange","TestDirectRouting",map);
        return "发送成功";
    }


    /**
     *  消息推送存在四种情况 ③消息推送到sever，交换机和队列啥都没找到   （触发：ConfirmCallback 回调函数）
     *  与①情况一致
     *  把消息推送到名为 null 的交换机上（这个交换机是没有创建没有配置的）
     * @param msg
     * @return
     */
    @GetMapping("/testMessageACK3")
    public String testMessageACK3(String msg){
        String messageId = String.valueOf(UUID.randomUUID());
//        String messageData = "七里香 DirectMessage";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        HashMap<String, Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",msg);
        map.put("createTime",createTime);
        map.put("type","ACK测试");
        //将消息主题：topic.man 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("notAckExchange",null,map);
        return "发送成功";
    }




    /**
     *  死信队列测试
     * @param msg
     * @return
     */
    @GetMapping("/sendDeadLetterMessage")
    public String sendDeadLetterMessage(String msg){
        String messageId = String.valueOf(UUID.randomUUID());
//        String messageData = "七里香 DirectMessage";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        HashMap<String, Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",msg);
        map.put("createTime",createTime);
        map.put("type","死信测试");
        //将消息主题：topic.man 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend(DeadLetterRabbitConfig.EXCHANGE,DeadLetterRabbitConfig.ROUTING_KEY,map
//                message -> {
//            MessageProperties properties = message.getMessageProperties();
//            //设置这条消息的过期时间（毫秒）
//            properties.setExpiration("10000");
//            return message;
//        }
        );
        return "发送成功";
    }




    /**
     *  延迟队列测试（基于队列）
     * @param msg
     * @return
     */
    @GetMapping("/sendDelayedMessage")
    public String sendDelayedMessage(String msg,String time){
        String messageId = String.valueOf(UUID.randomUUID());
//        String messageData = "七里香 DirectMessage";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        HashMap<String, Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",msg);
        map.put("createTime",createTime);
        map.put("type","延迟测试");
        //将消息主题：topic.man 发送到交换机TestDirectExchange
        System.out.println("发送消息:"+new Date()+"--时间："+map.toString());
        rabbitTemplate.convertAndSend(DelayedRabbitConfig.DELAYED_EXCHANGE, DelayedRabbitConfig.DELAYED_ROUTING, map);
        return "发送成功";
    }




    /**
     *  延迟队列测试(基于消息)
     * @param msg
     * @return
     */
    @GetMapping("/sendDelayedMsgMessage")
    public String sendDelayedMsgMessage(String msg,Integer time){
        String messageId = String.valueOf(UUID.randomUUID());
//        String messageData = "七里香 DirectMessage";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        HashMap<String, Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",msg);
        map.put("createTime",createTime);
        map.put("type","延迟消息测试");
        //将消息主题：topic.man 发送到交换机TestDirectExchange
        System.out.println("发送消息:"+new Date()+"--时间："+map.toString());
        rabbitTemplate.convertAndSend(DelayedMsgRabbitConfig.DELAYED_EXCHANGE_NAME, DelayedMsgRabbitConfig.DELAYED_ROUTING_KEY, map, a->{
            a.getMessageProperties().setDelay(time);
            return a;
        });
        return "发送成功";
    }





















}
