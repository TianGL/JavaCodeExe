package cn.geliang.designpattern.observer;

/**
 * @Classname Observer
 * @Description TODO
 * @Date 2019-08-01
 * @Created by Geliang TIAN
 */
public abstract class Observer {
    public abstract void update();
    public abstract void setSubject(Subject subject);
}
