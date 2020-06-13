package com.sauzny.jkitchen_note.threadpool;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class ThreadPoolExecutorDemo {

    public static void foo01() {

        // 创建线程池，并设置自定义的统一异常抓捕
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolExecutors.newFixedThreadPool(4, "我的自定义线程", (thread, e) -> {

        });

        // 队列堆积数 > 线程池设置的最大线程数
        // 相当于阻塞在此处
        while (threadPoolExecutor.getQueue().size() > threadPoolExecutor.getMaximumPoolSize()) {
            // 睡 30 毫秒
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(30));
        }

        // 向线程池提交任务
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(10));
                System.out.println(Thread.currentThread().getName() + " park 10 毫秒，然后打印");
            });
        }

        threadPoolExecutor.shutdown();

    }

    public static void main(String[] args) {
        ThreadPoolExecutorDemo.foo01();
    }
}
