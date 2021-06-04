package com.joker.thread;

/**
 * @program: jokerLin
 * @description
 * @author: Joker
 * @create: 2021-05-15 10:14
 **/
public class ThreadCreateController {

    /**
     * 创建线程的两种方式:1.继承Thread类方式 、 2.实现Runnable接口方式
     *
     * 1.继承Thread类方式
     *     ①.创建一个类继承Thread类
     *     ②.重写Thread类的run()--》将此线程执行的操作声明在run()中
     *     ③.创建Thread类的子类的对象
     *     ④.通过此对象的start():1.启动当前线程 2.调用当前线程的run()
     *
     *      说明:
     *      ①.启动一个线程，必须调用start()、不能调用run()的方式启动线程、否则为main()主线程
     *      ②.再启动一个线程、必须重新创建一个新的Thread子类对象、调用start()
     *
     *
     * 2.实现Runnable接口方式
     *     ①.创建一个实现了Runnable接口的类
     *     ②.创建类去实现Runnable中的抽象方法:run()
     *     ③.创建实现类的对象
     *     ④.将此对象作为参数传递到Thread类的构造器中、创建Thread类的对象
     *     ⑤.通过Thread类的对象调用satrt()
     *
     *
     * 3.对比
     *      优先选择、实现Runnable接口的方式
     *      ①.实现的方式没类的单继承性的局限性
     *      ②.实现的方式更适合来处理多个线程共享数据的情况
     *
     *      联系: public class Thread implements Runnable
     *      相同点:两种方式都需要重写run()，将线程要执行的逻辑声明在run()中
     */

    public static void main(String[] args) {

        //创建Thread 类的子类的对象
        MyThread thread = new MyThread();

        //调用start():1.启动当前线程 2.不能调用当前线程的run()启动线程。


        try {
            thread.sleep(2000);
            thread.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        thread.run();


    }


    /**
     * Thread类中的常用方法:
     *  1.start():启动当前线程；调用当前线程的run()
     *  2.run():需要重写Thread类中的此方法、将创建的线程要执行的操作声明在此方法中
     *  3.currentThread()：静态方法、返回执行当前代码的线程
     *  4.getName()：获取当前线程的名字
     *  5.setName():设置当前线程的名字
     *  6.yield()：释放当前cpu的执行权
     *  7.join():在线程a中调用线程b的join()，此时线程a就进入到阻塞状态、直到线程b完全执行完成以后、线程a才会结束阻塞状态
     *  8.stop():已过时、强制结束当前线程
     *  9.sleep(millitime):让当前线程"睡眠"指定的millitime毫秒、在指定毫秒内、线程处于阻塞状态
     *  10.isAlive():判断当前线程是否存活
     *
     */

    /**
     * 线程的优先级:
     * 1.
     *    MAX_PRIORITY:10
     *    MIX_PRIORITY:1
     *    NORM_PRIOTITY:5 -->默认优先级
     *
     * 2.获取和设置当前线程的优先级
     *   getPriority():获取线程的优先级
     *   setPriority(int p):设置线程的优先级
     *
     *   说明:高优先级的线程要抢占低优先级线程的cpu执行权、
     *   并不意味着只有当高优先级的线程执行完以后，低优先级的线程才会执行
     *
     */


    /**
     * 线程的通信: wait()/notify()/notifyAll()
     * 三个方法并非在Thread类中、而是定义在Object类中的
     *
     * wait()
     *
     *
     *
     * notify()
     *
     *
     *
     * notifyAll()
     *
     *
     *
     *
     */


    /***
     *
     *  线程的分类  java中的线程分为两种 1.守护线程  2.用户线程
     *
     *  1.唯一的区别就是判断JVM何时离开
     *  2.守护线程是用来服务用户线程的，通过在start()方法前调用 thread.setDaemon(true) 可以把一个用户线程变为守护线程
     *  3.java垃圾回收就是一个典型的守护线程
     *  4.若JVM中都是守护线程、当前JVM将退出
     */
}


