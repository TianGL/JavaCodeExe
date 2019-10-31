package cn.geliang.designpattern.decorator;


/**
 * @Classname Person
 * @Description 人物类：具体事例ConcreteComponent
 * @Date 2019-07-30
 * @Created by Geliang TIAN
 */
public class Person {
    private String name;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("装扮的" + this.name);
    }
}
