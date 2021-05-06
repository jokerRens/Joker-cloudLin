package com.joker.jokerredis.controller;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-04-24 11:48
 **/
public class Seckill_ByScript {


    public static void main(String[] args) {
        JedisPool instance = JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis = instance.getResource();
//        Set<HostAndPort> set = new HashSet<~>();
        doSecKill("201","sk:0101");
    }


    static String secKillScript = "local userid = KEYS[1];\n" +
            "local prodid =KEYS[2];\n" +
            "local qtkey = \"sk:\"..prodid..\":qt\";\n" +
            "local usersKey= \"sk:\"..prodid..\":user\";\n" +
            "local userExists = redis.call(\"sismember\",usersKey,userid);\n" +
            "if tonumber(userExists)==1 then\n" +
            "    return 2;\n" +
            "end\n" +
            "local num = redis.call(\"get\",qtkey);\n" +
            "if tonumber(num)<=0 then\n" +
            "    return 0;\n" +
            "else\n" +
            "    redis.call(\"decr\",qtkey);\n" +
            "    redis.call(\"sadd\",usersKey,userid);\n" +
            "end\n" +
            "return 1;";

    static String secKillScript2 = "";

    public static boolean doSecKill(String userid,String prodid){
        JedisPool instance = JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis = instance.getResource();

        String load = jedis.scriptLoad(secKillScript);
        Object evalsha = jedis.evalsha(load, 2, userid, prodid);

        String valueOf = String.valueOf(evalsha);
        if("0".equals(valueOf)){
            System.out.println("已抢空...");
        }else if("1".equals(valueOf)){
            System.out.println("抢购成功...");
        }else if("2".equals(valueOf)){
            System.out.println("该用户已抢过...");
        }else {
            System.out.println("抢购异常...");
        }
        jedis.close();
        return true;
    }

}
