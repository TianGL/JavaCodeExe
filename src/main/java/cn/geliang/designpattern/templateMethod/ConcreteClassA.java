package cn.geliang.designpattern.templateMethod;

/**
 * @Classname ConcreteClassA
 * @Description TODO 具体实现类
 * @Date 2019-07-31
 * @Created by Geliang TIAN
 */
public class ConcreteClassA extends AbstractClass {
    protected void operation1() {
        System.out.println("class A operation 1...");
    }

    protected void operation2() {
        System.out.println("class A operation 2...");
    }
}
