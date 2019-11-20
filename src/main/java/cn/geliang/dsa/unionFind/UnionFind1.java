package cn.geliang.dsa.unionFind;

/**
 * @Classname UnionFind1
 * @Description TODO
 * @Date 2019-11-20
 * @Created by Geliang TIAN
 */
public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {
        this.id = new int[size];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    private int find(int p) {
        if (p < 0 || p > id.length) {
            throw  new IllegalArgumentException("index out of range");
        }
        return id[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElement(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId != qId) {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pId) {
                    id[i] = qId;
                }
            }
        }
    }
}
