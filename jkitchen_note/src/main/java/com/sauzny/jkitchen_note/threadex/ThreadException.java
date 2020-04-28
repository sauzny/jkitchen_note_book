package com.sauzny.jkitchen_note.threadex;

public class ThreadException implements Runnable {
    @Override
    public void run() {
        System.out.println("RuntimeException");
        throw new RuntimeException();
    }
}