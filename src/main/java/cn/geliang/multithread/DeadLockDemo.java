package cn.geliang.multithread;

/**
 * @Classname DeadLockDemo
 * @Description TODO
 * @Date 2019-07-23
 * @Created by Geliang TIAN
 */
public class DeadLockDemo implements Runnable {

    private static Object object1 = new Object();
    private static Object object2 = new Object();

    private boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (object1) {
                System.out.println(Thread.currentThread().getName() + "已经锁住obj1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2) {
                    System.out.println("1秒钟后，" + Thread.currentThread().getName() + "锁住obj2");
                }
            }
        } else {
            synchronized (object2) {
                System.out.println(Thread.currentThread().getName() + "已经锁住obj2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1) {
                    System.out.println("1秒钟后，" + Thread.currentThread().getName() + "锁住obj1");
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new DeadLockDemo(false), "线程一");
        Thread thread2 = new Thread(new DeadLockDemo(true), "线程二");
        thread1.start();
        thread2.start();
    }
}
