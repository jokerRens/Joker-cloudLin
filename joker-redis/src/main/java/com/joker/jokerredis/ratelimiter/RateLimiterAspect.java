package com.joker.jokerredis.ratelimiter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/**
 * RateLimiterAspect
 *
 * @author joker
 * @version 1.0
 * 2022/6/28 14:35
 **/

@Aspect
@Component
public class RateLimiterAspect {

    private static final Logger log = LoggerFactory.getLogger(RateLimiterAspect.class);

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;


    @Autowired
    private RedisScript<Long> limitScript;

    @Before("@annotation(rateLimiter)")
    public void  doBefore(JoinPoint joinPoint, RateLimiter rateLimiter){
        String key = rateLimiter.key();
        int time = rateLimiter.time();
        int count = rateLimiter.count();
        LimitType limitType = rateLimiter.limitType();

        StringBuffer stringBuffer = new StringBuffer(key);
        if(limitType==LimitType.IP){
            stringBuffer.append(IpUtils.getIpAddr(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest())).append("-");
        }
        MethodSignature  signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Class<?> aClass = method.getDeclaringClass();
        stringBuffer.append(aClass.getName()).append("-").append(method.getName());
        String combineKey = stringBuffer.toString();
        List<Object> keys = Collections.singletonList(combineKey);
        try {
            Long number = redisTemplate.execute(limitScript, keys, count, time);
            if(number==null || number.intValue() >count){
                throw new NullPointerException("访问过于频繁，请稍候再试");
            }
            log.info("限制请求'{}',当前请求'{}',缓存key'{}'", count, number.intValue(), key);
        }catch (NullPointerException e){
           throw  e;
        } catch (Exception e){
            throw new RuntimeException("服务器限流异常，请稍候再试");
        }


    }

}
