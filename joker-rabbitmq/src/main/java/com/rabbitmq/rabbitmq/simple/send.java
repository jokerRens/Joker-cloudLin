package com.rabbitmq.rabbitmq.simple;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.rabbitmq.util.ConnectionUtils;

public class send {

    /***
     * 生产者发送消息到队列
     */
    private static final String QUEUE_NAME="test_simple";

    public static void main(String []args) throws Exception {
        //获取一个连接
        Connection connection = ConnectionUtils.getConnection();
        //从连接中获取一个通道
        Channel channel = connection.createChannel();
        //创建队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //消息内容
        String msg = "这里是 simple";
        channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
        System.out.println(msg);
        //关闭通道和连接
        channel.close();
        connection.close();
    }

}
