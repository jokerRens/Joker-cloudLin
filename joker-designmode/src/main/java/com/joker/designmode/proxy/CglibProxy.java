package com.joker.designmode.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CglibProxy 动态代理类
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 13:59
 **/

public class CglibProxy implements MethodInterceptor {

    private Object target;

    /**
     *  Enhancer类是CGLib中的一个字节码增强器
     *
     * @param target
     * @return
     */
    public Object getInstance(final Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("买房前准备");
        Object result = methodProxy.invoke(object, args);
        System.out.println("买房后装修");
        return result;
    }
}
