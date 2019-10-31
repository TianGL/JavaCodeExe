package cn.geliang.designpattern.builder;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019-07-31
 * @Created by Geliang TIAN
 */
public class Main {
    public static void main(String[] args) {
        Builder builder1 = new ConcretePartABuilder();
        Director director = new Director();
        director.construct(builder1);
        Product product = builder1.getProduct();
        product.show();

        Builder builder2 = new ConcretePartBBuilder();
        director.construct(builder2);
        product = builder2.getProduct();
        product.show();
    }
}
