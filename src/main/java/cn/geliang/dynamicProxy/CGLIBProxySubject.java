package cn.geliang.dynamicProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Classname CGLIBProxySubject
 * @Description TODO
 * @Date 2019-08-26
 * @Created by Geliang TIAN
 */
public class CGLIBProxySubject implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        try {
            result = methodProxy.invokeSuper(o, objects);
        } catch (Exception e){

        } finally {

        }
        return result;
    }
}
