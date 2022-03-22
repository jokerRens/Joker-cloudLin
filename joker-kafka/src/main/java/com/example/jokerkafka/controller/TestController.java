package com.example.jokerkafka.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试kafka生产者
 */
@RestController
@RequestMapping("/kafka")
public class TestController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping("/send")
    public String send(String msg){
        System.out.println("开始发送消息:"+msg);
        kafkaTemplate.send("jokersend1", msg);
        System.out.println("发送成功");
        return "success";
    }

    @RequestMapping("/sendMessage2")
    public void sendMessage2(String msg){
        System.out.println("开始发送消息:"+msg);
        kafkaTemplate.send("jokertest",msg).addCallback(success -> {
            // 消息发送到的topic
            String topic = success.getRecordMetadata().topic();
            // 消息发送到的分区
            int partition = success.getRecordMetadata().partition();
            // 消息在分区内的offset
            long offset = success.getRecordMetadata().offset();
            System.out.println("发送消息成功:" + topic + "-" + partition + "-" + offset);
        },failure -> {
            System.out.println("发送消息失败:" + failure.getMessage());
        });
    }

    @RequestMapping("/sendMessage3")
    public void sendMessage3(String msg){
        System.out.println("开始发送消息:"+msg);
        kafkaTemplate.send("jokertest",msg).addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("发送消息成功：" + result.getRecordMetadata().topic() + "-"
                        + result.getRecordMetadata().partition() + "-" + result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("发送消息失败："+throwable.getMessage());
            }

        });
    }

    @RequestMapping("/sendMessage4")
    public void sendMessage4(String msg){
        System.out.println("开始发送消息:"+msg);
        // 声明事务：后面报错消息不会发出去
        kafkaTemplate.executeInTransaction(operations->{
            operations.send("jokertest",msg);
            throw new RuntimeException();
        });
        // 不声明事务：后面报错但前面消息已经发送成功了
        kafkaTemplate.send("topic1","test executeInTransaction");
        System.out.println("发送消息成功");
        throw new RuntimeException("fail");
    }

}
