package cn.geliang.dsa.cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @Classname LFUCache
 * @Description TODO
 * @Date 2019-08-07
 * @Created by Geliang TIAN
 */
public class LFUCache<K, V> {

    private int capacity;
    private int size;
    private Map<K, V> kvMap;
    private Map<K, LFUNode<K>> keyFreqMap;
    private LFUNode<K> head;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        kvMap = new HashMap<>();
        keyFreqMap = new HashMap<>();
        head = null;
    }

    /**
     * 获取value
     * @param key
     * @return
     */
    public V get(K key) {
        if (!kvMap.containsKey(key)) {
            return null;
        }
        update(key);
        return kvMap.get(key);
    }

    /**
     * 添加k-v
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        if (kvMap.containsKey(key)) {
            update(key);
        } else {
            if (capacity == 0) {
                return;
            } else if (size == capacity) {
                removeFirst();
            }
            if (head == null) {
                head = new LFUNode<K>(1);
            } else if (head.freq != 1) {
                LFUNode<K> node = new LFUNode<K>();
                node.next = head;
                head.prev = node;
                head = node;
            }
            keyFreqMap.put(key, head);
            head.keys.add(key);
        }
        kvMap.put(key, value);
        size++;
    }

    /**
     * 更新key，对应的频率+1
     * @param key
     */
    private void update(K key) {
        LFUNode<K> node = keyFreqMap.get(key);

        // 判断是否需要新建立节点
        if (node.next == null) {
            node.next = new LFUNode<K>(node.freq + 1);
            node.next.prev = node;
        } else if (node.next.freq != node.freq+1) {
            LFUNode<K> nextNode = node.next;
            node.next = new LFUNode<K>(node.freq + 1);
            node.next.prev = node;
            node.next.next = nextNode;
            nextNode.prev = node.next;
        }
        LFUNode<K> curNode = node.next;
        curNode.keys.add(key);

        // 更新map
        node.keys.remove(key);
        keyFreqMap.put(key, curNode);
        if (node.keys.isEmpty()) {
            remove(node);
        }
    }

    /**
     * 删除使用频率最低的key
     */
    private void removeFirst() {
        K removeKey= head.keys.iterator().next();
        kvMap.remove(removeKey);
        keyFreqMap.get(removeKey).keys.remove(removeKey);
        keyFreqMap.remove(removeKey);
        if (head.keys.size() == 0) {
            remove(head);
        }
        size--;
    }

    /**
     * 删除节点
     * @param node
     */
    private void remove(LFUNode<K> node) {
        if (node == head){
            head = head.next;
            if (head!=null){
                head.prev = null;
            }
            return;
        }
        node.prev.next = node.next;
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        node.prev = null;
        node.next = null;
    }

    /**
     * LFU内部节点类，双向链表
     * @param <K>
     */
    private static class LFUNode<K>{
        private int freq;
        private LinkedHashSet<K> keys;
        private LFUNode<K> prev;
        private LFUNode<K> next;

        public LFUNode(int freq) {
            this.freq = freq;
            keys = new LinkedHashSet<>();
        }

        public LFUNode() {
            this.freq = 1;
            keys = new LinkedHashSet<>();
        }
    }

    @Override
    public String toString() {
        return "LFUCache{" +
                "kvMap=" + kvMap +
                '}';
    }

    public static void main(String[] args) {
        LFUCache<Integer, Integer> cache = new LFUCache<>(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        System.out.println(cache);
        cache.get(1);
        cache.put(4,4);
        System.out.println(cache);
        cache.get(4);
        cache.put(5, 5);
        System.out.println(cache);
        System.out.println(cache.get(6));
    }
}
