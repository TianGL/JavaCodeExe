package cn.geliang.designpattern.proxy;

/**
 * @Classname RealSubject
 * @Description TODO 真实实现类
 * @Date 2019-07-30
 * @Created by Geliang TIAN
 */
public class RealSubject implements Subject{

    public void request() {
        System.out.println("真实请求");
    }
}
