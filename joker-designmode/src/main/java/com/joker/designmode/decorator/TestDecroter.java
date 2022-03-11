package com.joker.designmode.decorator;

/**
 * TestDecker
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 10:43
 **/

public class TestDecroter {

    /**
     * 装饰者模式:
     *  定义:
     *    动态的将新功能附加到对象上。在对象功能扩展方面，它比继承更有弹性
     *
     *   1.Component（被装饰对象的基类）
     *      定义一个对象接口，可以给这些对象动态地添加职责
     *   2.ConcreteComponent（具体被装饰对象）
     *      定义一个对象，可以给这个对象添加一些职责
     *   3.Decorator（装饰者抽象类）
     *      维持一个指向Component实例的引用，并定义一个与Component接口一致的接口
     *   4.ConcreteDecorator（具体装饰者）
     *      具体的装饰对象，给内部持有的具体被装饰对象，增加具体的职责
     *
     *  被装饰对象和修饰者继承自同一个超类
     *
     *  总结:
     *      装饰者和被装饰者之间必须是一样的类型,也就是要有共同的超类,在这里应用继承并不是实现方法的复制,而是实现类型的匹配.
     *      因为装饰者和被装饰者是同一个类型,因此装饰者可以取代被装饰者,这样就使被装饰者拥有了装饰者独有的行为
     *      根据装饰者模式的理念,我们可以在任何时候,实现新的装饰者增加新的行为,如果是用继承,每当需要增加新的行为时,就要修改原程序了
     *
     * @param args
     */
    public static void main(String[] args) {
        Drink order;
        order = new Decaf();
        System.out.println(order.toString());
        System.out.println("当前金额:"+order.cost());
        System.out.println("*************************");
        order = new Milk(order);
        System.out.println(order.toString());
        System.out.println("当前金额:"+order.cost());
    }
}
