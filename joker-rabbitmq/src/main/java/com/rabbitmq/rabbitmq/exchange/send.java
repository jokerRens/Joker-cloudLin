package com.rabbitmq.rabbitmq.exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.rabbitmq.util.ConnectionUtils;

public class send {

    /**
     * 消息发送到没有队列绑定的交换机时，消息将丢失，因为，交换机没有存储消息的能力，消息只能存在在队列中。
     */
    private static final String EXCHANGE_NAME="send_music";
    public static void main(String []args) throws Exception {

        //获取连接及MQ通道
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        //声明 exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        //消息内容
        String message = "这里是生产send-七里香";
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println("exchange生产者"+message);

        //关闭连接及通道
        channel.close();
        connection.close();
    }

}
