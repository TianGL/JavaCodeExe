package cn.geliang.designpattern.observer;

/**
 * @Classname Main
 * @Description TODO 观察者模式测试类
 * @Date 2019-08-01
 * @Created by Geliang TIAN
 */
public class Main {
    public static void main(String[] args) {
        Subject subject = new SubjectA("老板来了");
        subject.attach(new ObserverA());
        subject.attach(new ObserverB());
        subject.notice();
    }
}
