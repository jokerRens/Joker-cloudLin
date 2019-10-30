package com.rabbitmq.rabbitmq.work;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.rabbitmq.util.ConnectionUtils;

/**
 *生产者向队列中发送20条消息。
 */
public class send {

    private static final String QUEUE_NAME="test_works";
    public static void main(String []args) throws Exception {
        //获取连接
        Connection connection = ConnectionUtils.getConnection();
        //获取MQ通道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        for (int i=1;i<=20;i++){
            String message =""+i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("这里是生产者"+message);
            Thread.sleep(i*10); //睡眠
        }
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
