package com.sauzny.jkitchen_tool.uniqid;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicLongTest {

    private static final ExecutorService es = Executors.newFixedThreadPool(8);
    
    private static void esPreheat(){
        for(int i=0;i<100;i++){
            es.submit(() -> {
                System.out.print("-");
            });
        }
    }
    
    private static void workAtomicLongId(){

        es.submit(() -> {
            Thread current = Thread.currentThread();
            String str = "AtomicLong - " + current.getId() + " - " + AtomicLongId.genId();
            System.out.println(str);
        });
    }
    
    public static void main(String[] args) {

        // 线程池 预热
        esPreheat();
        
        long a = System.nanoTime();

        
        for(int i=0;i<1000;i++){
            workAtomicLongId();
        }

        long b = System.nanoTime();
        
        
        System.out.println("AtomicLong - 耗时：" + (b-a));
        
        es.shutdown();
    }
}
