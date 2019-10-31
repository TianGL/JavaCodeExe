package cn.geliang.designpattern.factory.method;

/**
 * @Classname LeiFeng
 * @Description TODO 产品父类
 * @Date 2019-07-31
 * @Created by Geliang TIAN
 */
public class LeiFeng {

    protected String name = "Lei Feng";

    public void sweep(){
        System.out.println(name + " sweep...");
    }

    public void wash(){
        System.out.println(name + " wash...");
    }

    public void buyRice(){
        System.out.println(name + " buyRice...");
    }
}
