package com.example.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义Ribbon负载均衡算法规则
 */

@Configuration
public class MySelfRule {

        @Bean
        public IRule rule(){
            return new RandomRule();    //测试自定义为随机、
        }
}
