package com.joker.Controller;

public class SystemGC {

    public static void main(String[] args) {
        new SystemGC();
        //提醒JVM的垃圾回收器执行gc，但是不确定是否马上执行
        System.gc();
        //强制调用使用引用的对象的finalize()方法
        System.runFinalization();
    }

    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("SystemGC 重写的finalize()");
    }

}
