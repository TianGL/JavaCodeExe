package cn.geliang.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Product
 * @Description TODO
 * @Date 2019-07-31
 * @Created by Geliang TIAN
 */
public class Product {
    private List<String> parts = new ArrayList<String>();

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        System.out.print("产品创建：");
        for (String part : parts) {
            System.out.print(part + ", ");
        }
        System.out.println();
    }


}
