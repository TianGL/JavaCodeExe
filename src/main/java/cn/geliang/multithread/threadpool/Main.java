package cn.geliang.multithread.threadpool;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019-08-13
 * @Created by Geliang TIAN
 */
public class Main {
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        ThreadQueueTest();

    }

    /**
     * 线程安全队列测试
     */
    public static void ThreadQueueTest() {
        final ThreadQueue<Integer> queue = new ThreadQueue<>(3);
        final Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    queue.put(i);
                    System.out.println("生产：" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        final Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    Integer get = queue.pop();
                    System.out.println("消费：" + get);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        queue.setBlocked(true);
        producer.start();
        consumer.start();
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
