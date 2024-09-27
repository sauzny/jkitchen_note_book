package org.example.lab.jdk21;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
虚拟线程：创建10000个线程，每个线程被创建出来后休眠1s再结束，计算整个过程用时。
 */

public class Solution1 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try(var executor = Executors.newVirtualThreadPerTaskExecutor()){
            IntStream.range(0,10_000).forEach(i -> {
                executor.submit(()->{
                    Thread.sleep(Duration.ofSeconds(1));
                    return i;
                });
            });
        }
        long end = System.currentTimeMillis();
        System.out.println("use time:" + (end - start) + "ms");
    }
}
