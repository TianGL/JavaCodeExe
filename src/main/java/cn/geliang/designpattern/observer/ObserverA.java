package cn.geliang.designpattern.observer;

/**
 * @Classname ObserverA
 * @Description TODO 具体观察者A
 * @Date 2019-08-01
 * @Created by Geliang TIAN
 */
public class ObserverA extends Observer {
    private String name = "观察者A";
    private Subject subject;

    //public ObserverA(String name) {
    //    this.name = name;
    //}

    public void update() {
        System.out.println(subject.getState()+ ", " + name + "发生变化");
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
