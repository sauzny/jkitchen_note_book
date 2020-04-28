package com.sauzny.jkitchen_note.threadex;

public class MyUnchecckedExceptionhandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("自定义Thread.UncaughtExceptionHandler，捕获异常处理方法：" + e);
    }
}
