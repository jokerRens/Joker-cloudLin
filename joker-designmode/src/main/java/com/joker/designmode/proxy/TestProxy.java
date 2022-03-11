package com.joker.designmode.proxy;

import java.lang.reflect.Proxy;

/**
 * TestProxy
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 13:11
 **/

public class TestProxy {

    /**
     * 代理模式:
     *   1.静态代理
     *      优点：可以做到在符合开闭原则的情况下对目标对象进行功能扩展
     *      缺点：代理对象与目标对象要实现相同的接口，我们得为每一个服务都得创建代理类，工作量太大，不易管理，同时接口一旦发生改变，代理类也得相应修改。
     *   2.动态代理
     *      优点:
     *          1.代理对象,不需要实现接口
     *          2.代理对象的生成,是利用JDK的API,动态的在内存中构建代理对象(需要我们指定创建代理对象/目标对象实现的接口的类型)
     *          代理类不用再实现接口了。但是，要求被代理对象必须有接口
     *      总结:
     *          相对于静态代理，动态代理大大减少了我们的开发任务，同时减少了对业务接口的依赖，降低了耦合度
     *          但是还是有一点点小小的遗憾之处，那就是它始终无法摆脱仅支持interface代理的桎梏（我们要使用被代理的对象的接口）
     *
     *   3.CGLIB代理
     *       CGLIB 原理：
     *          动态生成一个要代理类的子类，子类重写要代理的类的所有不是final的方法。在子类中采用方法拦截的技术拦截所有父类方法的调用，顺势织入横切逻辑。它比使用java反射的JDK动态代理要快
     *       CGLIB 底层：
     *          使用字节码处理框架ASM，来转换字节码并生成新的类。不鼓励直接使用ASM，因为它要求你必须对JVM内部结构包括class文件的格式和指令集都很熟悉。
     *       CGLIB缺点：
     *          对于final方法，无法进行代理
     *       总结:
     *          CGLIB创建的动态代理对象比JDK创建的动态代理对象的性能更高，但是CGLIB创建代理对象时所花费的时间却比JDK多得多，
     *          所以对于单例的对象，因为无需频繁创建对象，用CGLIB合适，反之使用JDK方式要更为合适一些
     *          同时由于CGLib由于是采用动态创建子类的方法，对于final修饰的方法无法进行代理
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.静态代理
        BuyHouse house = new BuyHouseImpl();
        BuyHouse buyHouse = new BuyHouseProxy(house);
        buyHouse.buyHouse();
        System.out.println("***************************");
        //2.动态代理
        BuyHouse buyHouse1 = new BuyHouseImpl();
        BuyHouse proxyBuyHouse = (BuyHouse)Proxy.newProxyInstance(BuyHouse.class.getClassLoader(),new Class[]{BuyHouse.class},new DynamicProxyHandler(buyHouse1));
        proxyBuyHouse.buyHouse();
        System.out.println("***************************");
        //3.CGLIB代理
        BuyHouse buyHouse2 = new BuyHouseImpl();
        CglibProxy cglibProxy = new CglibProxy();
        BuyHouseImpl buyHouseCglibProxy = (BuyHouseImpl)cglibProxy.getInstance(buyHouse2);
        buyHouseCglibProxy.buyHouse();
    }
}
