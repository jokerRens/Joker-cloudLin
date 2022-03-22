package com.example.jokerkafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * KafkaConsumer
 *
 * @author joker
 * @version 1.0
 * 2022/3/18 16:18
 **/

@Component
public class KafkaConsumer {

    @Autowired
    private ConsumerFactory consumerFactory;

    @KafkaListener(topics = {"jokertest"})
    public void onMessage(ConsumerRecord record) {
        System.out.println("=========================消费消息 START ===========================");
        System.out.println(record.toString());
        System.out.println(record.topic() + "-" + record.partition() + "-" + record.value());
        System.out.println("=========================消费消息 END ===========================");
    }


    /**
     * 指定topic、partition、offset消费
     * id: 消费者ID
     * groupId: 消费者组ID
     * topics: 监听的topic，可监听多个
     * topicPartitions: 可配置更加详细的监听信息，可指定topic、parition、offset监听
     * 含义 : 监听topic1的0号分区，同时监听topic2的0号分区和topic2的1号分区里面offset从8开始的消息
     * 注意：topics和topicPartitions不能同时使用
     **/
//    @KafkaListener(id = "consumer1",groupId = "test",topicPartitions = {
//            @TopicPartition(topic = "topic1",partitions = {"0"}),
//            @TopicPartition(topic = "topic2",partitions = "0",partitionOffsets = @PartitionOffset(partition = "1",initialOffset = "8"))
//    })
    public void onMessage2(ConsumerRecord record) {
        System.out.println("=========================消费消息 START ===========================");
        System.out.println(record.toString());
        System.out.println(record.topic() + "-" + record.partition() + "-" + record.value());
        System.out.println("=========================消费消息 END ===========================");
    }


    /**
     * 批量消费
     *
     * @param record
     */
//    @KafkaListener(topics = {"jokertest"})
    public void onMessage3(List<ConsumerRecord> record) {
        System.out.println("=========================消费消息 START ===========================");
        System.out.println("此次批量消费条数:" + record.size());
        for (ConsumerRecord consumerRecord : record) {
            System.out.println(consumerRecord.topic() + "-" + consumerRecord.partition() + "-" + consumerRecord.value());
        }
        System.out.println("=========================消费消息 END ===========================");
    }


    /**
     * 异常处理器，用@Bean注入
     *
     * @return
     */
    @Bean
    public ConsumerAwareListenerErrorHandler consumerAwareListenerErrorHandler() {
        return (message, exception, consumer) -> {
            System.out.println("消费异常：" + message.getPayload());
            return null;
        };
    }

    /**
     * 将这个异常处理器的BeanName放到@KafkaListener注解的errorHandler属性里面
     *
     * @param record
     * @throws Exception
     */
    @KafkaListener(topics = {"jokererror"}, errorHandler = "consumerAwareListenerErrorHandler")
    public void onMessage4(ConsumerRecord record) throws Exception {
        throw new Exception("简单消费-模拟异常");
    }


    /**
     * 消息过滤器
     * 可以在消息抵达consumer之前被拦截
     * 筛选出需要的信息再交由KafkaListener处理，不需要的消息则过滤掉
     *配置消息过滤只需要为 监听器工厂 配置一个RecordFilterStrategy（消息过滤策略）
     *  返回true的时候消息将会被抛弃， 返回false时，消息能正常抵达监听容器。
     * @return
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory filterContainerFactory() {
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory);
        // 被过滤的消息将被丢弃
        factory.setAckDiscarded(true);
        factory.setRecordFilterStrategy(consumerRecord -> {
            //满足能被2整除的正常抵达监听容器
            if (Integer.parseInt(consumerRecord.value().toString()) % 2 == 0) {
                return false;
            }
            //返回true消息则被过滤
            return true;
        });
        return factory;
    }


    /**
     * 将这个过滤处理的BeanName放到@KafkaListener注解的containerFactory属性里面
     *
     * @param record
     * @throws Exception
     */
    @KafkaListener(topics = {"jokerfilter"}, containerFactory = "filterContainerFactory")
    public void onMessage5(ConsumerRecord record) {
        System.out.println("=========================消费过滤消息 START ===========================");
        System.out.println(record.toString());
        System.out.println(record.topic() + "-" + record.partition() + "-" + record.value());
        System.out.println("=========================消费过滤消息 END ===========================");
    }

    /**
     * 消息转发 jokersend1 到 jokersend2
     * @param record
     */
    @KafkaListener(topics = {"jokersend1"})
    @SendTo("jokersend2")
    public String onMessage6(ConsumerRecord record){
        System.out.println("=========消息转发处理=========");
        return record.value()+"-forward message";
    }

    @KafkaListener(topics = {"jokersend2"})
    public void onMessage7(ConsumerRecord record){
        System.out.println("=========================消费转发后消息 START ===========================");
        System.out.println(record.toString());
        System.out.println(record.topic() + "-" + record.partition() + "-" + record.value());
        System.out.println("=========================消费转发后消息 END ===========================");
    }


}
