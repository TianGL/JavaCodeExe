package cn.geliang.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Classname SubjectProxy
 * @Description TODO
 * @Date 2019-08-26
 * @Created by Geliang TIAN
 */
public class SubjectProxy implements InvocationHandler {

    private Subject subject;

    public SubjectProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            method.invoke(subject, args);
        } catch (Exception e) {
            throw e;
        } finally {
            System.out.println("finish");
        }
        return result;
    }
}
