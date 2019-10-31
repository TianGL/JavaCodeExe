package cn.geliang.dynamicProxy;

/**
 * @Classname SubjectImpl
 * @Description TODO
 * @Date 2019-08-26
 * @Created by Geliang TIAN
 */
public class SubjectImpl implements Subject {
    @Override
    public void hello() {
        System.out.println("hello");
    }

    @Override
    public void bybe() {
        System.out.println("bybe");
    }
}
