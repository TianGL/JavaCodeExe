package cn.geliang.designpattern.factory.simple;

/**
 * @Classname OperationAdd
 * @Description 加法实现
 * @Date 2019-07-23
 * @Created by Geliang TIAN
 */
public class OperationAdd extends Operation {

    public double operate() {
        return super.num1 + super.num2;
    }
}
