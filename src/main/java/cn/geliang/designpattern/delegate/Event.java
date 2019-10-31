package cn.geliang.designpattern.delegate;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @Classname Event
 * @Description TODO
 * @Date 2019-08-01
 * @Created by Geliang TIAN
 */
public class Event {
    // 委托对象
    private Object object;

    // 委托方法名
    private String methodName;

    // 要执行方法的参数
    private Object[] parameters;

    // 要执行方法的参数类型
    private Class[] parametersType;

    public Event() {
    }

    public Event(Object object, String methodName) {
        this.object = object;
        this.methodName = methodName;
    }

    // 获取各个参数类型
    private void contractParamTypes() {
        if (parameters == null) {
            return;
        }
        this.parametersType = new Class[parameters.length];
        for (int i = 0; i < parametersType.length; i++) {
            parametersType[i] = parameters[i].getClass();
        }
    }

    public Object invoke(Object... parameters) throws Exception {
        this.parameters = parameters;
        contractParamTypes();
        Method method = object.getClass().getMethod(methodName, parametersType);
        if (method == null) {
            return null;
        }
        Object result = null;
        if (parameters != null) {
            result = method.invoke(object, parameters);
        }
        method.invoke(object);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(object.getClass().getName(), event.object.getClass().getName()) &&
                Objects.equals(methodName, event.methodName);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(object.getClass().getName(), methodName);
        return result;
    }
}
