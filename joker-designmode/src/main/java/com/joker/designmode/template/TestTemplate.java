package com.joker.designmode.template;

/**
 * TestTemplate
 *
 * @author joker
 * @version 1.0
 * 2022/3/14 17:26
 **/

public class TestTemplate {

    /**
     * 模板模式:
     *    定义:定义一个操作中算法的骨架，而将一些步骤延迟到子类中，模板方法使得子类可以不改变算法的结构即可重定义该算法的某些特定步骤
     *
     *     优点: （1）具体细节步骤实现定义在子类中，子类定义详细处理算法是不会改变算法整体结构
     *          （2）代码复用的基本技术，在数据库设计中尤为重要。
     *          （3）存在一种反向的控制结构，通过一个父类调用其子类的操作，通过子类对父类进行扩展增加新的行为，符合“开闭原则”
     *
     *     缺点:  每个不同的实现都需要定义一个子类，会导致类的个数增加，系统更加庞大。
     *
     * @param args
     */
    public static void main(String[] args) {
        EggsWithTomato tomato = new EggsWithTomato();
        tomato.dodish();
        System.out.println("-----------------------");

        Bouilli bouilli = new Bouilli();
        bouilli.dodish();
    }
}
