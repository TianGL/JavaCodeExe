package cn.geliang.designpattern.decorator;

/**
 * @Classname Finery
 * @Description 服装类，装饰高级类
 * @Date 2019-07-30
 * @Created by Geliang TIAN
 */
public class Finery extends Person {
    protected Person component;

    // 装饰
    public void decorator(Person component) {
        this.component = component;
    }

    // 覆写
    @Override
    public void show() {
        if (this.component != null) {
            component.show();
        }
    }
}
