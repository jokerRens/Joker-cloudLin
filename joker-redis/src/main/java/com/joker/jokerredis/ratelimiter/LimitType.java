package com.joker.jokerredis.ratelimiter;

/**
 * LimitType
 *
 * @author joker
 * @version 1.0
 * 2022/6/28 14:22
 **/
public enum LimitType {

    /**
     * 默认策略全局限流
     */
    DEFULT,

    /**
     * 根据请求者IP进行限流
     */
    IP;
}
