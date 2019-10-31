package cn.geliang.designpattern.templateMethod;

/**
 * @Classname AbstractClass
 * @Description TODO 超类抽象方法
 * @Date 2019-07-31
 * @Created by Geliang TIAN
 */
public abstract class AbstractClass {
    protected abstract void operation1();
    protected abstract void operation2();

    public void templateMethod() {
        operation1();
        operation2();
        System.out.println();
    }
}
