package com.joker.designmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * DynamicProxyHandler
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 13:28
 **/

public class DynamicProxyHandler implements InvocationHandler {

    private Object object;

    public DynamicProxyHandler(final Object object) {
        this.object = object;
    }

    /**
     *
     * @param proxy  代理对象(慎用)
     * @param method  当前执行的方法
     * @param args  当前执行的方法运行时传递过来的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("买房前准备");
        Object invoke = method.invoke(object, args);
        System.out.println("买房后装修");
        return invoke;
    }
}
