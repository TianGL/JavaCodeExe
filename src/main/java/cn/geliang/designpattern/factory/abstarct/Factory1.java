package cn.geliang.designpattern.factory.abstarct;

/**
 * @Classname Factory1
 * @Description TODO
 * @Date 2019-08-01
 * @Created by Geliang TIAN
 */
public class Factory1 extends AbstractFactory {
    @Override
    public AbstractProductA getProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB getProductB() {
        return new ProductB1();
    }
}
