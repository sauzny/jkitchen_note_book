package com.sauzny.jkitchen_note.threadpool;

import java.util.concurrent.*;
import java.util.function.BiConsumer;


// ThreadPoolExecutor 可以获取队列信息，配置信息
public final class ThreadPoolExecutors {

    private ThreadPoolExecutors(){}

    public static ThreadPoolExecutor newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

    public static ThreadPoolExecutor newFixedThreadPool(int nThreads, ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                threadFactory);
    }

    public static ThreadPoolExecutor newFixedThreadPool(int nThreads, String name, BiConsumer<Thread, Throwable> biConsumer) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                new CustomThreadFactory(name, biConsumer));
    }
}
