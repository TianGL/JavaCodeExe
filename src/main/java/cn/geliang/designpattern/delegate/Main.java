package cn.geliang.designpattern.delegate;

/**
 * @Classname Main
 * @Description TODO 委托方法测试
 * @Date 2019-08-01
 * @Created by Geliang TIAN
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Subject subject = new SubjectA("老板来了");
        subject.attach(new ObserverA(), "updateA");
        subject.attach(new ObserverB(), "updateB");
        subject.notice(null);
    }
}
