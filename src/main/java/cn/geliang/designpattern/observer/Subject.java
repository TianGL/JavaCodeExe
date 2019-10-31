package cn.geliang.designpattern.observer;

/**
 * @Classname Subject
 * @Description TODO 通知抽象类
 * @Date 2019-08-01
 * @Created by Geliang TIAN
 */
public abstract class Subject {
    public abstract String getState();
    public abstract void notice();
    public abstract void attach(Observer observer);
    public abstract void remove(Observer observer);
}
