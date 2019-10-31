package cn.geliang.multithread;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Classname AtomicBooleanTest
 * @Description 测试CAS
 * @Date 2019-07-24
 * @Created by Geliang TIAN
 */
public class AtomicBooleanTest implements Runnable{
        private static AtomicBoolean flag = new AtomicBoolean(true);

    public static void main(String[] args) {
        AtomicBooleanTest ast = new AtomicBooleanTest();
        Thread thread1 = new Thread(ast, "线程1");
        Thread thread = new Thread(ast,"线程2");
        thread1.start();
        thread.start();
    }

    public void run() {
        System.out.println("开始:"+Thread.currentThread().getName()+";flag="+flag.get());
        if (flag.compareAndSet(true,false)){
            System.out.println(Thread.currentThread().getName()+" = "+flag.get());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag.set(true);
        }else{
            System.out.println("重试机制thread:"+Thread.currentThread().getName()+";flag = "+flag.get());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            run();
        }

    }
}
