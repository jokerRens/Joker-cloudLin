package com.example.consumer;

import com.example.ribbon.MySelfRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
//在启动微服务的时候就去加载我们自定义的Ribbon配置类  注意：MySelfRule不能再 @ConpentScan同包及其子类下
@RibbonClient(name = "JOKER-PROVIDER", configuration = MySelfRule.class)
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced       //spring cloud Ribbon是基于Netflix实现客户端负载均衡的工具
    public RestTemplate restTemplate(){     //使用@LoadBalanced 标记 RestTemplate
        return new RestTemplate();
    }


    @Bean
    public IRule rule(){
       // return new RandomRule();        //使用随机算法，替换调默认的轮询算法
        return new RetryRule();             //先按照轮询计算，如果获取失败则按指定时间内进行重试，获取可用服务
    }


}
