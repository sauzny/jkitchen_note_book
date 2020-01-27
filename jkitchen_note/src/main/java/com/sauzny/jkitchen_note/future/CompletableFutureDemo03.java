package com.sauzny.jkitchen_note.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//import org.junit.Test;

import com.sauzny.jkitchen_note.Print;
import org.junit.jupiter.api.Test;

/**
 * *************************************************************************
 * @文件名称: CompletableFutureDemo03.java
 *
 * @包路径  : com.sauzny.jkitchen_note.future
 *				 
 * @版权所有: Personal xinxin (C) 2017
 *
 * @类描述:   10类API说明
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2017年12月29日 - 下午1:27:35 
 *	
 **************************************************************************
 */
public class CompletableFutureDemo03 {

    @Test
    public void test_acceptEither(){

        ExecutorService executor = Executors.newFixedThreadPool(5);  
        
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(TestFunc::f1, executor);
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(TestFunc::f2, executor);
        
        CompletableFuture<Void> result_acceptEither = cf1.acceptEither(cf2, TestFunc::consumer);
        
        // cf1.acceptEitherAsync(other, action);
        // cf1.acceptEitherAsync(other, action, executor);
        
        Print.sysoutThree("acceptEither","出现第一个完成的future时，就继续执行", result_acceptEither.join());
    }

    @Test
    public void test_applyToEither(){

        ExecutorService executor = Executors.newFixedThreadPool(5);  
        
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(TestFunc::f1, executor);
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(TestFunc::f2, executor);
        
        CompletableFuture<Integer> result_applyToEither = cf1.applyToEither(cf2, String::length);
        
        // cf1.applyToEitherAsync(other, fn);
        // cf1.applyToEitherAsync(other, fn, executor);
        Print.sysoutThree("applyToEither","出现第一个完成的future时，就继续执行", result_applyToEither.join());
    }



    @Test
    public void test_runAfterBoth(){

        ExecutorService executor = Executors.newFixedThreadPool(5);  
        
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(TestFunc::f1, executor);
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(TestFunc::f2, executor);
        
        CompletableFuture<Void> result_runAfterBoth = cf1.runAfterBoth(cf2, () -> System.out.println("hello world"));
        
        // cf1.runAfterBothAsync(other, action);
        // cf1.runAfterBothAsync(other, action, executor);
        
        Print.sysoutThree("runAfterBoth","两个都执行完成后。就开始一个Runable", result_runAfterBoth.join());
        
    }

    @Test
    public void test_runAfterEither(){

        ExecutorService executor = Executors.newFixedThreadPool(5);  
        
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(TestFunc::f1, executor);
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(TestFunc::f2, executor);
        
        CompletableFuture<Void> result_runAfterEither = cf1.runAfterEither(cf2, () -> System.out.println("hello world"));
        
        // cf1.runAfterEitherAsync(other, action);
        // cf1.runAfterEitherAsync(other, action, executor);
        
        Print.sysoutThree("runAfterEither","出现第一个执行结束的Future。就开始一个Runable", result_runAfterEither.join());
    }
    
    /**
     * @描述: thenAccept，注册完成事件，可以理解为回调函数
     * @返回 void
     * @创建人  ljx 创建时间 2017年12月29日 上午10:32:18
     */
    @Test
    public void test_thenAccept(){

        ExecutorService executor = Executors.newFixedThreadPool(5);  
        
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(TestFunc::f1, executor);
        // 注册完成事件，就是很单纯的注册事件
        CompletableFuture<Void> resultThenAccept = cf1.thenAccept(result->System.out.println("task1 done,result:"+result));
        // cf1.thenAcceptAsync(action)
        // cf1.thenAcceptAsync(action, executor);
        Print.sysoutThree("thenAccept","注册完成事件，可以理解为回调函数", resultThenAccept.join());

    }

