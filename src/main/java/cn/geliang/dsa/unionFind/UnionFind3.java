package cn.geliang.dsa.unionFind;

/**
 * @Classname UnionFind3
 * @Description TODO
 * @Date 2019-11-20
 * @Created by Geliang TIAN
 */
public class UnionFind3 implements UF {

    private int[] parent;

    public UnionFind3(int size) {
        this.parent = new int[size];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p) {
        if (p < 0 || p > parent.length) {
            throw  new IllegalArgumentException("index out of range");
        }
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElement(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        parent[pRoot] = qRoot;
    }
}
