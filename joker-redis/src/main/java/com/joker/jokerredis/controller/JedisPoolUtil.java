package com.joker.jokerredis.controller;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-04-24 11:26
 **/
public class JedisPoolUtil {


    private static volatile JedisPool jedisPool = null;

    private JedisPoolUtil(){

    }

    public static JedisPool getJedisPoolInstance(){

        if(null == jedisPool){
            synchronized (JedisPoolUtil.class){
                if(null == jedisPool){
                    JedisPoolConfig config = new JedisPoolConfig();
                    config.setMaxTotal(200);
                    config.setMaxIdle(32);
                    config.setMaxWaitMillis(100*1000);
                    config.setBlockWhenExhausted(true);
                    config.setTestOnBorrow(true); // ping PONG

                    jedisPool = new JedisPool(config, "127.0.0.1", 6379, 60000);
                }
            }
        }
        return  jedisPool;
    }


}
