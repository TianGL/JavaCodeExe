package cn.geliang.designpattern.builder;

/**
 * @Classname ConcretePartABuilder
 * @Description TODO
 * @Date 2019-07-31
 * @Created by Geliang TIAN
 */
public class ConcretePartBBuilder implements Builder{

    private Product product = new Product();

    public void buildPartA() {
        product.add("part X");
    }

    public void buildPartB() {
        product.add("part Y");
    }

    public Product getProduct() {
        return product;
    }
}
