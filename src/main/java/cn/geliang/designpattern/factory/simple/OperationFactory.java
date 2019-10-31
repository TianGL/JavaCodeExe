package cn.geliang.designpattern.factory.simple;

/**
 * @Classname OperationFactory
 * @Description 获取运算方法简单工厂
 * @Date 2019-07-23
 * @Created by Geliang TIAN
 */
public class OperationFactory {

    public static Operation getOperation(char opt) {
        switch (opt) {
            case '+':
                return new OperationAdd();
            case '-':
                return new OperationSub();
            default:
                return null;
        }
    }
}
