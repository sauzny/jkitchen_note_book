package com.sauzny.jkitchen_note.future;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * *************************************************************************
 * @文件名称: CompletableFutureDemo01.java
 *
 * @包路径  : com.sauzny.jkitchen_note.future
 *				 
 * @版权所有: Personal xinxin (C) 2017
 *
 * @类描述:   基本用法
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2017年12月28日 - 下午6:16:24 
 *	
 **************************************************************************
 */
public class CompletableFutureDemo01 {
    
    /**
     * 实际情况是不会有人这么用……
     * 写这个demo就是了解一下看看……
     */
    
    /**
        foo01 没有考虑异常的情况
        foo02 考虑异常的情况，使用 completableFuture.completeExceptionally(e);
     */

    @Test
    public static void foo01(){
        CompletableFuture<String> completableFuture = new CompletableFuture<String>();
        new Thread(() -> {//模拟执行耗时任务
                System.out.println("task doing...");
                try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //告诉completableFuture任务已经完成
                completableFuture.complete("result");
        }).start();
        
        //获取任务结果，如果没有完成会一直阻塞等待
        String result;
        try {
            result = completableFuture.get();
            System.out.println("计算结果:"+result);
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void foo02(){
        
        CompletableFuture<String> completableFuture= new CompletableFuture<String>();
        
        new Thread(() -> {
            try {
                //模拟执行耗时任务
                System.out.println("task doing...");
                try {
                    Thread.sleep(3000);
                    completableFuture.complete("result");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                throw new RuntimeException("抛异常了");
            }catch (Exception e) {
                //告诉completableFuture任务发生异常了
                completableFuture.completeExceptionally(e);
            }
        }).start();
        
        //获取任务结果，如果没有完成会一直阻塞等待
        String result;
        try {
            result = completableFuture.get();
            System.out.println("计算结果:"+result);
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
