package cn.geliang.multithread.threadpool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname ThreadQueue
 * @Description TODO 线程安全队列
 * @Date 2019-08-13
 * @Created by Geliang TIAN
 */
public class ThreadQueue<T> {
    private int maxSize;
    private Lock lock = new ReentrantLock();;
    private List<T> queue = new LinkedList<>();;
    private AtomicBoolean isBlocked = new AtomicBoolean(false);
    private Condition getCondition = lock.newCondition();
    private static final int WAIT_TIME = 2;

    public ThreadQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * 设置队列是否阻塞
     * @param flag
     * @return
     */
    public boolean setBlocked(boolean flag) {
        return isBlocked.compareAndSet(!flag, flag);
    }

    public int size(){
        int res = -1;
        if (lock.tryLock()) {
            res = queue.size();
            lock.unlock();
        }
        return res;
    }

    /**
     * 添加元素
     * @param data
     * @return
     */
    public T put(T data) {
        T resData = null;
        if (maxSize > 0 && size() != maxSize) {
            if (lock.tryLock()) {
                if (size() != maxSize) {
                    queue.add(data);
                    resData = data;
                    getCondition.signal();
                }
                lock.unlock();
            }
        }
        return resData;
    }

    /**
     * 批量添加
     * @param dataList
     * @return
     */
    public boolean batchPut(final List<T> dataList) {
        boolean isSuccess = false;
        if (lock.tryLock()) {
            int newSize = size() + dataList.size();
            if (newSize < maxSize) {
                queue.addAll(dataList);
                isSuccess = true;
                getCondition.signal();
            }
            lock.unlock();
        }
        return isSuccess;
    }

    /**
     * 弹出数据
     * @return
     */
    public T pop(){
        return pop(WAIT_TIME);
    }

    /**
     * 弹出，添加阻塞等待时间
     * @param time
     * @return
     */
    public T pop(int time){
        T popData = null;
        if (maxSize > 0) {
            if (lock.tryLock()) {
                if (size() == 0 && isBlocked.get()) {
                    try {
                        getCondition.await(time, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (size() > 0) {
                    popData = queue.remove(0);
                } else {
                    lock.unlock();
                    throw new IndexOutOfBoundsException("-1");
                }
            }
        }
        return popData;
    }

    /**
     * 获取数据
     * @param index
     * @return
     */
    public T get(int index) {
        T getData = null;
        if (maxSize > 0) {
            if (lock.tryLock()) {
                if (size() == 0 && isBlocked.get()) {
                    try {
                        getCondition.await(WAIT_TIME, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (size() > 0) {
                    getData = queue.get(index);
                }
                lock.unlock();
            }
        }
        return getData;
    }

}
