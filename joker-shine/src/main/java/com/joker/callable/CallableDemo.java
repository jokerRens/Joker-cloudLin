package com.joker.callable;

import java.util.concurrent.Callable;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-06-04 10:18
 **/
public class CallableDemo implements Callable {

    /**
     * 1.创建一个实现Callable的实现类
     * 2.实现call方法、将此线程需要执行的操作声明在call()中、call()有返回值
     * 3.创建callable接口实现类对象
     * 4.将此callable接口实现类的对象作为传递到FutrueTask构造器中、创建FuntrueTask对象
     * 5.将FuntrueTask的对象作为参数传递到Thread类的构造器中、创建Thread对象，并调用start()
     * 6.获取Callable中call()方法的返回值
     * @return
     * @throws Exception
     */


    @Override
    public Object call() throws Exception {
        int sum = 0;
        for(int i=1;i<=100;i++){
            if(i%2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }




}
