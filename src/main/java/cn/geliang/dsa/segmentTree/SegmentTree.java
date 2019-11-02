package cn.geliang.dsa.segmentTree;

import java.util.Arrays;

/**
 * @Classname SegmentTree
 * @Description TODO
 * @Date 2019-11-02
 * @Created by Geliang TIAN
 */
public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        this.merger = merger;

        tree = (E[])new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    // 构建线段树
    private void buildSegmentTree(int treeIndex, int lo, int hi) {
        if (lo > hi) {
            return;
        }
        if (lo == hi) {
            tree[treeIndex] = data[lo];
            return;
        }

        int leftIdx = leftChild(treeIndex);
        int rightIdx = rightChild(treeIndex);

        int midIdx = lo + (hi - lo) / 2;
        buildSegmentTree(leftIdx, lo, midIdx);
        buildSegmentTree(rightIdx, midIdx+1, hi);

        tree[treeIndex] = merger.merge(tree[leftIdx], tree[rightIdx]);
    }

    // 区间查询
    public E query(int queryL, int queryR) {
        if (queryL > queryR || queryL < 0 || queryL >= data.length
        || queryR < 0 || queryR >= data.length) {
            throw new IllegalArgumentException("Index is Illegal.");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    // 区间查询
    private E query(int treeIndex, int lo, int hi, int queryL, int queryR) {
        if (queryL == lo && queryR == hi) {
            return tree[treeIndex];
        }

        int leftIdx = leftChild(treeIndex);
        int rightIdx = rightChild(treeIndex);

        int midIdx = lo + (hi - lo) / 2;
        if (queryL >= midIdx + 1) {
            return query(rightIdx, midIdx + 1, hi, queryL, queryR);
        } else if (queryR <= midIdx) {
            return query(leftIdx, lo, midIdx, queryL, queryR);
        } else {
            E leftRet = query(leftIdx, lo, midIdx, lo, midIdx);
            E rightRet = query(rightIdx, midIdx + 1, hi, midIdx+1, queryR);
            return merger.merge(leftRet, rightRet);
        }
    }

    public void set(int idx, E e) {
        data[idx] = e;
        set(0, 0, data.length - 1, idx, e);
    }

    private void set(int treeIndex, int lo, int hi, int idx, E e) {
        if (lo == hi) {
            tree[treeIndex] = e;
        }

        int leftIdx = leftChild(treeIndex);
        int rightIdx = rightChild(treeIndex);

        int midIdx = lo + (hi-lo)/2;
        if (midIdx < idx) {
            set(rightIdx, midIdx + 1, hi, idx, e);
        } else if(midIdx >= idx) {
            set(leftIdx, lo, midIdx, idx, e);
        }

        tree[treeIndex] = merger.merge(tree[leftIdx], tree[rightIdx]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int idx) {
        return data[idx];
    }

    private int leftChild(int idx) {
        return idx * 2 + 1;
    }

    private int rightChild(int idx) {
        return idx * 2 + 2;
    }

    @Override
    public String toString() {
        return "SegmentTree{" +
                "tree=" + Arrays.toString(tree) +
                ", data=" + Arrays.toString(data) +
                ", merger=" + merger +
                '}';
    }
}
