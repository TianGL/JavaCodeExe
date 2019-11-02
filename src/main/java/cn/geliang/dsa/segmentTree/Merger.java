package cn.geliang.dsa.segmentTree;

/**
 * @Classname Merger
 * @Description TODO
 * @Date 2019-11-02
 * @Created by Geliang TIAN
 */
public interface Merger<E> {
    E merge(E e1, E e2);
}
