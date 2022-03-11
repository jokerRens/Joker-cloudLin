package com.joker.designmode.adapter;

/**
 * TestAdapter
 *
 * @author joker
 * @version 1.0
 * 2022/3/11 9:42
 **/

public class TestAdapter {


    /**
     * 适配器模式
     * 定义:
     *  适配器模式将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的类的兼容性问题。

     * 主要分为三类：
     *  1.类的适配器模式
     *      通过多重继承目标接口和被适配者类方式来实现适配
     *  2.对象的适配器模式
     *      对象适配器和类适配器使用了不同的方法实现适配，对象适配器使用组合，类适配器使用继承
     *  3.接口的适配器模式
     *      当不需要全部实现接口提供的方法时，可先设计一个抽象类实现接口，并为该接口中每个方法提供一个默认实现（空方法）
     *      ，那么该抽象类的子类可有选择地覆盖父类的某些方法来实现需求，它适用于一个接口不想使用其所有的方法的情况
     *
     *  三种适配器模式的应用场景：
     *      1.类适配器模式：
     *          当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，创建一个新类，继承原有的类，实现新的接口即可
 *          2.对象的适配器模式：
     *          当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Wrapper类，持有原类的一个实例，在Wrapper类的方法中，调用实例的方法就行
 *          3.接口适配器模式：
     *          当不希望实现一个接口中所有的方法时，可以创建一个抽象类Wrapper，实现所有方法，我们写别的类的时候，继承抽象类即可
     *
     *  使用选择：
     *      根据合成复用原则，组合大于继承。因此，类的适配器模式应该少用
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.类适配器模式
        AdapterUSB2VGA usb2VGA = new AdapterUSB2VGA();
        //2. 对象适配器模式
        AdapterUSB3VGA usb3VGA = new AdapterUSB3VGA();
        //3. 接口的适配器模式
        AdapterUSB4VGA usb4VGA = new AdapterUSB4VGAImpl();

        //进行投影,使用的是USB的功能
        Projector projector = new Projector();
        projector.projection(usb4VGA);
    }
}
