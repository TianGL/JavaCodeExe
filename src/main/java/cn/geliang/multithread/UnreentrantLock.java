package cn.geliang.multithread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Classname UnreentrantLock
 * @Description TODO 利用自旋锁模拟不可重入锁
 * @Date 2019-08-13
 * @Created by Geliang TIAN
 */
public class UnreentrantLock {
    private AtomicReference<Thread> owner = new AtomicReference<Thread>();

    public void lock() {
        Thread current = Thread.currentThread();
        // 这句是很经典的“自旋”语法，AtomicInteger中也有
        for (;;) {
            System.out.println(1);
            if (!owner.compareAndSet(null, current)) {
                //return;
            }
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        owner.compareAndSet(current, null);
    }

    public static void main(String[] args) {
        UnreentrantLock unreentrantLock = new UnreentrantLock();
        unreentrantLock.lock();
        System.out.println("finish...");
    }
}
