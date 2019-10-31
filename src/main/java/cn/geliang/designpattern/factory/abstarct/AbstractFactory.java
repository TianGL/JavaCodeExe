package cn.geliang.designpattern.factory.abstarct;

/**
 * @Classname AbstractFactory
 * @Description TODO 抽象工厂
 * @Date 2019-08-01
 * @Created by Geliang TIAN
 */
public abstract class AbstractFactory {
    public abstract AbstractProductA getProductA();
    public abstract AbstractProductB getProductB();
}
