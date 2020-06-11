package com.joker.Controller;

import java.util.ArrayList;

/**
 * -XX:+PrintCommandLineFlags:查看命令行相关参数(包含使用的垃圾收集器)
 * 查看默认垃圾回收器
 *
 *
 * 使用-XX:+UseSerialGC 可以指定Serial垃圾收集器
 * 新生代用Serial GC，且老年代用Serial Old GC
 *
 *
 * 使用-XX:+UseParNewGC 可以指定ParNew垃圾收集器
 * -XX:ParallelGCThreads 限制线程数量、默认开启和CPU数据相同的线程数
 *
 *
 * -XX:+UseParallelGC 指定使用ParallelGC垃圾收集器
 * -XX:+UseParallelOldGC 指定老年代都是使用并行回收器
 * *两个参数默认开启一个、另一个也会被开启(相互激活)
 * -XX:+ParallelGCThreads 设置年轻代并行收集器的线程数
 *
 *
 *  -XX:+UseConcMarkSweepGC 指定使用CMS、开启该参数将会自动将ParNewGC打开、既：ParNew(Young区)+CMS(Old区)+Serial Old的组合
 *  -XX:CMSLnitiatingOccupanyFraction、设置内存使用率的阈值、一旦达到阙值、则开始进行回收
 */
public class MyGC {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<byte[]> list = new ArrayList<>();

        while (true){
            byte[] bytes = new byte[100];
            list.add(bytes);
            Thread.sleep(10);
        }
    }
}
