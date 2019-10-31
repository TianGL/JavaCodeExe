package cn.geliang.multithread;

/**
 * @Classname ThreadSecurity
 * @Description 测试多线程安全
 * @Date 2019-07-24
 * @Created by Geliang TIAN
 */
public class ThreadSecurity implements Runnable
{
    private static volatile int num1 = 0;

    private int times;

    public ThreadSecurity(int times) {
        this.times = times;
    }

    public void run() {
        // i++多线程测试
        for (int i = 0; i < times; i++) {
            //try {
            //    Thread.sleep(3);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
            num1++;
        }
    }

    public static int getNum1() {
        return num1;
    }

    public static void main(String[] args) throws InterruptedException {
        // i++测试
        Thread thread1 = new Thread(new ThreadSecurity(1000000), "线程一");
        Thread thread2 = new Thread(new ThreadSecurity(1000000), "线程二");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(num1);
    }
}
