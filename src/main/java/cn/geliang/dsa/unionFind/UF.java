package cn.geliang.dsa.unionFind;

/**
 * @Classname UF
 * @Description TODO
 * @Date 2019-11-20
 * @Created by Geliang TIAN
 */
public interface UF {
    int getSize();
    boolean isConnected(int p, int q);
    void unionElement(int p, int q);

}
