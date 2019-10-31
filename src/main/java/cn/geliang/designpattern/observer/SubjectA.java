package cn.geliang.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname SubjectA
 * @Description TODO 具体通知主题
 * @Date 2019-08-01
 * @Created by Geliang TIAN
 */
public class SubjectA extends Subject {
    private String state;
    private List<Observer> observers = new ArrayList<Observer>();

    public SubjectA(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void notice() {
        for (Observer obv:observers) {
            obv.update();
        }
    }

    public void attach(Observer observer) {
        observers.add(observer);
        observer.setSubject(this);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }
}
