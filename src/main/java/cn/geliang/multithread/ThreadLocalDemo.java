package cn.geliang.multithread;

import java.util.concurrent.TimeUnit;

/**
 * @Classname ThreadLocalDemo
 * @Description TODO
 * @Date 2019-08-28
 * @Created by Geliang TIAN
 */
public class ThreadLocalDemo {
    private static final ThreadLocal<Integer> TL_INT = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        new Thread1().start();
        new Thread2().start();
        TimeUnit.SECONDS.sleep(10);
        System.out.println(TL_INT.get());
    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                TL_INT.set(i);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread1: " + TL_INT.get());
            }
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            for (int i = 10; i < 20; i++) {
                TL_INT.set(i);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread2: " + TL_INT.get());
            }
        }
    }
}
