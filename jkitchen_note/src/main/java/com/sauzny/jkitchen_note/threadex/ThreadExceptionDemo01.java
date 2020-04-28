package com.sauzny.jkitchen_note.threadex;

import java.util.concurrent.*;

public class ThreadExceptionDemo01 {

    public void foo00() {
        new Thread(() -> {
            while (true) {
                System.out.println("持续输出");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void foo01() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<Integer> future = executorService.submit(() -> {
            return Integer.parseInt("AAAA");
        });

        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }


    public void foo02() {
        new Thread(new ThreadException()).start();
    }


    public void foo03() {

        // 设置默认的线程异常捕获处理器
        Thread.setDefaultUncaughtExceptionHandler(new MyUnchecckedExceptionhandler());

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try {
            // 这里 execute 才能抓到
            // submit 是不行的
            executorService.execute(new ThreadException());
        } catch (Exception e) {
            System.out.println("这里是不会输出的");
        }

    }

    public void foo04(){
        //1.创建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>()) {
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                if (r instanceof Thread) {
                    if (t != null) {
                        //处理捕获的异常
                    }
                } else if (r instanceof FutureTask) {
                    FutureTask futureTask = (FutureTask) r;
                    try {
                        futureTask.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        //处理捕获的异常
                    }
                }

            }
        };

        // 这两个都可以被抓到了
        threadPoolExecutor.execute(new ThreadException());
        threadPoolExecutor.submit(new ThreadException());
    }


    public static void main(String[] args) {
        ThreadExceptionDemo01 demo01 = new ThreadExceptionDemo01();
        demo01.foo00();
        //demo01.foo01();
        //demo01.foo02();
        demo01.foo03();
    }
}
