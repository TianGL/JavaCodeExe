package cn.geliang.dsa.cache;

import cn.geliang.dsa.list.DoubleLinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname LRUCache
 * @Description TODO LRU缓存算法实现
 * @Date 2019-08-07
 * @Created by Geliang TIAN
 */
public class LRUCache<K, V> {
    private int capacity;
    private int size;
    private DoubleLinkedList<K, V> list;
    private Map<K, DoubleLinkedList.Node<K, V>> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new DoubleLinkedList<>();
        map = new HashMap<>();
    }

    /**
     * 添加缓存
     * @param key
     * @return
     */
    public V get(K key) {
        if (map.containsKey(key)) {
            DoubleLinkedList.Node<K, V> node = map.get(key);
            list.remove(node);
            list.addFirst(node);
            return node.getValue();
        }
        return null;
    }

    /**
     * 添加元素
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
            list.addFirst(node);
            return node.getValue();
        }
        DoubleLinkedList.Node<K, V> node = new DoubleLinkedList.Node<>(key, value);
        if (size == capacity) {
            DoubleLinkedList.Node<K, V> removeNode = list.remove();
            map.remove(removeNode.getKey());
        }
        map.put(key, node);
        list.appendFront(node);
        size++;
        return node.getValue();
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "list=" + list +
                '}';
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> lruCache = new LRUCache<>(2);
        lruCache.put(1,1);
        System.out.println(lruCache);
        lruCache.put(2,2);
        System.out.println(lruCache);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache);
    }
}
