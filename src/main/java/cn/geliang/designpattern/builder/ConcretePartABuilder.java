package cn.geliang.designpattern.builder;

/**
 * @Classname ConcretePartABuilder
 * @Description TODO
 * @Date 2019-07-31
 * @Created by Geliang TIAN
 */
public class ConcretePartABuilder implements Builder{

    private Product product = new Product();

    public void buildPartA() {
        product.add("part A");
    }

    public void buildPartB() {
        product.add("part B");
    }

    public Product getProduct() {
        return product;
    }
}
