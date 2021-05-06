package com.joker.jokerredis.controller;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-04-24 09:42
 **/
public class SecKill {

    public static void main(String[] args) {

        boolean b = doSeckill("1", "0101");
        System.out.println(b);

    }



    //秒杀过程
    public static boolean doSeckill(String uid,String pid){

        //1.判断用户与商品非空
            if(uid==null || pid == null){
                return false;
            }
        //2.开启redis
//        Jedis jedis = new Jedis();

        //通过连接池得到jedis对象、解决库存超卖问题
        JedisPool instance = JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis = instance.getResource();

        //3.拼接字符串key
        //3.1商品key
        String pkey = "sk:"+pid+":p";
        //3.2 用户key
        String ukey = "sk:"+pid+":u";

        //监听库存
        jedis.watch(pkey);


        //4. 商品是否为null(活动是否开始)
        String product = jedis.get(pkey);
        if(product==null){
            jedis.close();
            System.out.println("活动暂未开始...");
            return false;
        }

        //5.用户是否重复秒杀 //秒杀记录使用set存储、因为set可保证唯一
        Boolean sismember = jedis.sismember(ukey, uid);
        if(sismember){
            jedis.close();
            System.out.println("用户已经秒杀过...");
            return false;
        }

        //6.商品是否还有库存
        if(Integer.parseInt(product)<=0){
            jedis.close();
            System.out.println("商品已经秒杀完....");
            return false;
        }

        //7.秒杀过程  使用事务
        Transaction multi = jedis.multi();

        //组队
        multi.decr(pkey);
        multi.sadd(ukey,uid);

        //执行
        List<Object> exec = multi.exec();
        if(exec == null || exec.size()==0){
            System.out.println("秒杀失败了...");
            jedis.close();
            return false;

        }

        //7.1减去商品库存
//            jedis.decr(pkey);
        //7.2创建用户秒杀订单
//            jedis.sadd(ukey,uid);
            jedis.close();
        System.out.println("秒杀成功...");
        return true;
    }

}