    @Test
    public void test_thenAcceptBoth(){

        ExecutorService executor = Executors.newFixedThreadPool(5);  
        
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(TestFunc::f1, executor);

        // 两个Future注册事件，参考thenCombine。
        // 与thenCombine的参数对比：
        // thenCombine-> CompletionStage,BiFunction
        // thenAcceptBoth-> CompletionStage,BiConsumer
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(TestFunc::f2, executor);
        CompletableFuture<Void> resultThenAccept = cf1.thenAcceptBoth(cf2, (r1, r2) -> System.out.println(r1+" "+r2));
        //cf1.thenAcceptBothAsync(other, action);
        //cf1.thenAcceptBothAsync(other, action, executor);
        Print.sysoutThree("thenAcceptBoth","为两个future注册完成事件，可以理解为回调函数，两个都完成", resultThenAccept.join());

    }

    /**
     * @描述: 转换，返回类型还是一个CompletableFuture，设计这个api的目的是可以实现把CompletableFuture串联起来
     * @返回 void
     * @创建人  ljx 创建时间 2017年12月29日 上午10:49:02
     */
    @Test
    public void test_thenApply(){

        ExecutorService executor = Executors.newFixedThreadPool(5);  
        
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(TestFunc::f1, executor);
        
        // 
        CompletableFuture<Integer> resultThenApply = cf1.thenApply(String::length);
        
        // cf1.thenApplyAsync(fn);
        // cf1.thenApplyAsync(fn, executor);
        Print.sysoutThree("thenApply","将future结果继续处理，返回一个CompletableFuture", resultThenApply.join());
    }
    
    /**
     * @描述: thenCombine，合并两个任务的结果 
     * @返回 void
     * @创建人  ljx 创建时间 2017年12月29日 上午9:33:25
     */
    @Test
    public void test_thenCombine(){
        
        ExecutorService executor = Executors.newFixedThreadPool(5);  
        
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(TestFunc::f1, executor);
        
        
        // 合并两个任务的结果 
        // thenCombine
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(TestFunc::f2, executor);
        CompletableFuture<String> resultThenCombine01 = cf1.thenCombine(cf2, (r1, r2) -> r1+" "+r2);
        // 多开一个线程去执行
        // cf1.thenCombineAsync(other, fn);
        // cf1.thenCombineAsync(other, fn, executor);
        
        // 打印结果
        Print.sysoutThree("CompletableFuture.thenCombine","合并两个任务的结果", resultThenCombine01.join());
    }
    
    /**
     * @描述: thenCompose，第一个任务完成后的result，传递给第二个Future使用。
     * @返回 void
     * @创建人  ljx 创建时间 2017年12月29日 上午9:33:25
     */
    @Test
    public void test_thenCompose(){
        
        ExecutorService executor = Executors.newFixedThreadPool(5);  
        
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(TestFunc::f1, executor);
        
        // 第一个任务完成后的result，传递给第二个Future使用。
        // thenCompose
        CompletableFuture<String> resultThenCompose01 = cf1.thenCompose(result -> CompletableFuture.supplyAsync(() -> TestFunc.f5(result), executor));
        // 多开一个线程去执行
        // cf1.thenComposeAsync(fn)
        // cf1.thenComposeAsync(fn, executor);
        // 打印结果
        Print.sysoutThree("CompletableFuture.thenCompose","任意一个完成，获取第一个完成的结果", resultThenCompose01.join());
    }

    @Test
    public void test_thenRun(){

        ExecutorService executor = Executors.newFixedThreadPool(5);  
        
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(TestFunc::f1, executor);
        
        CompletableFuture<Void> result_thenRun = cf1.thenRun(() -> System.out.println("一个Runable") );
        
        // cf1.thenRunAsync(action);
        // cf1.thenRunAsync(action, executor);
        
        Print.sysoutThree("thenRun","得到上一步的结果时。就开始一个Runable", result_thenRun.join());
        
    }

}
