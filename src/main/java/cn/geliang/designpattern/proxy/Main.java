package cn.geliang.designpattern.proxy;

/**
 * @Classname Ma
 * @Description TODO 代理模式测试
 * @Date 2019-07-30
 * @Created by Geliang TIAN
 */
public class Main {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Subject subject = new Proxy(realSubject);
        subject.request();
    }
}
