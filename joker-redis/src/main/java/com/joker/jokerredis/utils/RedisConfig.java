package com.joker.jokerredis.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 *  redis配置类
 */
@EnableCaching
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

//        @Bean
//        @SuppressWarnings("all")
//        public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory){
//
//            RedisTemplate<String, Object> template = new RedisTemplate<>();
//            template.setConnectionFactory(factory);
//            Jackson2JsonRedisSerializer redisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//            objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//
//            redisSerializer.setObjectMapper(objectMapper);
//
//            StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//            //key采用String的序列化方式
//            template.setKeySerializer(stringRedisSerializer);
//            //hash的key也采用String的序列化方式
//            template.setHashKeySerializer(stringRedisSerializer);
//            //value序列化方式采用jackson
//            template.setValueSerializer(redisSerializer);
//            //hash的value序列化方式采用jackson
//            template.setHashValueSerializer(redisSerializer);
//            template.afterPropertiesSet();
//            return template;
//
//        }


    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        // 使用Jackson2JsonRedisSerialize 替换默认序列化(默认采用的是JDK序列化)
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        redisTemplate.setKeySerializer(jackson2JsonRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        return redisTemplate;
    }




}
