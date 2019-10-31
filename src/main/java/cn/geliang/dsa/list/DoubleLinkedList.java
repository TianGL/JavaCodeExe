package cn.geliang.dsa.list;

import java.util.Objects;

/**
 * @Classname DoubleLinkedList
 * @Description TODO 实现双向链表
 * @Date 2019-08-05
 * @Created by Geliang TIAN
 */
public class DoubleLinkedList<K, V> {

    private int size = 0;
    private Node<K, V> head;
    private Node<K, V> tail;

    public DoubleLinkedList() {

    }

    /**
     * 插入头节点
     *
     * @param node
     * @return
     */
    public Node<K, V> addFirst(Node<K, V> node) {
        if (node == null || node.key == null || node.value == null) {
            return null;
        }
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
        return head;
    }

    /**
     * 添加尾部节点
     *
     * @param node
     * @return
     */
    public Node<K, V> addEnd(Node<K, V> node) {
        if (node == null || node.key == null || node.value == null) {
            return null;
        }
        if (tail == null) {
            tail = node;
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
        return tail;
    }

    /**
     * 删除节点
     *
     * @param node
     * @return
     */
    public Node<K, V> remove(Node<K, V> node) {
        if (node == null) {
            // 为空，删除尾部节点
            return remove();
        } else if (node == tail) {
            return remove();
        } else if (node == head) {
            return removeFirst();
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            size--;
            return node;
        }
    }

    /**
     * 删除节点，无参
     *
     * @return
     */
    public Node<K, V> remove() {
        if (tail == null) {
            size--;
            return null;
        }
        Node<K, V> node = tail;
        tail = node.prev;
        if (node.prev != null) {
            node.prev.next = null;
        }
        node.prev = null;
        size--;
        return node;
    }


    /**
     * 删除头部节点
     *
     * @return
     */
    private Node<K, V> removeFirst() {
        if (head == null) {
            size--;
            return null;
        }
        Node<K, V> node = head;
        head = node.next;
        if (node.next != null) {
            node.next.prev = null;
        }
        node.next = null;
        size--;
        return node;

    }

    /**
     * 弹出节点（头）
     *
     * @return
     */
    public Node<K, V> pop() {
        return removeFirst();
    }

    /**
     * append，尾部添加
     *
     * @param node
     * @return
     */
    public Node<K, V> append(Node<K, V> node) {
        return addEnd(node);
    }

    /**
     * appendFront，往头部添加
     *
     * @param node
     * @return
     */
    public Node<K, V> appendFront(Node<K, V> node) {
        return addFirst(node);
    }

    public int size() {
        return this.size;
    }

    /**
     * 内部节点类
     *
     * @param <K>
     * @param <V>
     */
    public static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> prev = null;
        private Node<K, V> next = null;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    /**
     * 打印双向链表
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DoubleLinkedList{");
        if (head != null) {
            stringBuilder.append("[" + head.key + ", " + head.value + "]");
            Node<K, V> node = head.next;
            while (node != null) {
                stringBuilder.append(", " + "[" + node.key + ", " + node.value + "]");
                node = node.next;
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer, Integer> doubleLinkedList = new DoubleLinkedList<>();
        Node<Integer, Integer>[] nodes = new Node[10];
        for (int i = 0; i < 10; i++) {
            nodes[i] = new Node((float) i, i);
        }
        doubleLinkedList.append(nodes[0]);
        doubleLinkedList.append(nodes[1]);
        doubleLinkedList.addFirst(nodes[2]);
        doubleLinkedList.remove();
        Node<Integer, Integer> node = doubleLinkedList.pop();
        System.out.println(doubleLinkedList);
    }
}
