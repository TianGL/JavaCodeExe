package cn.geliang.multithread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname ExecutorTest
 * @Description TODO
 * @Date 2019-09-18
 * @Created by Geliang TIAN
 */
public class ExecutorTest {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("线程名称-%s").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 100,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(), threadFactory);
        threadPoolExecutor.execute(new TaskTest(1000));
        threadPoolExecutor.execute(new TaskTest(10000));
        threadPoolExecutor.shutdown();

    }

    public static class TaskTest implements Runnable {

        private int sleepTime = 1000;

        public TaskTest() {
        }

        public TaskTest(int sleepTime) {
            this.sleepTime = sleepTime;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(sleepTime);
                int i = atomicInteger.incrementAndGet();
                latch.countDown();
                latch.await();
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
