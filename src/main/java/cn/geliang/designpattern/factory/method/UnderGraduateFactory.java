package cn.geliang.designpattern.factory.method;

/**
 * @Classname UnderGraduateFactory
 * @Description TODO undergraduate工厂类
 * @Date 2019-07-31
 * @Created by Geliang TIAN
 */
public class UnderGraduateFactory implements IFactory{

    public LeiFeng createLeiFeng() {
        return new Undergraduate();
    }
}
