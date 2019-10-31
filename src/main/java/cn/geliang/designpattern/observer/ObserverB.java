package cn.geliang.designpattern.observer;

/**
 * @Classname ObserverA
 * @Description TODO 具体观察者B
 * @Date 2019-08-01
 * @Created by Geliang TIAN
 */
public class ObserverB extends Observer {
    private String name = "观察者B";
    private Subject subject;

    //public ObserverB(String name) {
    //    this.name = name;
    //}

    public void update() {
        System.out.println(subject.getState()+ ", " + name + "发生变化");
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
