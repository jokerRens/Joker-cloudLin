package com.joker.jokerredis.controller;


import com.joker.jokerredis.utils.RedisUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Random;
import java.util.Set;

@RestController
@RequestMapping("/redisTest")
public class HelloController {


    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping
    public String testRedisTemplate(){
        //设置值
        redisTemplate.opsForValue().set("name","demo");

        String name = (String) redisTemplate.opsForValue().get("name");

        String name1 = (String)redisUtil.get("name");

        return name1;
    }



    public static void main(String[] args) {

//        System.out.println(getCode());

//        verifyCode("18040480198");
        //连接本地的 Redis 服务
        Jedis  jedis = new Jedis("localhost");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        Set<String> keys = jedis.keys("*");
        keys.forEach(s->{
            System.out.println(s);
        });
        String s = jedis.get("VerifyCode18040480198:count");
        System.out.println(s);

        //设置 redis 字符串数据
//        jedis.set("joker", "www.joker.com");
        // 获取存储的数据并输出
//        System.out.println("redis存储的字符串为:"+ jedis.get("joker"));
    }

    //操作key String
    @Test
    public void demo1(){
        //连接本地的 Redis 服务
        Jedis  jedis = new Jedis("localhost");
        Set<String> keys = jedis.keys("*");
        keys.forEach(s->{
            System.out.println(s);
        });

        //添加
        jedis.set("joker","v1");

        //获取
        String joker = jedis.get("joker");
        System.out.println(joker);

        //设置多个key-value
        jedis.mset("k1","v1","k2","v2");
        List<String> mget = jedis.mget("k1", "k2");
        System.out.println(mget);

    }

    //操作list
    @Test
    public void demo2(){
        //连接本地的 Redis 服务
        Jedis  jedis = new Jedis("localhost");
        jedis.lpush("key1","joker1","joker2","joker3");
        List<String> lrange = jedis.lrange("key1", 0, -1);
        System.out.println(lrange);
    }

    //操作set
    @Test
    public void demo3(){
        //连接本地的 Redis 服务
        Jedis  jedis = new Jedis("localhost");
        jedis.sadd("夏天","夏天1","夏天2","夏天3");
        Set<String> smembers = jedis.smembers("夏天");
        System.out.println(smembers);
    }

    //操作hash
    @Test
    public void demo4(){
        //连接本地的 Redis 服务
        Jedis  jedis = new Jedis("localhost");
        jedis.hset("user","name","joker");
        String hget = jedis.hget("user", "name");
        System.out.println(hget);
    }


    //操作zset
    @Test
    public void demo5(){
        //连接本地的 Redis 服务
        Jedis  jedis = new Jedis("localhost");
        jedis.zadd("china",100d,"shanghai");
        Set<String> china = jedis.zrange("china", 0, -1);
        System.out.println(china);
    }


    //生成6位数验证码
    public static String getCode(){
        Random random = new Random();
        String code = "";
        for (int i=0;i<6;i++){
            int nextInt = random.nextInt(10);
            code += nextInt;
        }
        return code;
    }

    //次数与验证码存放
    public static void verifyCode(String phone){
        //连接本地的 Redis 服务
        Jedis  jedis = new Jedis("localhost");
        //拼接key

        //手机发送次数key
        String countKey = "VerifyCode"+phone+":count";
        //验证码key
        String codeKey = "VerifyCode"+phone+":code";


        //每个手机每天发送三次
        String count = jedis.get(countKey);
        if(count==null){
            //没有发送过验证码、第一次发送
            jedis.setex(countKey,24*60*60,"1");
        }else if(Integer.valueOf(count)<=2){
            //发送次数加1
            jedis.incr(countKey);
        }else if(Integer.valueOf(count)>2){
            System.out.println("今日发送次数已经超过三次");
            jedis.close();
        }

        //验证码放到redis
        String code = getCode();
        jedis.setex(codeKey,120,code);
        jedis.close();
    }



}
