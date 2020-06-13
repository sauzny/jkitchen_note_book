package com.sauzny.jkitchen_note.threadex;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class LogExceptionThreadFactory implements ThreadFactory {

    private static final ThreadFactory DEFAULT_THREAD_FACTORY = Executors.defaultThreadFactory();

    @Override
    public Thread newThread(Runnable r) {
        if (r == null) throw new NullPointerException();

        Thread t = DEFAULT_THREAD_FACTORY.newThread(r);

        t.setUncaughtExceptionHandler((thread, e) -> System.out.println("Uncaught Exception:" + e.getMessage()));

        return t;
    }
}
