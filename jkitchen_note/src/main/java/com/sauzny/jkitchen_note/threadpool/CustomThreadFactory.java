package com.sauzny.jkitchen_note.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

public class CustomThreadFactory implements ThreadFactory {

    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;
    private final BiConsumer<Thread, Throwable> biConsumer;

    public CustomThreadFactory(String name, BiConsumer<Thread, Throwable> biConsumer) {
        this.namePrefix = name + "-pool-" + poolNumber.getAndIncrement() + "-thread-";
        this.biConsumer = biConsumer;
    }

    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, namePrefix + threadNumber.getAndIncrement());
        if (t.isDaemon())
            t.setDaemon(false);
        if (t.getPriority() != Thread.NORM_PRIORITY)
            t.setPriority(Thread.NORM_PRIORITY);

        // 抓捕异常
        t.setUncaughtExceptionHandler(this.biConsumer::accept);

        return t;
    }
}
