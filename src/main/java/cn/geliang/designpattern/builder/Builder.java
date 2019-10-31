package cn.geliang.designpattern.builder;

/**
 * @Classname Builder
 * @Description TODO 建造者接口
 * @Date 2019-07-31
 * @Created by Geliang TIAN
 */
public interface Builder {
    void buildPartA();
    void buildPartB();
    Product getProduct();
}
