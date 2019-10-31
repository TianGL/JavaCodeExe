package cn.geliang.designpattern.factory.method;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019-07-31
 * @Created by Geliang TIAN
 */
public class Main {
    public static void main(String[] args) {
        //IFactory factory = new UnderGraduateFactory();
        IFactory factory = new VolunteerFactory(); // 更换实现只需要更改这一行
        LeiFeng student1 = factory.createLeiFeng();
        student1.sweep();
        student1.buyRice();

    }
}
