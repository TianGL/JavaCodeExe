package cn.geliang.designpattern.proxy;

/**
 * @Classname Proxy
 * @Description TODO 代理实现类
 * @Date 2019-07-30
 * @Created by Geliang TIAN
 */
public class Proxy implements Subject{
    private RealSubject realSubject;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }


    public void request() {
        System.out.print("代理方法实现:");
        realSubject.request();
    }
}
