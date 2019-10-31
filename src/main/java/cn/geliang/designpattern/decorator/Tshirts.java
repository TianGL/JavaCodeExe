package cn.geliang.designpattern.decorator;

/**
 * @Classname Tshirts
 * @Description 装饰子类
 * @Date 2019-07-30
 * @Created by Geliang TIAN
 */
public class Tshirts extends Finery {
    @Override
    public void show() {
        System.out.println("穿T-Shirt");
        super.show();
    }
}
