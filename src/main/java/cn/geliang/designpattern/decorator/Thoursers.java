package cn.geliang.designpattern.decorator;

/**
 * @Classname Thoursers
 * @Description 装饰子类
 * @Date 2019-07-30
 * @Created by Geliang TIAN
 */
public class Thoursers extends Finery {

    @Override
    public void show() {
        System.out.println("穿裤子");
        super.show();
    }
}
