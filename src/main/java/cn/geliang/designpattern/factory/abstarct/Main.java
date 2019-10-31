package cn.geliang.designpattern.factory.abstarct;


/**
 * @Classname Main
 * @Description TODO
 * @Date 2019-08-01
 * @Created by Geliang TIAN
 */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("**************抽象工厂测试**************");
        //AbstractFactory factory = new Factory1();
        // 更换结构只需要添加新的工厂实现
        AbstractFactory factory = new Factory2();

        AbstractProductA productA = factory.getProductA();
        AbstractProductB productB = factory.getProductB();
        productA.showA();
        productB.showB();

        System.out.println("\n***********反射+简单工厂实现***********");
        factory = FactoryUtil.getFactory();
        productA = factory.getProductA();
        productB = factory.getProductB();
        productA.showA();
        productB.showB();
    }
}
