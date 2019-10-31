package cn.geliang.designpattern.templateMethod;

/**
 * @Classname ConcreteClassA
 * @Description TODO 具体实现类
 * @Date 2019-07-31
 * @Created by Geliang TIAN
 */
public class ConcreteClassB extends AbstractClass {
    protected void operation1() {
        System.out.println("class B operation 1...");
    }

    protected void operation2() {
        System.out.println("class B operation 2...");
    }
}
