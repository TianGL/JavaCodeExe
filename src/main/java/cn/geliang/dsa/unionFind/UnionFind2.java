package cn.geliang.dsa.unionFind;

/**
 * @Classname UnionFind2
 * @Description TODO
 * @Date 2019-11-20
 * @Created by Geliang TIAN
 */
public class UnionFind2 implements UF {

    private int[] parent;
    private int[] sz;

    public UnionFind2(int size) {
        this.parent = new int[size];
        this.sz = new int[size];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            sz[i] = 1;
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

        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}
