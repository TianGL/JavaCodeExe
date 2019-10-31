package cn.geliang.multithread.threadpool;

import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * @Classname Task
 * @Description TODO
 * @Date 2019-08-14
 * @Created by Geliang TIAN
 */
public abstract class Task<V> implements Callable<V> {
    private String id;

    public Task() {
        id = UUID.randomUUID().toString();
    }
}
