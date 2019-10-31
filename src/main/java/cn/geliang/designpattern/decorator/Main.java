package cn.geliang.designpattern.decorator;

/**
 * @Classname Main
 * @Description 装饰模式测试
 * @Date 2019-07-30
 * @Created by Geliang TIAN
 */
public class Main {
    public static void main(String[] args) {
        Person per = new Person("Tom");

        System.out.println("第一种装饰组合");
        Tshirts tshirts = new Tshirts();
        Thoursers thoursers = new Thoursers();
        tshirts.decorator(per);
        thoursers.decorator(tshirts);
        thoursers.show();

        System.out.println("\n\n第二种装饰组合");
        tshirts = new Tshirts();
        thoursers = new Thoursers();
        thoursers.decorator(per);
        tshirts.decorator(thoursers);
        tshirts.show();
    }
}
