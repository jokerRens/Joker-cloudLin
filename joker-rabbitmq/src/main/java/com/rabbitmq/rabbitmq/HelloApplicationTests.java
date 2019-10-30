package com.rabbitmq.rabbitmq;


import com.rabbitmq.rabbitmq.RabbitMQ.HelloSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqApplication.class)
public class HelloApplicationTests {

    @Autowired
    private HelloSend helloSend;

    @Test
    public void hello(){
        helloSend.send();
    }

}
