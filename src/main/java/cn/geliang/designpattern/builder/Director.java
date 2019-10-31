package cn.geliang.designpattern.builder;

/**
 * @Classname Director
 * @Description TODO
 * @Date 2019-07-31
 * @Created by Geliang TIAN
 */
public class Director {

    public void construct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }
}
