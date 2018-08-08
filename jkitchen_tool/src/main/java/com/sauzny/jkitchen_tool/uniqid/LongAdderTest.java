package com.sauzny.jkitchen_tool.uniqid;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LongAdderTest {

    private static final ExecutorService es = Executors.newFixedThreadPool(8);
    
    private static void esPreheat(){
        for(int i=0;i<100;i++){
            es.submit(() -> {
                System.out.print("-");
            });
        }
    }
    
    private static void workLongAdderId(){

        es.submit(() -> {
            Thread current = Thread.currentThread();
            String str = "LongAdderId - " + current.getId() + " - " + LongAdderId.genId();
            System.out.println(str);
        });
    }
    
    public static void main(String[] args) {

        // 线程池 预热
        esPreheat();
        System.out.println();
        
        long a = System.nanoTime();
        
        for(int i=0;i<1000;i++){
            workLongAdderId();
        }
        
        long b = System.nanoTime();
        
        System.out.println("AtomicLong - 耗时：" + (b-a));
        
        es.shutdown();
    }
}
