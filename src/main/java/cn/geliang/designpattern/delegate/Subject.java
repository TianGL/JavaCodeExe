package cn.geliang.designpattern.delegate;

/**
 * @Classname Subject
 * @Description TODO 通知抽象类
 * @Date 2019-08-01
 * @Created by Geliang TIAN
 */
public abstract class Subject {
    private EventHandler eventHandler;
    public abstract String getState();
    public abstract void notice(Object... parameters) throws Exception;
    public abstract void attach(Object observer, String methodName);
    public abstract void remove(Object observer, String methodName);
}
