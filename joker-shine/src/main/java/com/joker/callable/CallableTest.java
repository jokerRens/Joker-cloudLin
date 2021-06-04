package com.joker.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-06-04 10:18
 **/
public class CallableTest {

    /**
     * Futrue接口、
     *      1.可以对具体的Runnable、Callable任务的执行结果进行取消、查询是否完成、获取结果
     *      2.FutrueTask 是 Funtrue接口的唯一的实现类
     *      3.FutrueTask 同时实现了 Runnable、 Futrue 接口。它既可以作为 Runnable 被线程执行、又可以作为 Futrue 得到 Callable 的返回值
     *
     *
     * 实现Callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大？
     * 1.call()可以有返回值的
     * 2.call()可以抛出异常、被外面的操作捕获、获取异常的信息
     * 3.Callable是支持泛型的
     *
     *
     * @param args
     */

    public static void main(String[] args) {
        //3.创建callable接口实现类对象
        CallableDemo callableDemo = new CallableDemo();
        //4.将此callable接口实现类的对象作为传递到FutrueTask构造器中、创建FuntrueTask对象
        FutureTask futureTask = new FutureTask(callableDemo);
        //5.将FuntrueTask的对象作为参数传递到Thread类的构造器中、创建Thread对象，并调用start()
        new Thread(futureTask).start();
        try {
            //get()方法的返回值即为FutrueTask构造器参数Callable实现类重写的call()的返回值
            //6.获取Callable中call()方法的返回值
            Object sum = futureTask.get();
            System.out.println("总和为:"+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
