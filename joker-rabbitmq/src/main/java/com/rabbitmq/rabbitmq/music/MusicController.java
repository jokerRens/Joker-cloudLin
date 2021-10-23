package com.rabbitmq.rabbitmq.music;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.rabbitmq.util.ConnectionUtils;

public class MusicController {


    /***
     * 生产者发送消息到队列
     */
    private static final String QUEUE_NAME="send_music";


    public static void main(String[] args) throws Exception {
        sendMusic();

    }


    public static void sendMusic() throws Exception {

        //获取一个rabbitMQ连接
        Connection connection = ConnectionUtils.getConnection();
        //从连接中获取一个通道
        Channel channel = connection.createChannel();
        //
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        //消息内容
        String msg = "发送消息，send_七里香";
        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());

        //关闭通道和连接
        channel.close();
        connection.close();
    }

}
