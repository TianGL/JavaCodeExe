package cn.geliang.dynamicProxy;


import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019-08-26
 * @Created by Geliang TIAN
 */
public class Main {
    public static void main(String[] args) {
        Subject subject = (Subject) Proxy.newProxyInstance(Main.class.getClassLoader(),
                new Class[]{Subject.class}, new SubjectProxy(new SubjectImpl()));
        subject.hello();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SubjectImpl.class);
        enhancer.setCallback(new CGLIBProxySubject());
        Subject subject2 = (Subject) enhancer.create();
        subject2.bybe();
    }
}
