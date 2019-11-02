package cn.geliang.dsa.maxHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname MaxHeap
 * @Description TODO
 * @Date 2019-11-02
 * @Created by Geliang TIAN
 */
public class MaxHeap<E extends Comparable<E>> {
    private List<E> data;

    public MaxHeap(int capacity) {
        this.data = new ArrayList<>(capacity);
    }

    public MaxHeap() {
        this.data = new ArrayList<>();
    }

    public MaxHeap(E[] arr) {
        this.data = new ArrayList<>(Arrays.asList(arr));
        for (int i = parent(data.size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }


    private int size(){
        return data.size();
    }

    private boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int idx) {
        if (idx == 0) {
            throw new IllegalArgumentException("index-0 does not have parent.");
        }
        return (idx-1) / 2;
    }

    private int leftChild(int idx) {
        return idx * 2 + 1;
    }

    private int rightChild(int idx) {
        return idx * 2 + 2;
    }

    public void add(E e) {
        data.add(e);
        siftUp(data.size() - 1);
    }

    // 获取最大值
    public E findMax() {
        if (data.size() == 0) {
            throw new IllegalArgumentException("Can not find max element when heap is empty");
        }
        return data.get(0);
    }

    // 取出最大值
    public E extractMax() {
        E ret = findMax();

        swap(0, data.size() - 1);
        data.remove(data.size() - 1);
        siftDown(0);

        return ret;
    }

    // 替换元素，返回最大值
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    // 下滤
    private void siftDown(int idx) {
        while (leftChild(idx) < data.size()) {
            int j = leftChild(idx);
            if (j + 1 < data.size()
                    && data.get(j).compareTo(data.get(j+1)) > 0) {
                j++;
            }
            if (data.get(idx).compareTo(data.get(j)) > 0) {
                break;
            }
            swap(idx, j);
            idx = j;
        }
    }

    // 上浮
    private void siftUp(int idx) {
        int parentIdx = parent(idx);
        while (idx > 0 && data.get(parentIdx).compareTo(data.get(idx)) > 0) {
            swap(idx, parentIdx);
            idx = parentIdx;
            parentIdx = parent(idx);
        }
    }

    // 交换元素
    private void swap(int idx, int parent) {
        if (idx < 0 || idx >= data.size() || parent < 0 || parent >= data.size()) {
            throw new IllegalArgumentException("Index out of range");
        }
        E tmp = data.get(idx);
        data.set(idx, data.get(parent));
        data.set(parent, tmp);
    }
}
