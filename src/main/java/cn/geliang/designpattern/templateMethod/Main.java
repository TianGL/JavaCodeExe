package cn.geliang.designpattern.templateMethod;

/**
 * @Classname Main
 * @Description TODO 模版方法测试
 * @Date 2019-07-31
 * @Created by Geliang TIAN
 */
public class Main {
    public static void main(String[] args) {
        AbstractClass program = new ConcreteClassA();
        program.templateMethod();

        program = new ConcreteClassB();
        program.templateMethod();

    }
}
