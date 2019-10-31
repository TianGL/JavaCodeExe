package cn.geliang.designpattern.facade;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019-07-31
 * @Created by Geliang TIAN
 */
public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.programA();
        facade.programB();
    }
}
