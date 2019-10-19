package com.example.ribbon;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义Ribbon负载均衡算法规则
 */

@Configuration
public class MySelfRule {

        @Bean
        public IRule rule(){
            return new RandomRuleJoker();   //测试自定义为三次一轮询、
        }
}
