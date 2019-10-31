package cn.geliang.dsa.cache;

import cn.geliang.dsa.list.DoubleLinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname FIFOCache
 * @Description TODO 先入先出缓存算法
 * @Date 2019-08-06
 * @Created by Geliang TIAN
 */
public class FIFOCache<K, V> {
    private int capacity;
    private int size;
    private DoubleLinkedList<K, V>  list;
    private Map<K, DoubleLinkedList.Node<K, V>> map;

    public FIFOCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.list = new DoubleLinkedList<>();
        this.map = new HashMap<>();
    }

    /**
     * 获取指定key的value值
     * @param key
     * @return
     */
    public V get(K key) {
        if (map.containsKey(key)) {
            return map.get(key).getValue();
        }
        return null;
    }

    /**
     * 插入key-value
     * @param key
     * @param value
     * @return
     */
    public V put(K key, V value) {
        if (capacity == 0) {
            return null;
        }
        if (map.containsKey(key)) {
            DoubleLinkedList.Node<K, V> node = map.get(key);
            list.remove(node);
            node.setValue(value);
            list.append(node);
            return node.getValue();
        } else {
            if (size == capacity) {
                // 先入先出，删除头节点
                DoubleLinkedList.Node node = list.pop();
                map.remove(node.getKey());
                size--;
            }
            DoubleLinkedList.Node<K, V> newNode = new DoubleLinkedList.Node(key, value);
            list.append(newNode);
            map.put(key, newNode);
            size++;
            return newNode.getValue();
        }
    }

    @Override
    public String toString() {
        return "FIFOCache{" +
                "list=" + list +
                '}';
    }


    public static void main(String[] args) {
        FIFOCache<Integer, Integer> fifoCache = new FIFOCache<>(2);
        fifoCache.put(1, 1);
        System.out.println(fifoCache);
        fifoCache.put(2, 2);
        System.out.println(fifoCache);
        System.out.println(fifoCache.get(1));
        fifoCache.put(3, 3);
        System.out.println(fifoCache);
        System.out.println(fifoCache.get(2));
        System.out.println(fifoCache);
        fifoCache.put(4, 4);
        System.out.println(fifoCache);
        System.out.println(fifoCache.get(1));
    }
}
