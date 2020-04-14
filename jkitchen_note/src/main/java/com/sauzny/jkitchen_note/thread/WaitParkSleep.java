package com.sauzny.jkitchen_note.thread;

import java.util.concurrent.locks.LockSupport;

public class WaitParkSleep {

    private final String anyTHing = "";

    public void foo01(){

        // 线程1 wait
        Thread thread1 = new Thread(() ->{

            try {
                // 必须获得对象上的锁后，才可以执行该对象的wait方法。否则程序会在运行时抛出IllegalMonitorStateException异常。
                synchronized (anyTHing){
                    // 线程的状态是WAITING状态
                    // 调用wait()方法后，线程进入休眠的同时，会释放持有的该对象的锁，这样其他线程就能在这期间获取到锁了。
                    anyTHing.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        // 线程2 notify
        Thread thread2 = new Thread(() ->{
            synchronized (anyTHing) {
                // 调用Object对象的notify()或者notifyAll()方法可以唤醒因为wait()而进入等待的线程。
                // notify是随机唤醒一个被阻塞的线程
                // notifyAll是唤醒所有线程
                //anyTHing.notify();
                anyTHing.notifyAll();
            }
        });

        thread1.start();
        thread2.start();
    }

    public void foo02(){

        // 线程1 park
        // 线程状态为WAITING
        // park方法不会抛出InterruptedException，但是它也会响应中断
        // 并且可以手动通过Thread.currentThread().isInterrupted()获取到中断位
        Thread thread1 = new Thread(() -> {
            System.out.println("park begin");
            //等待获取许可
            LockSupport.park();
            //输出thread over.true
            System.out.println("thread over." + Thread.currentThread().isInterrupted());

        });

        // 线程2 unpark 线程1
        Thread thread2 = new Thread(() -> LockSupport.unpark(thread1));

        thread1.start();

        // 中断线程
        // thread1会响应这个中断
        // thread1.interrupt();

        thread2.start();
    }
    public void foo03(){
        try {

            // 状态应该是TIMED_WAITING，表示休眠一段时间
            // 该方法会抛出InterruptedException异常，这是受检查异常，调用者必须处理
            // 通过sleep方法进入休眠的线程不会释放持有的锁，因此，在持有锁的时候调用该方法需要谨慎
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
