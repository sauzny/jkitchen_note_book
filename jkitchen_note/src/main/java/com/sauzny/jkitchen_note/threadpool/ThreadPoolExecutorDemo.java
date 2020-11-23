package com.sauzny.jkitchen_note.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

public class ThreadPoolExecutorDemo {

    // 对于一些需要关闭的资源，使用ThreadLocal来保存。
    // 各个线程需要手动编写代码将需要关闭的实例放在其中，在出现未知异常时 可以关闭
    // 这里举例使用了 Integer ，只是为了验证效果
    // 实际当中，比如 java.sql.Connection。但是这种实例最好遵循【哪里创建哪里关闭】的原则
    // 最好是，线程内创建，线程内关闭。
    // 这里只是举例一种防范措施，以备不时之需。

    // ThreadLocal 注意事项
    // 1. 线程池中的线程复用，出现脏读
    // 2. 避免内存泄漏，一般在使用时都会将ThreadLocal设置为静态字段，这时候当线程执行完成后，KV中的V是不会自动回收的，所以要在使用完后及时调用remove()方法清理
    public static ThreadLocal<Integer> someNeedCloasResourcesDemo = ThreadLocal.withInitial(() -> null);

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

    // 测试 有一个线程 出异常之后，线程池会不会自动重建一个新的线程
    public static void foo02(){

        // 创建线程池，并设置自定义的统一异常抓捕
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolExecutors.newFixedThreadPool(4, "我的自定义线程", (thread, e) -> {
            System.out.println("被搞坏的线程id : " + thread.getId());
            e.printStackTrace();

            // 获取需要关闭的资源
            Integer integer = someNeedCloasResourcesDemo.get();
            System.out.println("print someNeedCloasResourcesDemo = " + integer);
        });

        // 输出线程数
        System.out.println(threadPoolExecutor.getCorePoolSize());

        // 输出每个线程id
        for (int i = 0; i < 4; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getId());
                LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
            });
        }

        LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(5));

        // 输出线程数
        System.out.println("===========================================");
        System.out.println(threadPoolExecutor.getCorePoolSize());

        // 输出每个线程id
        for (int i = 0; i < 4; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getId());
                LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
            });
        }

        // 搞坏一个异常
        threadPoolExecutor.execute(() -> {
            // 先清理一次，避免出现上次设置的值被复用
            someNeedCloasResourcesDemo.remove();
            // 在出现异常的线程中，举例 99 ，会被我们自定义的异常捕获，捕获到
            someNeedCloasResourcesDemo.set(99);
            Integer.parseInt("aaa");
        });


        // 输出线程数
        LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(5));

        // 输出每个线程id
        System.out.println("===========================================");
        System.out.println(threadPoolExecutor.getCorePoolSize());

        for (int i = 0; i < 4; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getId());
                LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
            });
        }

        // 线程池关闭前，remove，避免内存泄露
        someNeedCloasResourcesDemo.remove();

        threadPoolExecutor.shutdown();
    }

    public static void foo03(){

        // 创建线程池，并设置自定义的统一异常抓捕
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolExecutors.newFixedThreadPool(4, "我的自定义线程", (thread, e) -> {
            System.out.println("统一异常抓捕:" + e.getMessage());
            throw new RuntimeException(e);
        });

        Future<Integer> future = threadPoolExecutor.submit(() -> Integer.parseInt("aaa"));

        try {
            future.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("ExecutionException:" + e.getMessage());
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("TimeoutException:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutorDemo.foo03();
    }
}
