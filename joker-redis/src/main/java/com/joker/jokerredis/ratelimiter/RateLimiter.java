package com.joker.jokerredis.ratelimiter;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiter {

    /**
     * 限流key
     * @return
     */
    String key() default "rate_limit:";

    /**
     *限流时间,单位秒
     * @return
     */
    int time() default 60;

    /**
     * 限流次数
     * @return
     */
    int count() default 100;

    /**
     * 限流类型
     * @return
     */
    LimitType limitType() default LimitType.DEFULT;



}
