package cn.geliang.designpattern.facade;

/**
 * @Classname Facade
 * @Description TODO
 * @Date 2019-07-31
 * @Created by Geliang TIAN
 */
public class Facade {
    SubSystemA a = new SubSystemA();
    SubSystemB b = new SubSystemB();
    SubSystemC c = new SubSystemC();
    SubSystemD d = new SubSystemD();

    public void programA() {
        a.methodA();
        b.methodB();
        d.methodD();
        System.out.println("finish programA...\n");
    }

    public void programB() {
        d.methodD();
        c.methodC();
        a.methodA();
        System.out.println("finish programB...\n");
    }
}
